package aplicacion.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class saboryalma extends Restaurante {
    public List<Plato> menu;

    public saboryalma(String nombreRestaurante) {
        super(nombreRestaurante);
        this.menu = new ArrayList<>();
        inicializarMenu();
    }

    private void inicializarMenu() {
        menu.add(new Plato("Rollitos Heisei", 34.000));
        menu.add(new Plato("Lomo Sabor Y Alma", 55.000));
        menu.add(new Plato("Pulpo Sabor Y Alma", 60.000));
        menu.add(new Plato("Pollo Trufado",  37.000));
    }
    public void mostrarMenu() {
        StringBuilder menuTexto = new StringBuilder("Menú de " + nombreRestaurante + ":\n");
        for (int i = 0; i < menu.size(); i++) {
            Plato plato = menu.get(i);
            menuTexto.append((i + 1)).append(". ").append(plato.getNombre()).append(" - $").append(plato.getPrecio()).append("\n");
        }
        JOptionPane.showMessageDialog(null, menuTexto.toString());
    }

    public Plato obtenerPlato(int indice) {
        return menu.get(indice - 1);
    }

    public int obtenerTamañoMenu() {
        return menu.size();
    }

    @Override
    public void mostrarBienvenida() {
        JOptionPane.showMessageDialog(null, "¡Bienvenido a " + nombreRestaurante + "! Estamos encantados de atenderte.");
    }
}