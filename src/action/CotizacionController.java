package action;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CotizacionDAO;
import dao.MarcaDAO;
import dao.ModeloDAO;
import dao.SeguradoraDAO;
import dao.TipoVehiculoDAO;
import dao.VehiculoCotizacionDAO;
import dao.VehiculoDAO;
import entidad.Administrador;
import entidad.Cliente;
import entidad.Cotizacion;
import entidad.Marca;
import entidad.Modelo;
import entidad.Seguradora;
import entidad.TipoVehiculo;
import entidad.Vehiculo;
import entidad.VehiculoCotizacion;
import service.CotizacionService;
import service.ModeloService;

/**
 * Servlet implementation class CotizacionController
 */

@WebServlet("/CotizacionController")
public class CotizacionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CotizacionDAO cotizacionDAO = new CotizacionDAO();
	CotizacionService cotizacionService = new CotizacionService();
	MarcaDAO marcaDAO = new MarcaDAO();
	ModeloDAO modeloDAO = new ModeloDAO();
	ModeloService modeloService = new ModeloService();
	TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
	SeguradoraDAO seguradoraDAO = new SeguradoraDAO();
	VehiculoDAO vehiculoDAO = new VehiculoDAO();
	VehiculoCotizacionDAO vehiculoCotizacionDAO = new VehiculoCotizacionDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CotizacionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
    	
    	if(accion.equals("cotizar")) { //COTIZACION EN PAGINA ICIO DEL CLIENTE
    		cotizar(request, response);
    		request.getRequestDispatcher("/cliente/inicio.jsp").forward(request, response);
    	} else if(accion.equals("listarCotizacion")) { //1ER PASO DE ASEGURAMIENTO
    		listarCotizacion(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoCotizacion.jsp").forward(request, response);
    		
    	} else if (accion.equals("grabarCotizacion")) { //ULTIMO PASO
    		grabarCotizacion(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoCotizacion.jsp").forward(request, response);
    		
    	} else if (accion.equals("editarCotizacion")) { //ULTIMO PASO 
    		editarCotizacion(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoCotizacion.jsp").forward(request, response);
    		
    	} else if (accion.equals("eliminarCotizacion")) { //ULTIMO PASO 
    		eliminarCotizacion(request, response);
    		request.getRequestDispatcher("/admin/mantenimientoCotizacion.jsp").forward(request, response);
    		
    	}
		
		
	}
	
	protected void eliminarCotizacion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Integer idCot = Integer.parseInt(request.getParameter("idCot"));
    	
    	cotizacionDAO.eliminar(new Cotizacion(idCot));
    	
    	listarCotizacion(request, response);
    }
    protected void editarCotizacion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Integer idCot = Integer.parseInt(request.getParameter("idCot"));
    	
    	List<Cotizacion> listaCotizacion = cotizacionService.listar();
    	List<Seguradora> listaSeguradora = seguradoraDAO.listar();
		List<TipoVehiculo> listaTipoVehiculo = tipoVehiculoDAO.listar();
		List<Modelo> listaModelo = modeloService.listar();
    	
		Cotizacion cotizacionEditable = cotizacionService.obtener(idCot);
    	
		request.setAttribute("listaSeguradora", listaSeguradora);
		request.setAttribute("listaCotizacion", listaCotizacion);
		request.setAttribute("listaModelo", listaModelo);
		request.setAttribute("listaTipoVehiculo", listaTipoVehiculo);
		request.setAttribute("cotizacionEditable", cotizacionEditable);
    }
    protected void grabarCotizacion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		Integer idSeg = Integer.parseInt(request.getParameter("idSeg"));
		Integer idMod = Integer.parseInt(request.getParameter("idMod"));
		Integer idTip = Integer.parseInt(request.getParameter("idTip"));
		Integer idCot = Integer.parseInt(request.getParameter("idCot"));
		
		Cotizacion cotizacion = new Cotizacion();
		cotizacion.setPrecio(precio);
		cotizacion.setFecha(new Date(2018, 3, 3));
		cotizacion.setId(idCot);
		cotizacion.setSeguradora(new Seguradora(idSeg));
		cotizacion.setModelo(new Modelo(idMod));
		cotizacion.setTipoVehiculo(new TipoVehiculo(idTip));
		
    	if(idCot == 0){
    		cotizacionDAO.insertar(cotizacion);
    	} else {
    		cotizacionDAO.actualizar(cotizacion);
    	}
    	
    	listarCotizacion(request, response);
    }
    protected void listarCotizacion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	List<Cotizacion> listaCotizacion = cotizacionService.listar();
    	List<Seguradora> listaSeguradora = seguradoraDAO.listar();
		List<TipoVehiculo> listaTipoVehiculo = tipoVehiculoDAO.listar();
		List<Modelo> listaModelo = modeloService.listar();
    	
		Cotizacion cotizacionEditable = new Cotizacion();
		cotizacionEditable.setId(0);
		cotizacionEditable.setPrecio(0.0);
    	
		request.setAttribute("listaSeguradora", listaSeguradora);
		request.setAttribute("listaCotizacion", listaCotizacion);
		request.setAttribute("listaModelo", listaModelo);
		request.setAttribute("listaTipoVehiculo", listaTipoVehiculo);
		request.setAttribute("cotizacionEditable", cotizacionEditable);
    }

    /**************************************************************************************************/
    
	protected void cotizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String txtConvertidor = String.valueOf(request.getParameter("txtConvertidor"));
		String txtPrecio = String.valueOf(request.getParameter("txtPrecio"));
		Integer idMar = Integer.parseInt(request.getParameter("idMar"));
		Integer idMod = Integer.parseInt(request.getParameter("idMod"));
		Integer idTip = Integer.parseInt(request.getParameter("idTip"));
		String txtFecha = String.valueOf(request.getParameter("txtFecha"));
		String txtMatricula = String.valueOf(request.getParameter("txtMatricula"));
		Cliente clienteLogeado = (Cliente) request.getSession().getAttribute("clienteLogeado");

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMatricula(txtMatricula);
		vehiculo.setFabricacion(txtFecha);
		vehiculo.setPrecio(txtPrecio);//precio variable
		vehiculo.setConvertidor(txtConvertidor);
		vehiculo.setCliente(clienteLogeado);
		vehiculo.setModelo(new Modelo(idMod));
		vehiculo.setTipoVehiculo(new TipoVehiculo(idTip));

		vehiculoDAO.insertar(vehiculo);
		vehiculo = vehiculoDAO.obtenerUltimo();

		List<Cotizacion> listadoCotizacion = cotizacionService.listarXModTip(idTip, idMod);
		for (Cotizacion cotizacion : listadoCotizacion) {
			VehiculoCotizacion vehiculoCotizacion = new VehiculoCotizacion();
			vehiculoCotizacion.setPrecio(200.2);
			vehiculoCotizacion.setVehiculo(vehiculo);
			vehiculoCotizacion.setCotizacion(cotizacion);
			vehiculoCotizacion.setAcepta(false);

			vehiculoCotizacionDAO.insertar(vehiculoCotizacion);
		}
		request.setAttribute("listadoCotizacion", listadoCotizacion);
		request.setAttribute("vehiculo", vehiculo);
		cargarDatosCombos(request, response);
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
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	

}
