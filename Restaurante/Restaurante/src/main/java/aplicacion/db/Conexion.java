package aplicacion.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection dBConexion(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/restaurante","root","");
            if(connection != null){
                System.out.println("Conexion con la Base de Datos exitosa");
            }
        }catch(SQLException e){
            System.out.println("Error al concetar con" +
                    "la base de datos");
            System.out.println(e);
        }
        return connection;
    }
}
