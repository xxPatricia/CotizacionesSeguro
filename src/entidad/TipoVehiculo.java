package entidad;

public class TipoVehiculo {
	Integer id;
	String nombre;
	String descripcion;
	Boolean activo;
	
	public TipoVehiculo(Integer id) {
		this.id = id;
	}
	public TipoVehiculo(Integer id, String nombre, String descripcion, Boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	public TipoVehiculo() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
