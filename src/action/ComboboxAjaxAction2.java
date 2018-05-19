package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CotizacionDAO;
import dao.ModeloDAO;
import entidad.Cotizacion;
import entidad.Modelo;
import service.CotizacionService;

/**
 * Servlet implementation class ComboboxAjaxAction2
 */
@WebServlet(name="/ComboboxAjaxAction2", urlPatterns = {"/ComboboxAjaxAction2"})

public class ComboboxAjaxAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CotizacionDAO cotizacionDAO = new CotizacionDAO();
	CotizacionService cotizacionService = new CotizacionService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComboboxAjaxAction2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ModeloDAO modeloDAO = new ModeloDAO();
        
        
        try (PrintWriter out = response.getWriter()) {
            //Integer idTip = Integer.parseInt(request.getParameter("IdTip"));
            Integer idMod = Integer.parseInt(request.getParameter("IdMod"));
            Modelo modelo = modeloDAO.obtener(idMod);
            out.println(modelo.getPrecio());
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
