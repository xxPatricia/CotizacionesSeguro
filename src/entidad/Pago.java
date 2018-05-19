package entidad;

import java.sql.Date;

public class Pago {
	Integer id;
	Integer cuotas;
	String medio;
	Integer dia;
	Date fecha;
	Boolean activo;
	VehiculoCotizacion vehiculoCotizacion;
	
	public Pago(Integer id, Integer cuotas, String medio, Integer dia, Date fecha, Boolean activo,
			VehiculoCotizacion vehiculoCotizacion) {
		super();
		this.id = id;
		this.cuotas = cuotas;
		this.medio = medio;
		this.dia = dia;
		this.fecha = fecha;
		this.activo = activo;
		this.vehiculoCotizacion = vehiculoCotizacion;
	}

	public Pago(Integer id) {
		super();
		this.id = id;
	}

	public Pago() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCuotas() {
		return cuotas;
	}

	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}

	public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
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

	public VehiculoCotizacion getVehiculoCotizacion() {
		return vehiculoCotizacion;
	}

	public void setVehiculoCotizacion(VehiculoCotizacion vehiculoCotizacion) {
		this.vehiculoCotizacion = vehiculoCotizacion;
	}
	
	
}
