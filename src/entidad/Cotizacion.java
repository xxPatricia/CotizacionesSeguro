package entidad;

import java.sql.Date;

public class Cotizacion {
	Integer id;
	Double precio;
	Date fecha;
	Boolean activo;
	TipoVehiculo tipoVehiculo;
	Modelo modelo;
	Seguradora seguradora;
	public Cotizacion(Integer id, Double precio, Date fecha, Boolean activo, TipoVehiculo tipoVehiculo, Modelo modelo,
			Seguradora seguradora) {
		this.id = id;
		this.precio = precio;
		this.fecha = fecha;
		this.activo = activo;
		this.tipoVehiculo = tipoVehiculo;
		this.modelo = modelo;
		this.seguradora = seguradora;
	}
	public Cotizacion() {
	}
	public Cotizacion(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Seguradora getSeguradora() {
		return seguradora;
	}
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
}
