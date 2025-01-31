package com.app.Movimientos;

import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public class MovCaballo implements Movimientos{
    @Override
    public Boolean movimiento(Ficha ficha, TableroJuego tablero, int fila, int columna) {
        int[] currentPosCaballo = ficha.getPos();
        int[] posObjetivo = new int[]{fila+1,columna+1}; 
        String equipo = ficha.getColor();
        String valEqContrario;
        //Creamos un validador de equipo para validar si puede ir a una casilla que no esté vacia.
        if (equipo.equals("Blanco")) {
            valEqContrario = "Negro";
        }else{
            valEqContrario = "Blanco";
        }
        // Lista de posibles movimientos
        int[][] movimientos = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };
        
        // Generar todas las posiciones posibles basadas en los movimientos
        for (int[] movimiento : movimientos) {
                int filaCurrent = currentPosCaballo[0];
                int columnaCurrent = currentPosCaballo[1];
                
                filaCurrent += movimiento[0];
                columnaCurrent += movimiento[1];

                if (filaCurrent == posObjetivo[0] && columnaCurrent == posObjetivo[1]) { //Comprueba si el movimiento es posible
                    if (tablero.getTablero()[fila][columna].getCasilla() == null || tablero.getTablero()[fila][columna].getCasilla().getColor().equals(valEqContrario)) {
                        tablero.getTablero()[filaCurrent-1][columnaCurrent-1].fillCasilla(ficha, posObjetivo);
                        tablero.getTablero()[currentPosCaballo[0]-1][currentPosCaballo[1]-1].cleanCasilla();
                        return true;
                        
                    }
                }
            }
        return false;
    }

}
