package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Marca;
import entidad.TipoVehiculo;
import util.MysqlDBConexion;

public class TipoVehiculoDAO {
	public List<TipoVehiculo> listar() {
		List<TipoVehiculo> lista = new ArrayList<TipoVehiculo>();
		//TipoVehiculo tipoVehiculo = null;
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM TipoVehiculo ";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				TipoVehiculo tipoVehiculo = new TipoVehiculo();
				tipoVehiculo.setId(rs.getInt("idTip"));
				tipoVehiculo.setNombre(rs.getString("nombreTip"));
				tipoVehiculo.setDescripcion(rs.getString("descripcionTip"));
				tipoVehiculo.setActivo(rs.getBoolean("activoTip"));
				
				lista.add(tipoVehiculo);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public TipoVehiculo obtener(Integer idTip) {
		TipoVehiculo tipoVehiculo = new TipoVehiculo();
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM TipoVehiculo WHERE idTip = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idTip);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				tipoVehiculo.setId(rs.getInt("idTip"));
				tipoVehiculo.setNombre(rs.getString("nombreTip"));
				tipoVehiculo.setDescripcion(rs.getString("descripcionTip"));
				tipoVehiculo.setActivo(rs.getBoolean("activoTip"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoVehiculo;
	}
}
