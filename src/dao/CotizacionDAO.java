package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Cotizacion;
import entidad.Marca;
import entidad.Modelo;
import entidad.Seguradora;
import entidad.TipoVehiculo;
import util.MysqlDBConexion;

public class CotizacionDAO {
	
	
	
	 public void insertar(Cotizacion cotizacion) {
	        Connection conn = null;
	        try {
	            conn = MysqlDBConexion.getConexion();
	            String sql = "INSERT INTO cotizacion(precioCot,fechaCot,activoCot,idTip,idMod,idSeg)"
	                    + "VALUES (?,?,1,?,?,?)";
	            PreparedStatement pst= conn.prepareStatement(sql);
	            pst.setDouble(1, cotizacion.getPrecio());
	            pst.setDate(2, cotizacion.getFecha());
	            pst.setInt(3, cotizacion.getTipoVehiculo().getId());
	            pst.setInt(4, cotizacion.getModelo().getId());
	            pst.setInt(5, cotizacion.getSeguradora().getId());
	            pst.executeUpdate();
	            conn.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 public int actualizar(Cotizacion cotizacion) {
	        Connection conn = null;
	        int salida = -1;
	        try {
	            conn = MysqlDBConexion.getConexion();
	            String sql = "update cotizacion set precioCot=?, fechaCot=?,idTip=?,idMod=?,idSeg=?  where idCot=?";
	            PreparedStatement pst = conn.prepareStatement(sql);
	            pst.setDouble(1, cotizacion.getPrecio());
	            pst.setDate(2, cotizacion.getFecha());
	            pst.setInt(3, cotizacion.getTipoVehiculo().getId());
	            pst.setInt(4, cotizacion.getModelo().getId());
	            pst.setInt(5, cotizacion.getSeguradora().getId());
	            pst.setInt(6, cotizacion.getId());
	            salida = pst.executeUpdate();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return salida;
	    }
	 
	 public int eliminar(Cotizacion cotizacion) {
	        Connection conn = null;
	        int salida = -1;
	        try {
	            conn = MysqlDBConexion.getConexion();
	            String sql = "update cotizacion set activoCot=0  where idCot=?";
	            PreparedStatement pst = conn.prepareStatement(sql);
	            pst.setInt(1, cotizacion.getId());
	            salida = pst.executeUpdate();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return salida;
	    }
	 
	public List<Cotizacion> listarXModTip(Integer idTip, Integer idMod) {
		List<Cotizacion> lista = new ArrayList<Cotizacion>();
		Cotizacion cotizacion = null;
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM Cotizacion WHERE idTip = ? and idMod = ? ";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idTip);
			pst.setInt(2, idMod);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cotizacion = new Cotizacion();
				cotizacion.setId(rs.getInt("idCot"));
				cotizacion.setPrecio(rs.getDouble("precioCot"));
				cotizacion.setFecha(rs.getDate("fechaCot"));
				cotizacion.setActivo(rs.getBoolean("activoCot"));
				cotizacion.setTipoVehiculo(new TipoVehiculo(rs.getInt("idTip")));
				cotizacion.setModelo(new Modelo(rs.getInt("idMod")));
				cotizacion.setSeguradora(new Seguradora(rs.getInt("idSeg")));
				
				lista.add(cotizacion);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Cotizacion> listar() {
		List<Cotizacion> lista = new ArrayList<Cotizacion>();
		Cotizacion cotizacion = null;
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM Cotizacion WHERE activoCot=1 ";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cotizacion = new Cotizacion();
				cotizacion.setId(rs.getInt("idCot"));
				cotizacion.setPrecio(rs.getDouble("precioCot"));
				cotizacion.setFecha(rs.getDate("fechaCot"));
				cotizacion.setActivo(rs.getBoolean("activoCot"));
				cotizacion.setTipoVehiculo(new TipoVehiculo(rs.getInt("idTip")));
				cotizacion.setModelo(new Modelo(rs.getInt("idMod")));
				cotizacion.setSeguradora(new Seguradora(rs.getInt("idSeg")));
				
				lista.add(cotizacion);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Cotizacion obtener(Integer idCot) {
		Cotizacion cotizacion = null;
		Connection conn = null;
		try {
			conn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM Cotizacion WHERE idCot = ? ";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, idCot);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cotizacion = new Cotizacion();
				cotizacion.setId(rs.getInt("idCot"));
				cotizacion.setPrecio(rs.getDouble("precioCot"));
				cotizacion.setFecha(rs.getDate("fechaCot"));
				cotizacion.setActivo(rs.getBoolean("activoCot"));
				cotizacion.setTipoVehiculo(new TipoVehiculo(rs.getInt("idTip")));
				cotizacion.setModelo(new Modelo(rs.getInt("idMod")));
				cotizacion.setSeguradora(new Seguradora(rs.getInt("idSeg")));
				
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cotizacion;
	}
}
