package aplicacion.service;

import aplicacion.dao.ClienteDao;
import aplicacion.model.Usuario;

import java.util.Scanner;

public class ClienteService implements IClienteService{
    Scanner sc = new Scanner(System.in);

    @Override
    public void guardarUsuario(Usuario usuario) {
        System.out.println("Ingresar los siguientes datos del cliente");
        System.out.println("id: ");
        int id = sc.nextInt();
        sc.nextLine();
        usuario.setId(id);

        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        usuario.setNombre(nombre);

        System.out.println("Apellido: ");
        String apellido = sc.nextLine();
        usuario.setApellido(apellido);

        System.out.println("Correo: ");
        String correo = sc.nextLine();
        usuario.setCorreo(correo);

        System.out.println("Contraseña: ");
        String contraseña = sc.nextLine();
        usuario.setContraseña(contraseña);
        ClienteDao.guardarUsuario(usuario);
    }

    @Override
    public void verUsuario() {
        ClienteDao.verUsuario();
    }

    @Override
    public void actualizarUsuario (Usuario usuario) {
        System.out.println("Ingresar los datos actualizados del cliente");
        System.out.println("id: ");
        int id = sc.nextInt();
        sc.nextLine();
        usuario.setId(id);

        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        usuario.setNombre(nombre);

        System.out.println("Apellido: ");
        String apellido = sc.nextLine();
        usuario.setApellido(apellido);

        System.out.println("Correo: ");
        String correo = sc.nextLine();
        usuario.setCorreo(correo);

        System.out.println("Contraseña: ");
        String contraseña = sc.nextLine();
        usuario.setContraseña(contraseña);
        ClienteDao.actualizarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario() {
        System.out.println("Ingrese el ID del cliente que desea eliminar:");
        int id = sc.nextInt();
        sc.nextLine();
        ClienteDao.eliminarUsuario(id);
    }
}
