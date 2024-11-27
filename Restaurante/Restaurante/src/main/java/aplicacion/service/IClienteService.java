package aplicacion.service;

import aplicacion.model.Usuario;
import com.mysql.cj.xdevapi.Client;

public interface IClienteService {

    public void guardarUsuario(Usuario usuario);
    public void verUsuario();
    public void actualizarUsuario(Usuario usuario);
    public void eliminarUsuario();
}
