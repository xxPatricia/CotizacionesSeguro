package entidad;

import java.sql.Date;

public class Vehiculo {
	Integer id;
	String matricula;
	String fabricacion;
	String precio;
	String convertidor;
	Boolean activo;
	Cliente cliente;
	Modelo modelo;
	TipoVehiculo tipoVehiculo;
	
	
	public Vehiculo(Integer id) {
		this.id = id;
	}




	public Vehiculo(Integer id, String matricula, String fabricacion, String precio, String convertidor, Boolean activo,
			Cliente cliente, Modelo modelo, TipoVehiculo tipoVehiculo) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.fabricacion = fabricacion;
		this.precio = precio;
		this.convertidor = convertidor;
		this.activo = activo;
		this.cliente = cliente;
		this.modelo = modelo;
		this.tipoVehiculo = tipoVehiculo;
	}




	public Vehiculo() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getFabricacion() {
		return fabricacion;
	}


	public void setFabricacion(String fabricacion) {
		this.fabricacion = fabricacion;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}


	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}




	public String getConvertidor() {
		return convertidor;
	}




	public void setConvertidor(String convertidor) {
		this.convertidor = convertidor;
	}


	
	
	

}
