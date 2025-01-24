package com.app;

import javax.swing.SwingUtilities;

import com.app.Controller.ControllerTablero;
import com.app.Fichas.Ficha;
import com.app.Vista.MainWindow;

/**
 * Hello world!
 *
 */
public class App 
{
   public static void main(String[] args){
        System.out.println();
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                new MainWindow();
            }

        });

        // Crear instancia de ControllerTablero
        ControllerTablero controller = new ControllerTablero();
        
        // Verificar que el tablero no es nulo
        if (controller.tablero != null) {
            System.out.println("El tablero ha sido inicializado correctamente.");
        } else {
            System.out.println("Error: El tablero no fue inicializado.");
        }

        // Configurar el equipo Blanco
        controller.seleccionEquipo("Blanco");

        // Verificar que las piezas del equipo Blanco han sido agregadas
        if (controller.piezasEquipo.isEmpty()) {
            System.out.println("Error: No se inicializaron las piezas del equipo Blanco.");
        } else {
            System.out.println("Piezas del equipo Blanco inicializadas:");
            for (Ficha ficha : controller.piezasEquipo) {
                System.out.println(
                    ficha.getClass().getSimpleName() + 
                    " en posición (" + ficha.getPos()[0] + ", " + ficha.getPos()[1] + 
                    ") - Color: " + ficha.getColor()
                );
            }
        }

        // Limpiar la lista de piezas para el siguiente test
        controller.piezasEquipo.clear();

        // Configurar el equipo Negro
        controller.seleccionEquipo("Negro");

        // Verificar que las piezas del equipo Negro han sido agregadas
        if (controller.piezasEquipo.isEmpty()) {
            System.out.println("Error: No se inicializaron las piezas del equipo Negro.");
        } else {
            System.out.println("Piezas del equipo Negro inicializadas:");
            for (Ficha ficha : controller.piezasEquipo) {
                System.out.println(
                    ficha.getClass().getSimpleName() + 
                    " en posición (" + ficha.getPos()[0] + ", " + ficha.getPos()[1] + 
                    ") - Color: " + ficha.getColor()
                );
            }
        }

    }
}
