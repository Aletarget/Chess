package com.app.Movimientos;

import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public class MovReina implements Movimientos{

    @Override
    public Boolean movimiento(Ficha ficha, TableroJuego tablero, int fila, int columna) {
        int[] currentPosReina = ficha.getPos();
        int[] posObjetivo = new int[]{fila+1,columna+1};
        String equipo = ficha.getColor();
        String valEqContrario;
        //Creamos un validador de equipo para validar si puede ir a una casilla que no esté vacia.
        if (equipo.equals("Blanco")) {
            valEqContrario = "Negro";
        }else{
            valEqContrario = "Negro";
        }
        
        // Direcciones posibles (vertical, horizontal y diagonal)
        int[][] direcciones = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}, // Movimientos verticales y horizontales
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // Movimientos diagonales
        };
        
        // Generar todas las posiciones posibles en cada dirección
        for (int[] direccion : direcciones) {
            int filaCurrent = currentPosReina[0];
            int columnaCurrent = currentPosReina[1];
            
            while(true) {
                // Calcular la nueva posición
                filaCurrent += direccion[0];
                columnaCurrent += direccion[1];

                if (filaCurrent == fila && columnaCurrent == columna) { //Comprueba si el movimiento es posible
                    if (tablero.getTablero()[fila][columna].getCasilla() == null || 
                        tablero.getTablero()[fila][columna].getCasilla().getColor().equals(valEqContrario)) {
                        tablero.getTablero()[filaCurrent][columnaCurrent].fillCasilla(ficha, posObjetivo);
                        tablero.getTablero()[currentPosReina[0]][currentPosReina[1]].cleanCasilla();
                        return true;
                    }
                }
                // Verificar si la nueva posición está dentro del tablero (límites 1-8)
                if (fila < 1 || fila > 8 || columna < 1 || columna > 8) {
                    break; // Salir del bucle si se sale del tablero
                }
                
            }
        }
        return false;
    }

}
