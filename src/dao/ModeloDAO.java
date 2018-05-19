package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Marca;
import entidad.Modelo;
import util.MysqlDBConexion;

public class ModeloDAO {

	public void insertar(Modelo modelo) {
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO modelo(nombreMod,activoMod,idMar,precioMod)" + "VALUES (?,1,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, modelo.getNombre());
			pst.setInt(2, modelo.getMarca().getId());
			pst.setInt(3, modelo.getPrecio());

			pst.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int actualizar(Modelo modelo) {
		Connection conn = null;
		int salida = -1;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "update modelo set nombreMod=?, precioMod=?, idMar=?  where idMod=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, modelo.getNombre());
			pst.setInt(2, modelo.getPrecio());
			pst.setInt(3, modelo.getMarca().getId());
			pst.setInt(4, modelo.getId());

			salida = pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}
	
	public int eliminar(Modelo modelo) {
		Connection conn = null;
		int salida = -1;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "update modelo set activoMod=0  where idMod=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, modelo.getId());

			salida = pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}

	public List<Modelo> listar() {
		List<Modelo> lista = new ArrayList<Modelo>();
		Modelo modelo = null;
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM modelo where activoMod = 1 ";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				modelo = new Modelo();
				modelo.setId(rs.getInt("idMod"));
				modelo.setNombre(rs.getString("nombreMod"));
				modelo.setActivo(rs.getBoolean("activoMod"));
				modelo.setPrecio(rs.getInt("precioMod"));
				modelo.setMarca(new Marca(rs.getInt("idMar")));
				lista.add(modelo);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public List<Modelo> listarXMar(Integer idMar) {
		List<Modelo> lista = new ArrayList<Modelo>();
		Modelo modelo = null;
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM modelo WHERE idMar = ? ";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idMar);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				modelo = new Modelo();
				modelo.setId(rs.getInt("idMod"));
				modelo.setNombre(rs.getString("nombreMod"));
				modelo.setActivo(rs.getBoolean("activoMod"));
				modelo.setMarca(new Marca(rs.getInt("idMar")));
				lista.add(modelo);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Modelo obtener(Integer idMod) {
		Modelo modelo = new Modelo();
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM modelo WHERE idMod = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idMod);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				modelo.setId(rs.getInt("idMod"));
				modelo.setNombre(rs.getString("nombreMod"));
				modelo.setActivo(rs.getBoolean("activoMod"));
				modelo.setMarca(new Marca(rs.getInt("idMar")));
				modelo.setPrecio(rs.getInt("precioMod"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelo;
	}
}
