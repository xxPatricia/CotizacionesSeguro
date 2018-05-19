package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Cotizacion;
import entidad.Modelo;
import entidad.Seguradora;
import entidad.TipoVehiculo;
import entidad.Vehiculo;
import entidad.VehiculoCotizacion;
import util.MysqlDBConexion;

public class VehiculoCotizacionDAO {
	public void insertar(VehiculoCotizacion vehiculoCotizacion) {
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO VehiculoCotizacion(precioVehCot,activoVehCot,idVeh,idCot,aceptaVehCot)" 
			+ "VALUES (?,1,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setDouble(1, vehiculoCotizacion.getPrecio());
			pst.setInt(2, vehiculoCotizacion.getVehiculo().getId());
			pst.setInt(3, vehiculoCotizacion.getCotizacion().getId());
			pst.setBoolean(4, vehiculoCotizacion.getAcepta());

			pst.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public VehiculoCotizacion buscarXVehCot(Integer idVeh, Integer idCot) {
		VehiculoCotizacion vehiculoCotizacion = null;
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM VehiculoCotizacion WHERE idVeh = ? and idCot = ? ";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idVeh);
			pst.setInt(2, idCot);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				vehiculoCotizacion = new VehiculoCotizacion();
				vehiculoCotizacion.setId(rs.getInt("idVehCot"));
				vehiculoCotizacion.setPrecio(rs.getDouble("precioVehCot"));
				vehiculoCotizacion.setActivo(rs.getBoolean("activoVehCot"));
				vehiculoCotizacion.setVehiculo(new Vehiculo(rs.getInt("idVeh")));
				vehiculoCotizacion.setCotizacion(new Cotizacion(rs.getInt("idCot")));
				vehiculoCotizacion.setAcepta(rs.getBoolean("aceptaVehCot"));
				
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculoCotizacion;
	}
	
	public int actualizar(VehiculoCotizacion vehiculoCotizacion) {
		Connection conn = null;
		int salida = -1;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "update VehiculoCotizacion set precioVehCot=?, aceptaVehCot=?  where idVehCot=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setDouble(1, vehiculoCotizacion.getPrecio());
			pst.setBoolean(2, vehiculoCotizacion.getAcepta());
			pst.setInt(3, vehiculoCotizacion.getId());

			salida = pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}
}
