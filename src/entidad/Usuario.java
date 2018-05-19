package entidad;

public class Usuario {
	Integer id;
	String nombre;
	String clave;
	String perfil;
	Boolean activo;
	
	public Usuario(Integer id) {
		this.id = id;
	}
	public Usuario() {
	}
	public Usuario(Integer id, String nombre, String clave, String perfil, Boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		this.perfil = perfil;
		this.activo = activo;
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
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
	
}
