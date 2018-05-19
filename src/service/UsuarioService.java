package service;

import dao.UsuarioDAO;
import entidad.Usuario;

public class UsuarioService {
	UsuarioDAO usuariDAO = new UsuarioDAO();

	public void insertar(Usuario usuario) {
		usuariDAO.insertar(usuario);
	}

	public Integer buscarUltimo() {
		return usuariDAO.buscarUltimo();
	}
}
