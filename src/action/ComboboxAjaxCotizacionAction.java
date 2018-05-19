package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CotizacionDAO;
import dao.ModeloDAO;
import entidad.Cotizacion;
import entidad.Modelo;

/**
 * Servlet implementation class ComboboxAjaxCotizacionAction
 */
@WebServlet("/ComboboxAjaxCotizacionAction")
public class ComboboxAjaxCotizacionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComboboxAjaxCotizacionAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CotizacionDAO cotizacionDAO = new CotizacionDAO();
        
        try (PrintWriter out = response.getWriter()) {
            //Integer idTip = Integer.parseInt(request.getParameter("IdTip"));
            Integer idCot = Integer.parseInt(request.getParameter("IdCot"));
            Cotizacion cotizacion = cotizacionDAO.obtener(idCot);
            out.println(cotizacion.getPrecio());
        }
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
