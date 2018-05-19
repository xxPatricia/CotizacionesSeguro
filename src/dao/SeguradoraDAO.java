package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Marca;
import entidad.Seguradora;
import util.MysqlDBConexion;

public class SeguradoraDAO {
	public void insertar(Seguradora seguradora) {
        Connection conn = null;
        try {
            conn = MysqlDBConexion.getConexion();
            String sql = "INSERT INTO seguradora(nombreSeg,activoSeg,descripcionSeg)"
                    + "VALUES (?,1,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, seguradora.getNombre());
            pst.setString(2, seguradora.getDescripcion());
        
          
            pst.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 public int actualizar(Seguradora seguradora) {
        Connection conn = null;
        int salida = -1;
        try {
            conn = MysqlDBConexion.getConexion();
            String sql = "update seguradora set nombreSeg=?, descripcionSeg=?  where idSeg=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, seguradora.getNombre());
            pst.setString(2, seguradora.getDescripcion());
            pst.setInt(3, seguradora.getId());

 
            salida = pst.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salida;
    }
 
 public int eliminar(Seguradora seguradora) {
		Connection conn = null;
		int salida = -1;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "update seguradora set activoSeg=0  where idSeg=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, seguradora.getId());

			salida = pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}
 
 
public List<Seguradora> listar() {
	List<Seguradora> lista = new ArrayList<Seguradora>();
	Seguradora seguradora = null;
	Connection conn = null;
	try {
		conn = MysqlDBConexion.getConexion();
		String sql = "SELECT * FROM seguradora WHERE activoSeg=1";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			seguradora = new Seguradora();
			seguradora.setId(rs.getInt("idSeg"));
			seguradora.setNombre(rs.getString("nombreSeg"));
			seguradora.setActivo(rs.getBoolean("activoSeg"));
			seguradora.setDescripcion(rs.getString("descripcionSeg"));
			lista.add(seguradora);
		}
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return lista;
}
	
	public Seguradora obtener(Integer idSeg) {
		Seguradora seguradora = new Seguradora();
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM seguradora WHERE idSeg = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idSeg);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				seguradora.setId(rs.getInt("idSeg"));
				seguradora.setNombre(rs.getString("nombreSeg"));
				seguradora.setDescripcion(rs.getString("descripcionSeg"));
				seguradora.setActivo(rs.getBoolean("activoSeg"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seguradora;
	}
}
