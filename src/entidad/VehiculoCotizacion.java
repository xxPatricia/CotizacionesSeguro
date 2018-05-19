package entidad;

public class VehiculoCotizacion {
	Integer id;
	Double precio;
	Boolean activo;
	Vehiculo vehiculo;
	Cotizacion cotizacion;
	Boolean acepta;

	public VehiculoCotizacion(Integer id) {
		this.id = id;
	}
	
	public VehiculoCotizacion(Integer id, Double precio, Boolean activo, Vehiculo vehiculo, Cotizacion cotizacion,
			Boolean acepta) {
		this.id = id;
		this.precio = precio;
		this.activo = activo;
		this.vehiculo = vehiculo;
		this.cotizacion = cotizacion;
		this.acepta = acepta;
	}

	public VehiculoCotizacion() {
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

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Boolean getAcepta() {
		return acepta;
	}

	public void setAcepta(Boolean acepta) {
		this.acepta = acepta;
	}
	
	

}
