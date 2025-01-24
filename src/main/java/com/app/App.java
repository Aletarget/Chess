package com.app;

import javax.swing.SwingUtilities;

import com.app.Controller.ControllerTablero;
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
        
        controller.iniciarJuego();

    }
}
