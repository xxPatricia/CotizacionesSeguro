package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Marca;
import entidad.Seguradora;
import dao.SeguradoraDAO;

/**
 * Servlet implementation class SeguradoraController
 */
@WebServlet("/SeguradoraController")
public class SeguradoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SeguradoraDAO seguradoraDAO = new SeguradoraDAO();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String accion = request.getParameter("accion");
    	
    	if(accion.equals("listarSeguradora")) { //1ER PASO DE ASEGURAMIENTO
    		listarSeguradora(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoSeguradora.jsp").forward(request, response);
    		
    	} else if (accion.equals("grabarSeguradora")) { //ULTIMO PASO
    		grabarSeguradora(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoSeguradora.jsp").forward(request, response);
    		
    	} else if (accion.equals("editarSeguradora")) { //ULTIMO PASO 
    		editarSeguradora(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoSeguradora.jsp").forward(request, response);
    		
    	} else if (accion.equals("eliminarSeguradora")) { //ULTIMO PASO 
    		eliminarSeguradora(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoSeguradora.jsp").forward(request, response);
    		
    	}
    }
    
    
    protected void eliminarSeguradora(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Integer idSeg = Integer.parseInt(request.getParameter("idSeg"));
    	
    	seguradoraDAO.eliminar(new Seguradora(idSeg));
    	
    	listarSeguradora(request, response);
    }
    protected void editarSeguradora(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Integer idSeg = Integer.parseInt(request.getParameter("idSeg"));
    	
    	List<Seguradora> listaSeguradora = seguradoraDAO.listar();
    	Seguradora seguradoraEditable = seguradoraDAO.obtener(idSeg);
    	
    	request.setAttribute("listaSeguradora", listaSeguradora);
    	request.setAttribute("seguradoraEditable", seguradoraEditable);
    }
    protected void grabarSeguradora(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String nombre = request.getParameter("txtNombre");
    	String descripcion = request.getParameter("txtDescripcion");
		Integer idSeg = Integer.parseInt(request.getParameter("idSeg"));
		
		Seguradora seguradora = new Seguradora();
		seguradora.setNombre(nombre);
		seguradora.setId(idSeg);
		seguradora.setDescripcion(descripcion);
		
    	if(idSeg == 0){
    		seguradoraDAO.insertar(seguradora);
    	} else {
    		seguradoraDAO.actualizar(seguradora);
    	}
    	
    	listarSeguradora(request, response);
    }
    protected void listarSeguradora(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	List<Seguradora> listaSeguradora = seguradoraDAO.listar();
    	
    	Seguradora seguradoraEditable = new Seguradora();
    	seguradoraEditable.setId(0);
    	seguradoraEditable.setNombre("");
    	seguradoraEditable.setDescripcion("");
    	
    	request.setAttribute("listaSeguradora", listaSeguradora);
    	request.setAttribute("seguradoraEditable", seguradoraEditable);
    }   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeguradoraController() {
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
