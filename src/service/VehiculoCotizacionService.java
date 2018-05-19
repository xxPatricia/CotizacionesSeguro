package service;

import entidad.Cotizacion;
import entidad.Marca;
import entidad.Modelo;
import entidad.Seguradora;
import entidad.TipoVehiculo;
import entidad.Vehiculo;
import entidad.VehiculoCotizacion;
import dao.CotizacionDAO;
import dao.MarcaDAO;
import dao.ModeloDAO;
import dao.SeguradoraDAO;
import dao.VehiculoCotizacionDAO;
import dao.VehiculoDAO;
import dao.TipoVehiculoDAO;

public class VehiculoCotizacionService {
	VehiculoCotizacionDAO vehiculoCotizacionDAO = new VehiculoCotizacionDAO(); 
	VehiculoDAO vehiculoDAO = new VehiculoDAO();
	CotizacionDAO cotizacionDAO = new CotizacionDAO();
	MarcaDAO marcaDAO = new MarcaDAO();
	ModeloDAO modeloDAO = new ModeloDAO();
	SeguradoraDAO seguradoraDAO = new SeguradoraDAO();
	TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
	
	public VehiculoCotizacion buscarXVehCot(Integer idVeh, Integer idCot) {
		VehiculoCotizacion vehiculoCotizacion = vehiculoCotizacionDAO.buscarXVehCot(idVeh, idCot);
		
		Vehiculo vehiculo = vehiculoDAO.obtener(vehiculoCotizacion.getVehiculo().getId());
		Modelo modelo = modeloDAO.obtener(vehiculo.getModelo().getId());
		Marca marca = marcaDAO.obtener(modelo.getMarca().getId());
		TipoVehiculo tipoVehiculo = tipoVehiculoDAO.obtener(vehiculo.getTipoVehiculo().getId());
		Cotizacion cotizacion = cotizacionDAO.obtener(vehiculoCotizacion.getCotizacion().getId());
		Seguradora seguradora = seguradoraDAO.obtener(cotizacion.getSeguradora().getId());
		
		modelo.setMarca(marca);
		vehiculo.setModelo(modelo);
		vehiculo.setTipoVehiculo(tipoVehiculo);
		cotizacion.setSeguradora(seguradora);
		
		vehiculoCotizacion.setVehiculo(vehiculo);
		vehiculoCotizacion.setCotizacion(cotizacion);
		
		return vehiculoCotizacion;
	}
	
	public int actualizar(VehiculoCotizacion vehiculoCotizacion) {
		return vehiculoCotizacionDAO.actualizar(vehiculoCotizacion);
	}
}
