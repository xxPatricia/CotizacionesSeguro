package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Modelo;

/**
 * Servlet implementation class ComboboxAjaxAction
 */
@WebServlet(name="/ComboboxAjaxAction", urlPatterns = {"/ComboboxAjaxAction"})
public class ComboboxAjaxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComboboxAjaxAction() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ModeloDAO modeloDAO = new ModeloDAO();
        
        try (PrintWriter out = response.getWriter()) {
            Integer IdMar = Integer.parseInt(request.getParameter("IdMar"));
            List<Modelo> listadoModelo =  modeloDAO.listarXMar(IdMar);
            for (Modelo modelo : listadoModelo) {
            	out.println("<option value="+modelo.getId()+">"+modelo.getNombre()+"</option>");
			}
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
