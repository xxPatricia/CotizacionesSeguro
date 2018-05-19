package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import entidad.Usuario;
import util.MysqlDBConexion;

public class UsuarioDAO {
	public void insertar(Usuario usuario) {
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO usuario(nombreUsu,claveUsu,perfilUsu,activoUsu)" + "VALUES (?,?,?,1)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getClave());
			pst.setString(3, usuario.getPerfil());
			// pst.setInt(3, usuario.getRol().getIdRol());
			pst.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer buscarUltimo() {
		Integer id = null;
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT MAX(idUsu) FROM usuario";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}
