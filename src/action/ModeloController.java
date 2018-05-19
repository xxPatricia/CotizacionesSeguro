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
import entidad.Modelo;
import service.ModeloService;

/**
 * Servlet implementation class ModeloController
 */
@WebServlet("/ModeloController")
public class ModeloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ModeloService modeloService = new ModeloService();
    MarcaDAO marcaDAO = new MarcaDAO();  
    ModeloDAO modeloDAO = new ModeloDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModeloController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String accion = request.getParameter("accion");
    	
    	if(accion.equals("listarModelo")) { //1ER PASO DE ASEGURAMIENTO
    		listarModelo(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoModelo.jsp").forward(request, response);
    		
    	} else if (accion.equals("grabarModelo")) { //ULTIMO PASO
    		grabarModelo(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoModelo.jsp").forward(request, response);
    		
    	} else if (accion.equals("editarModelo")) { //ULTIMO PASO 
    		editarModelo(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoModelo.jsp").forward(request, response);
    		
    	} else if (accion.equals("eliminarModelo")) { //ULTIMO PASO 
    		eliminarModelo(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoModelo.jsp").forward(request, response);
    		
    	}
    }
    
    
    protected void eliminarModelo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Integer idMod = Integer.parseInt(request.getParameter("idMod"));
    	
    	modeloDAO.eliminar(new Modelo(idMod));
    	
    	listarModelo(request, response);
    }
    protected void editarModelo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Integer idMod = Integer.parseInt(request.getParameter("idMod"));
    	
    	List<Marca> listaMarca = marcaDAO.listar();
    	List<Modelo> listaModelo = modeloService.listar();
    	Modelo modeloEditable = modeloService.obtener(idMod);
    	
    	request.setAttribute("listaModelo", listaModelo);
    	request.setAttribute("listaMarca", listaMarca);
    	request.setAttribute("modeloEditable", modeloEditable);
    }
    protected void grabarModelo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Integer idMod = Integer.parseInt(request.getParameter("idMod"));
    	String nombre = request.getParameter("txtNombre");
		Integer idMar = Integer.parseInt(request.getParameter("idMar"));
		Integer precio = Integer.parseInt(request.getParameter("txtPrecio"));
		
		Modelo modelo = new Modelo();
		modelo.setNombre(nombre);
		modelo.setMarca(new Marca(idMar));
		modelo.setPrecio(precio);
		modelo.setId(idMod);
		
    	if(idMod == 0){
    		modeloDAO.insertar(modelo);
    	} else {
    		modeloDAO.actualizar(modelo);
    	}
    	
    	listarModelo(request, response);
    }
    protected void listarModelo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	List<Marca> listaMarca = marcaDAO.listar();
    	List<Modelo> listaModelo = modeloService.listar();
    	
    	Modelo modeloEditable = new Modelo();
    	modeloEditable.setId(0);
    	modeloEditable.setNombre("");
    	modeloEditable.setPrecio(0);
    	
    	request.setAttribute("listaModelo", listaModelo);
    	request.setAttribute("listaMarca", listaMarca);
    	request.setAttribute("modeloEditable", modeloEditable);
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
