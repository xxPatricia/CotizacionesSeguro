package entidad;

public class Marca {
	Integer id;
	String nombre;
	Boolean activo;
	public Marca(Integer id, String nombre, Boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
	}
	public Marca() {
	}
	public Marca(Integer id) {
		this.id = id;
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
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
}
