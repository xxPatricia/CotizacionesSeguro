package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidad.Marca;
import entidad.Pago;
import util.MysqlDBConexion;

public class PagoDAO {
	public void insertar(Pago pago) {
        Connection conn = null;
        try {
            conn = MysqlDBConexion.getConexion();
            String sql = "INSERT INTO pago(cuotasPag,medioPag,diaPag,fechaPag,idVehCot,activoPag)"
                    + "VALUES (?,?,?,?,?,1)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, pago.getCuotas());
            pst.setString(2, pago.getMedio());
            pst.setInt(3, pago.getDia());
            pst.setDate(4, pago.getFecha());
            pst.setInt(5, pago.getVehiculoCotizacion().getId());
          
            pst.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
