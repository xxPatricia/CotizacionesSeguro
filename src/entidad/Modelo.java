package entidad;

public class Modelo {
	Integer id;
	String nombre;
	Boolean activo;
	Marca marca;
	Integer precio;
	
	public Modelo(Integer id, String nombre, Boolean activo, Marca marca) {
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
		this.marca = marca;
	}
	public Modelo(Integer id, String nombre, Boolean activo, Marca marca, Integer precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
		this.marca = marca;
		this.precio = precio;
	}
	public Modelo() {
	}
	public Modelo(Integer id) {
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
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
}
