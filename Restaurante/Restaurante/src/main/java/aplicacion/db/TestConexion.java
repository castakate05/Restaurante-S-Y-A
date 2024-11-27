package aplicacion.db;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.dBConexion()){

        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
