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
import dao.TipoVehiculoDAO;
import entidad.Administrador;
import entidad.Cliente;
import entidad.Marca;
import entidad.Modelo;
import entidad.TipoVehiculo;
import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(name = "/LoginController", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService loginService = new LoginService();
	MarcaDAO marcaDAO = new MarcaDAO();
	ModeloDAO modeloDAO = new ModeloDAO();
	TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String txtNombre = String.valueOf(request.getParameter("txtNombre"));
		String txtClave = String.valueOf(request.getParameter("txtClave"));

		

		Object usuarioLogeado = loginService.login(txtNombre, txtClave);

		if (usuarioLogeado != null) {

			if (usuarioLogeado instanceof Cliente) {
				Cliente cliente = (Cliente) usuarioLogeado;
				cargarDatosCombos(request, response);
				
				request.getSession().setAttribute("clienteLogeado", cliente);
				request.getRequestDispatcher("/cliente/inicio.jsp").forward(request, response);
				
			} else if (usuarioLogeado instanceof Administrador) {
				Administrador administrador = (Administrador) usuarioLogeado;
				cargarDatosCombos(request, response);

				request.getSession().setAttribute("adminLogeado", administrador);
				request.getRequestDispatcher("/admin/inicio.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("msgs", "Usuario y/o Contraseña incorrecto");
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}
	}
	
	protected void cargarDatosCombos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Marca> listaMarca = marcaDAO.listar();
		List<TipoVehiculo> listaTipoVehiculo = tipoVehiculoDAO.listar();
		List<Modelo> listaModelo = modeloDAO.listarXMar(1);
		
		request.setAttribute("listaMarca", listaMarca);
		request.setAttribute("listaModelo", listaModelo);
		request.setAttribute("listaTipoVehiculo", listaTipoVehiculo);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
