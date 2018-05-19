package service;

import dao.LoginDAO;
import entidad.Usuario;
import entidad.Administrador;
import entidad.Cliente;

public class LoginService {

	LoginDAO loginDao = new LoginDAO();

	public Object login(String login, String password) {
		Usuario usuario = loginDao.login(login, password);// obtenemos usuario del DAO
		Object tipoUsuario = null;

		if (usuario != null) {
			if (usuario.getPerfil().equals("Administrador")) {
				Administrador administrador = loginDao.obtenerAdministrador(usuario.getId());// buscar profesor x
																								// usuario
				administrador.setUsuario(usuario);// guardar usuario en profesor encontrado
				tipoUsuario = administrador;
			} else if (usuario.getPerfil().equals("Cliente")) {
				Cliente Cliente = loginDao.obtenerCliente(usuario.getId());// buscar profesor x
																								// usuario
				Cliente.setUsuario(usuario);// guardar usuario en profesor encontrado
				tipoUsuario = Cliente;
			}
		}
		
		return tipoUsuario;
	}
}
