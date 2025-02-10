package com.app;

import javax.swing.SwingUtilities;

import com.app.Vista.ChessMenu;

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
                new ChessMenu();
            }

        });

        /* Crear instancia de ControllerTablero
        ControllerTablero controller = new ControllerTablero();
        
        
        controller.iniciarJuego();

        ArrayList<Casilla> piezas = controller.getPiezasEquipo();
        
        System.out.println(controller.moverFicha(piezas.get(1), piezas.get(9)));*/
    }
}
