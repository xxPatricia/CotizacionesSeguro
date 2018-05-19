package service;

import java.util.List;

import dao.MarcaDAO;
import dao.ModeloDAO;
import entidad.Modelo;

public class ModeloService {
	ModeloDAO modeloDAO = new ModeloDAO();
	MarcaDAO marcaDAO = new MarcaDAO();
	
	public List<Modelo> listar() {
		List<Modelo> listaModelo = modeloDAO.listar();
		for (Modelo modelo : listaModelo) {
			modelo.setMarca(marcaDAO.obtener(modelo.getMarca().getId()));
		}
		return listaModelo;
	}
	
	public Modelo obtener(Integer idMod) {
		Modelo modelo = modeloDAO.obtener(idMod);
		modelo.setMarca(marcaDAO.obtener(modelo.getMarca().getId()));
		return modelo;
	}
}
