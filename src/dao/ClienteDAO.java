package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Cliente;
import entidad.Usuario;
import util.MysqlDBConexion;
public class ClienteDAO {
    public void insertar(Cliente cliente) {
        Connection conn = null;
        try {
            conn = MysqlDBConexion.getConexion();
            String sql = "INSERT INTO cliente(nombreCli,apellidosCli,direccionCli,edadCli,telefonoCli,emailCli,activoCli,dniCli,idUsu)"
                    + "VALUES (?,?,?,?,?,?,1,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellidos());
            pst.setString(3, cliente.getDireccion());
            pst.setInt(4, cliente.getEdad());
            pst.setInt(5, cliente.getTelefono());
            pst.setString(6, cliente.getEmail());
            pst.setString(7, cliente.getDni());
            pst.setInt(8, cliente.getUsuario().getId());
           

            pst.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
