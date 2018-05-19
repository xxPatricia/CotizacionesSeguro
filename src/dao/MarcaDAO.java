package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import entidad.Marca;
import entidad.Modelo;
import util.MysqlDBConexion;

public class MarcaDAO {
	
	 public void insertar(Marca marca) {
	        Connection conn = null;
	        try {
	            conn = MysqlDBConexion.getConexion();
	            String sql = "INSERT INTO marca(nombreMar,activoMar)"
	                    + "VALUES (?,1)";
	            PreparedStatement pst = conn.prepareStatement(sql);
	            pst.setString(1, marca.getNombre());
	          
	        
	          
	            pst.executeUpdate();
	            conn.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 public int actualizar(Marca marca) {
	        Connection conn = null;
	        int salida = -1;
	        try {
	            conn = MysqlDBConexion.getConexion();
	            String sql = "update marca set nombreMar=?  where idMar=?";
	            PreparedStatement pst = conn.prepareStatement(sql);
	            pst.setString(1, marca.getNombre());
	            pst.setInt(2, marca.getId());

	 
	            salida = pst.executeUpdate();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return salida;
	    }
	 
	 public int eliminar(Marca marca) {
			Connection conn = null;
			int salida = -1;
			try {
				conn = MysqlDBConexion.getConexion();
				String sql = "update marca set activoMar=0  where idMar=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, marca.getId());

				salida = pst.executeUpdate();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return salida;
		}
	 
	 
	public List<Marca> listar() {
		List<Marca> lista = new ArrayList<Marca>();
		Marca marca = null;
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM Marca WHERE activoMar=1";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				marca = new Marca();
				marca.setId(rs.getInt("idMar"));
				marca.setNombre(rs.getString("nombreMar"));
				marca.setActivo(rs.getBoolean("activoMar"));
				lista.add(marca);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Marca obtener(Integer idMar) {
		Marca marca = new Marca();
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM marca WHERE idMar = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idMar);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				marca.setId(rs.getInt("idMar"));
				marca.setNombre(rs.getString("nombreMar"));
				marca.setActivo(rs.getBoolean("activoMar"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return marca;
	}
}
