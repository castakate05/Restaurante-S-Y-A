package aplicacion.view;

import aplicacion.model.Usuario;
import aplicacion.service.ClienteService;

public class Usuarioview {
    public static void main(String[] args) {

       ClienteService clienteService = new ClienteService();

        Usuario usuario = new Usuario();

        clienteService.verUsuario();
        clienteService.guardarUsuario(usuario);


        clienteService.eliminarUsuario();
        clienteService.guardarUsuario(usuario);
        clienteService.verUsuario();
        clienteService.actualizarUsuario(usuario);
        clienteService.verUsuario();
        clienteService.eliminarUsuario();
        clienteService.verUsuario();

    }
}
