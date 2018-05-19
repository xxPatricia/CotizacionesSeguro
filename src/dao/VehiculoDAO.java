package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Cliente;
import entidad.Marca;
import entidad.Modelo;
import entidad.TipoVehiculo;
import entidad.Vehiculo;
import util.MysqlDBConexion;

public class VehiculoDAO {
	public void insertar(Vehiculo vehiculo) {
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO Vehiculo(matriculaVeh,fabricacionVeh,precioVeh,convertidorGasVeh,idCli,idMod,idTip)" 
			+ "VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, vehiculo.getMatricula());
			pst.setString(2, vehiculo.getFabricacion());
			pst.setString(3, vehiculo.getPrecio());
			pst.setString(4, vehiculo.getConvertidor());
			pst.setInt(5, vehiculo.getCliente().getId());
			pst.setInt(6, vehiculo.getModelo().getId());
			pst.setInt(7, vehiculo.getTipoVehiculo().getId());

			pst.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Vehiculo obtener(Integer idVeh) {
		Vehiculo vehiculo = new Vehiculo();
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM Vehiculo WHERE idVeh = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idVeh);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				vehiculo.setId(rs.getInt("idVeh"));
				vehiculo.setMatricula(rs.getString("matriculaVeh"));
				vehiculo.setFabricacion(rs.getString("fabricacionVeh"));
				vehiculo.setPrecio(rs.getString("precioVeh"));
				vehiculo.setConvertidor(rs.getString("convertidorGasVeh"));
				vehiculo.setActivo(rs.getBoolean("activoVeh"));
				vehiculo.setCliente(new Cliente(rs.getInt("idCli")));
				vehiculo.setModelo(new Modelo(rs.getInt("idMod")));
				vehiculo.setTipoVehiculo(new TipoVehiculo(rs.getInt("idTip")));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculo;
	}
	
	public Vehiculo obtenerUltimo() {
		Vehiculo vehiculo = new Vehiculo();
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "select * from Vehiculo order by idVeh desc limit 1";
			PreparedStatement pst = conn.prepareStatement(sql); 
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				vehiculo.setId(rs.getInt("idVeh"));
				vehiculo.setMatricula(rs.getString("matriculaVeh"));
				vehiculo.setFabricacion(rs.getString("fabricacionVeh"));
				vehiculo.setPrecio(rs.getString("precioVeh"));
				vehiculo.setConvertidor(rs.getString("convertidorGasVeh"));
				vehiculo.setActivo(rs.getBoolean("activoVeh"));
				vehiculo.setCliente(new Cliente(rs.getInt("idCli")));
				vehiculo.setModelo(new Modelo(rs.getInt("idMod")));
				vehiculo.setTipoVehiculo(new TipoVehiculo(rs.getInt("idTip")));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculo;
	}
}
