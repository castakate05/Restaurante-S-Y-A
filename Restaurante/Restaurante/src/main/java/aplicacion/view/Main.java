package aplicacion.view;

import aplicacion.model.Plato;
import aplicacion.model.saboryalma;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        saboryalma restaurante = new saboryalma("Sabor y Alma");
        restaurante.mostrarBienvenida();
        restaurante.mostrarMenu();
        {
            List<Plato> pedido = new ArrayList<>();
            boolean continuar = true;

            while (continuar) {
                try {
                    int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingresa el número del plato que deseas pedir (1-" + restaurante.obtenerTamañoMenu() + "):"));
                    if (opcion < 1 || opcion > restaurante.obtenerTamañoMenu()) {
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intenta nuevamente.");
                        continue;
                    }

                    Plato platoSeleccionado = restaurante.obtenerPlato(opcion);
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad para " + platoSeleccionado.getNombre() + ":"));
                    for (int i = 0; i < cantidad; i++) {
                        pedido.add(platoSeleccionado);
                    }

                    int continuarOpcion = JOptionPane.showConfirmDialog(null, "¿Deseas agregar otro plato?", "Continuar Pedido", JOptionPane.YES_NO_OPTION);
                    continuar = (continuarOpcion == JOptionPane.YES_OPTION);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada no válida. Intenta nuevamente.");
                }
            }

            double total = pedido.stream().mapToDouble(Plato::getPrecio).sum();

            StringBuilder resumen = new StringBuilder("Resumen de tu pedido:\n");
            for (Plato plato : pedido) {
                resumen.append(plato.getNombre()).append(" - $").append(plato.getPrecio()).append("\n");
            }
            resumen.append("Total a pagar: $").append(String.format("%.2f", total));

            JOptionPane.showMessageDialog(null, resumen.toString());
            JOptionPane.showMessageDialog(null, "¡Gracias por tu pedido! Que disfrutes tu experiencia en Sabor y Alma.");
        }
    }}