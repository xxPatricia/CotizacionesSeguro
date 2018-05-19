package service;

import dao.ClienteDAO;
import entidad.Cliente;

public class ClienteService {
	
	ClienteDAO clienteDAO = new ClienteDAO();

	public void insertar(Cliente usuario) {
		clienteDAO.insertar(usuario);
	}


}
