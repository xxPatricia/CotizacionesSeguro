package service;

import java.util.List;

import dao.CotizacionDAO;
import dao.MarcaDAO;
import dao.ModeloDAO;
import dao.SeguradoraDAO;
import dao.TipoVehiculoDAO;
import entidad.Cotizacion;
import entidad.Marca;
import entidad.Modelo;
import entidad.Seguradora;
import entidad.TipoVehiculo;

public class CotizacionService {
	CotizacionDAO cotizacionDAO =  new CotizacionDAO();
	MarcaDAO marcaDAO = new MarcaDAO();
	ModeloDAO modeloDAO = new ModeloDAO();
	TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
	SeguradoraDAO seguradoraDAO = new SeguradoraDAO();
	
	public List<Cotizacion> listarXModTip(Integer idTip, Integer idMod) {
		List<Cotizacion> listadoCotizacion = cotizacionDAO.listarXModTip(idTip, idMod);
		for (Cotizacion cotizacion:listadoCotizacion){
			Seguradora seguradora = seguradoraDAO.obtener(cotizacion.getSeguradora().getId());
			TipoVehiculo tipoVehiculo = tipoVehiculoDAO.obtener(cotizacion.getTipoVehiculo().getId());
			Modelo modelo = modeloDAO.obtener(cotizacion.getModelo().getId());
			Marca marca = marcaDAO.obtener(modelo.getMarca().getId());
			modelo.setMarca(marca);
			
			cotizacion.setSeguradora(seguradora);
			cotizacion.setModelo(modelo);
			cotizacion.setTipoVehiculo(tipoVehiculo);
		}
		
		return listadoCotizacion;
	}
	
	public List<Cotizacion> listar() {
		List<Cotizacion> listaCotizacion = cotizacionDAO.listar();
		for (Cotizacion cotizacion : listaCotizacion) {
			Modelo modelo = modeloDAO.obtener(cotizacion.getModelo().getId());
			Marca marca = marcaDAO.obtener(modelo.getMarca().getId());
			modelo.setMarca(marca);
			cotizacion.setModelo(modelo);
			
			cotizacion.setSeguradora(seguradoraDAO.obtener(cotizacion.getSeguradora().getId()));
			cotizacion.setTipoVehiculo(tipoVehiculoDAO.obtener(cotizacion.getTipoVehiculo().getId()));
		}
		
		return listaCotizacion;
	}
	
	public Cotizacion obtener(Integer idCot) {
		Cotizacion cotizacion = cotizacionDAO.obtener(idCot);
		Modelo modelo = modeloDAO.obtener(cotizacion.getModelo().getId());
		Marca marca = marcaDAO.obtener(modelo.getMarca().getId());
		modelo.setMarca(marca);
		cotizacion.setModelo(modelo);
		
		cotizacion.setSeguradora(seguradoraDAO.obtener(cotizacion.getSeguradora().getId()));
		cotizacion.setTipoVehiculo(tipoVehiculoDAO.obtener(cotizacion.getTipoVehiculo().getId()));
		
		return cotizacion;
	}
}
