package aplicacion.model;

abstract public class Restaurante {
    protected String nombreRestaurante;

    public Restaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public abstract void mostrarBienvenida();
}