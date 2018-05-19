package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cliente;
import entidad.Usuario;
import service.ClienteService;
import service.UsuarioService;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	ClienteService clienteService = new ClienteService();
	UsuarioService usuarioService = new UsuarioService();
	
  	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
  			throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");

  	  //String accion1 = String.valueOf(request.getParameter("accion"));
         String accion = request.getParameter("txtAccion");

         if(accion.equals("obtenerDatos")) {
    		
     		    request.getRequestDispatcher("/postulante/verDatos.jsp").forward(request, response);
     		
     		}
        
     		
     		else if (accion.equals("ingresarRegistroCliente")) {
    			
    			request.getRequestDispatcher("/registrarCliente.jsp").forward(request, response);

    		}
     		else if (accion.equals("registrar")){
     			
     			registrarCliente(request, response);
     		    request.getRequestDispatcher("/registrarCliente.jsp").forward(request, response);

     		}
     		
         
  	}
	  private void registrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
	        String nombreCli = request.getParameter("txtNombre");
	        String apellidoCli = request.getParameter("txtApellido");
	        String direccionCli = request.getParameter("txtDireccion");
	        Integer edadCli = Integer.parseInt(request.getParameter("txtEdad"));
	        Integer TelefonoCli = Integer.parseInt(request.getParameter("txtTelefono"));
	        String emailCli = request.getParameter("txtEmail");
	        String dniCli = request.getParameter("txtDni");
	     
	       
	    	Cliente  cliente = new Cliente();
	    	cliente.setNombre(nombreCli);
	    	cliente.setApellidos(apellidoCli);
	    	cliente.setDireccion(direccionCli);
	    	cliente.setEdad(edadCli);
	    	cliente.setTelefono(TelefonoCli);
	    	cliente.setEmail(emailCli);
	    	cliente.setDni(dniCli);

	
	    	//postulanteService.insertar(postulante);
	        //int idUsu = Integer.parseInt(request.getParameter("idUsu"));
	        String nombreUsu = request.getParameter("txtNombreUsu");
	        String claveUsu = request.getParameter("txtClaveUsu");
	        Usuario usuario = new Usuario();
	        usuario.setNombre(nombreUsu);
	        usuario.setClave(claveUsu);
	        usuario.setPerfil("Cliente");
	    
	        
	        usuarioService.insertar(usuario);
	        int idInsertado = usuarioService.buscarUltimo();
	        usuario.setId(idInsertado);
	        
	        cliente.setUsuario(usuario);
	        
	        clienteService.insertar(cliente);
	        
	        request.setAttribute("mensaje", "Se Registro Correctamente");
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
