package aplicacion.dao;

import aplicacion.db.Conexion;
import aplicacion.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {

    static final Conexion conexion = new Conexion();

    public static void guardarUsuario(Usuario usuario) {
        //Elemento que me permite validar la conexion con l a bd
        try(Connection connection = conexion.dBConexion()){
            //elemento para manipular los datos
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO usuario(id, nombre, apellido, correo, contraseña) VALUES (?,?,?,?,?)";
                ps = connection.prepareStatement(query);

                ps.setInt(1,usuario.getId());
                ps.setString(2,usuario.getNombre());
                ps.setString(3,usuario.getApellido());
                ps.setString(4,usuario.getCorreo());
                ps.setString(5,usuario.getContraseña());

                ps.executeUpdate();
                System.out.println("Usuario registrado con exito");
            }catch (SQLException e){
                System.out.println("Error al guardar los datos del usuario");
                System.out.println(e);
            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }


    public static void verUsuario() {

        try(Connection connection = conexion.dBConexion()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "select * from usuario";
                ps = connection.prepareStatement(query);
                rs=ps.executeQuery();

                while (rs.next()) {
                    System.out.println("id usuario: " + rs.getInt("id"));
                    System.out.println("Nombre: " + rs.getString("nombre"));
                    System.out.println("Apellidos: " + rs.getString("apellido"));
                    System.out.println("Correo: " + rs.getString("correo"));
                    System.out.println("contraseña: " + rs.getString("contraseña"));
                    System.out.println("---------------------------------------");
                }
            }catch (SQLException e){
                System.out.println("Error al visualizar los datos de los clientes");
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }


    public static void actualizarUsuario(Usuario usuario) {
        //Elemento que me permite validar la conexion con l a bd
        try(Connection connection = conexion.dBConexion()){
            //elemento para manipular los datos
            PreparedStatement ps = null;
            try{
                String query = "UPDATE usuario SET nombre = ?, apellido = ?, correo = ?, contraseña = ? WHERE id = ?";
                ps = connection.prepareStatement(query);

                ps.setString(1, usuario.getNombre());
                ps.setString(2, usuario.getApellido());
                ps.setString(3, usuario.getCorreo());
                ps.setString(4, usuario.getContraseña());
                ps.setInt(5, usuario.getId());

                int filasAfectadas = ps.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Usuario actualizado con éxito");
                } else {
                    System.out.println("No se encontró ningún usuario con el ID especificado");
                }
            }catch (SQLException e){
                System.out.println("Error al guardar los datos del usuario");
                System.out.println(e);
            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }


    public static void eliminarUsuario(int idCliente) {
        //Elemento que me permite validar la conexion con l a bd
        try(Connection connection = conexion.dBConexion()){
            //elemento para manipular los datos
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM usuario WHERE id = ?";
                ps = connection.prepareStatement(query);

                ps.setInt(1, idCliente);

                int filasAfectadas = ps.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Usuario eliminado con éxito");
                } else {
                    System.out.println("No se encontró ningún usuario con el ID especificado");
                }
            }catch (SQLException e){
                System.out.println("Error al eliminar los datos del usuario");
                System.out.println(e);
            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
