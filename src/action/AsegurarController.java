package action;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cotizacion;
import entidad.Marca;
import entidad.Modelo;
import entidad.Pago;
import entidad.TipoVehiculo;
import dao.MarcaDAO;
import dao.ModeloDAO;
import dao.PagoDAO;
import dao.TipoVehiculoDAO;
import entidad.VehiculoCotizacion;
import service.CotizacionService;
import service.VehiculoCotizacionService;

/**
 * Servlet implementation class AsegurarController
 */
@WebServlet("/AsegurarController")
public class AsegurarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VehiculoCotizacionService vehiculoCotizacionService = new VehiculoCotizacionService();
	CotizacionService cotizacionService = new CotizacionService();
	PagoDAO pagoDAO = new PagoDAO();
	MarcaDAO marcaDAO = new MarcaDAO();
	TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
	ModeloDAO modeloDAO = new ModeloDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsegurarController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String accion = request.getParameter("accion");
    	
    	if(accion.equals("prepararAsegurar")) { //1ER PASO DE ASEGURAMIENTO
    		prepararAsegurar(request, response);
    	} else if (accion.equals("contratarSeguro")) { //ULTIMO PASO
    		contratarSeguro(request, response);
    	}
    	
    }
    
    protected void prepararAsegurar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer idCot = Integer.parseInt(request.getParameter("txtIdCot"));
		Integer idVeh = Integer.parseInt(request.getParameter("txtIdVeh"));
		
		VehiculoCotizacion vehiculoCotizacion = vehiculoCotizacionService.buscarXVehCot(idVeh, idCot);
		Integer idTip = vehiculoCotizacion.getVehiculo().getTipoVehiculo().getId();
		Integer idMod = vehiculoCotizacion.getVehiculo().getModelo().getId();
		List<Cotizacion> listadoCotizacion = cotizacionService.listarXModTip(idTip, idMod);
		
		request.setAttribute("listadoCotizacion", listadoCotizacion);
		request.setAttribute("vehiculoCotizacion", vehiculoCotizacion);
		request.getRequestDispatcher("/cliente/asegurar.jsp").forward(request, response);
	}
    
    protected void contratarSeguro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer idCot = Integer.parseInt(request.getParameter("idCot"));
		Integer idVeh = Integer.parseInt(request.getParameter("txtIdVeh"));
		Integer diaPago = Integer.parseInt(request.getParameter("diaPago"));
		Integer cuotaPago = Integer.parseInt(request.getParameter("cuotaPago"));
		String medioPago = request.getParameter("medioPago");
		
		VehiculoCotizacion vehiculoCotizacion = vehiculoCotizacionService.buscarXVehCot(idVeh, idCot);
		vehiculoCotizacion.setAcepta(true);
		vehiculoCotizacionService.actualizar(vehiculoCotizacion);
		
		Pago pago = new Pago();
		pago.setCuotas(cuotaPago);
		pago.setDia(diaPago);
		pago.setMedio(medioPago);
		pago.setVehiculoCotizacion(vehiculoCotizacion);
		//Calendar c1 = Calendar.getInstance();
		pago.setFecha(Date.valueOf("2018-03-03"));
		
		pagoDAO.insertar(pago);
		
		cargarDatosCombos(request, response);
		request.setAttribute("mensaje", "Felicitaciones ya se genero el contrato de Seguro, La Aseguradora se comunicara vía correo");
		request.getRequestDispatcher("/cliente/inicio.jsp").forward(request, response);
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
