package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.MysqlDBConexion;
import entidad.Administrador;
import entidad.Cliente;
import entidad.Usuario;


public class LoginDAO {
	
	  public Usuario login(String login, String password) {
		    Usuario usuario = null;
		    Connection conn = null;
		    try {
		      conn = MysqlDBConexion.getConexion();
		      String sql = "SELECT * FROM usuario WHERE nombreUsu = ? and claveUsu = ?";
		      PreparedStatement pst = conn.prepareStatement(sql);
		      pst.setString(1, login);
		      pst.setString(2, password);
		      ResultSet rs = pst.executeQuery();
		      while (rs.next()) {
		        Usuario usuario2 = new Usuario();
		        usuario2.setId(rs.getInt("idUsu"));
		        usuario2.setNombre(rs.getString("nombreUsu"));
		        usuario2.setClave(rs.getString("claveUsu"));
		        usuario2.setPerfil(rs.getString("perfilUsu"));
		        usuario2.setActivo(rs.getBoolean("activoUsu"));
		        usuario = usuario2;
		      }
		      conn.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return usuario;
		  }
	  
		public Cliente obtenerCliente(Integer idUsu){
			Cliente cliente = new Cliente();
		    Connection conn = null;
		    try {
		      conn = MysqlDBConexion.getConexion();
		      String sql = "SELECT * FROM cliente WHERE idUsu = ?";
		      PreparedStatement pst = conn.prepareStatement(sql);
		      pst.setInt(1, idUsu);
		      ResultSet rs = pst.executeQuery();
		      while (rs.next()) {
		    	  cliente.setId(rs.getInt("idCli"));
		    	  cliente.setNombre(rs.getString("nombreCli"));
		    	  cliente.setApellidos(rs.getString("apellidosCli"));
		    	  cliente.setDireccion(rs.getString("direccionCli"));
		    	  cliente.setEdad(rs.getInt("edadCli"));
		    	  cliente.setTelefono(rs.getInt("telefonoCli"));
		    	  cliente.setEmail(rs.getString("emailCli"));
		    	  cliente.setActivo(rs.getBoolean("activoCli"));
		    	  cliente.setDni(rs.getString("dniCli"));
		    	  cliente.setUsuario(new Usuario(rs.getInt("idUsu")));
		      }
		      conn.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return cliente;
		  }
		
		public Administrador obtenerAdministrador(Integer idUsu){
			Administrador administrador = new Administrador();
		    Connection conn = null;
		    try {
		      conn = MysqlDBConexion.getConexion();
		      String sql = "SELECT * FROM administrador WHERE idUsu = ?";
		      PreparedStatement pst = conn.prepareStatement(sql);
		      pst.setInt(1, idUsu);
		      ResultSet rs = pst.executeQuery();
		      while (rs.next()) {
		    	  administrador.setId(rs.getInt("idAdm"));
		    	  administrador.setNombre(rs.getString("nombreAdm"));
		    	  administrador.setApellidos(rs.getString("apellidosAdm"));
		    	  administrador.setDni(rs.getString("dniAdm"));
		    	  administrador.setActivo(rs.getBoolean("activoAdm"));
		    	  administrador.setUsuario(new Usuario(rs.getInt("idUsu")));
		      }
		      conn.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return administrador;
		  }
		
		

}
