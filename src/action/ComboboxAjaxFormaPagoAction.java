package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CotizacionDAO;
import entidad.Cotizacion;

/**
 * Servlet implementation class ComboboxAjaxFormaPagoAction
 */
@WebServlet("/ComboboxAjaxFormaPagoAction")
public class ComboboxAjaxFormaPagoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComboboxAjaxFormaPagoAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CotizacionDAO cotizacionDAO = new CotizacionDAO();
        String accion = request.getParameter("accion");
        
        try (PrintWriter out = response.getWriter()) {
            if(accion.equals("obtenerPrecio")){/********************************************/
	            Integer idCot = Integer.parseInt(request.getParameter("IdCot"));
	            Cotizacion cotizacion = cotizacionDAO.obtener(idCot);
	            
	            String cuota3 = "3 Cuotas de " + ((cotizacion.getPrecio())/3);
	            String cuota6 = "6 Cuotas de " + ((cotizacion.getPrecio())/6);
	            String cuota12 = "12 Cuotas de " + ((cotizacion.getPrecio())/12);
	            
	            out.println("<option value='Contado'>Contado</option>");
	            out.println("<option value='" + cuota3 + "'>" + cuota3 + "</option>");
	            out.println("<option value='" + cuota6 + "'>" + cuota6 + "</option>");
	            out.println("<option value='" + cuota12 + "'>" + cuota12 + "</option>");
	            
	            
            } else if(accion.equals("obtenerId")){/********************************************/
	            Integer idCot = Integer.parseInt(request.getParameter("IdCot"));
	            Cotizacion cotizacion = cotizacionDAO.obtener(idCot);
	            
	            out.println(cotizacion.getId());
            }
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
