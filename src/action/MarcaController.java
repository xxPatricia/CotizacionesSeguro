package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MarcaDAO;
import dao.ModeloDAO;
import entidad.Marca;
import service.ModeloService;

/**
 * Servlet implementation class MarcaController
 */
@WebServlet("/MarcaController")
public class MarcaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ModeloService modeloService = new ModeloService();
    MarcaDAO marcaDAO = new MarcaDAO();  
    ModeloDAO modeloDAO = new ModeloDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String accion = request.getParameter("accion");
    	
    	if(accion.equals("listarMarca")) { //1ER PASO DE ASEGURAMIENTO
    		listarMarca(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoMarca.jsp").forward(request, response);
    		
    	} else if (accion.equals("grabarMarca")) { //ULTIMO PASO
    		grabarMarca(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoMarca.jsp").forward(request, response);
    		
    	} else if (accion.equals("editarMarca")) { //ULTIMO PASO 
    		editarMarca(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoMarca.jsp").forward(request, response);
    		
    	} else if (accion.equals("eliminarMarca")) { //ULTIMO PASO 
    		eliminarMarca(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoMarca.jsp").forward(request, response);
    		
    	}
    }
    
    
    protected void eliminarMarca(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Integer idMar = Integer.parseInt(request.getParameter("idMar"));
    	
    	marcaDAO.eliminar(new Marca(idMar));
    	
    	listarMarca(request, response);
    }
    protected void editarMarca(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Integer idMar = Integer.parseInt(request.getParameter("idMar"));
    	
    	List<Marca> listaMarca = marcaDAO.listar();
    	Marca marcaEditable = marcaDAO.obtener(idMar);
    	
    	request.setAttribute("listaMarca", listaMarca);
    	request.setAttribute("marcaEditable", marcaEditable);
    }
    protected void grabarMarca(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String nombre = request.getParameter("txtNombre");
		Integer idMar = Integer.parseInt(request.getParameter("idMar"));
		
		Marca marca = new Marca();
		marca.setNombre(nombre);
		marca.setId(idMar);
		
    	if(idMar == 0){
    		marcaDAO.insertar(marca);
    	} else {
    		marcaDAO.actualizar(marca);
    	}
    	
    	listarMarca(request, response);
    }
    protected void listarMarca(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	List<Marca> listaMarca = marcaDAO.listar();
    	
    	Marca marcaEditable = new Marca();
    	marcaEditable.setId(0);
    	marcaEditable.setNombre("");
    	
    	request.setAttribute("listaMarca", listaMarca);
    	request.setAttribute("marcaEditable", marcaEditable);
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarcaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
