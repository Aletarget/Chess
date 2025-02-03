package com.app.Movimientos;


import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public class MovRey implements Movimientos{
    @Override
    public Boolean movimiento(Ficha ficha, TableroJuego tablero, int fila, int columna) {
        int[] currentPosRey = ficha.getPos();
        int[] posObjetivo = new int[]{fila+1,columna+1};
        String equipo = ficha.getColor();
        String valEqContrario = equipo.equals("Blanco") ? "Negro" : "Blanco";
        int[][] direcciones = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };
        
        for (int[] direccion : direcciones) {
            int filaCurrent = currentPosRey[0];
                int columnaCurrent = currentPosRey[1];
                
                filaCurrent += direccion[0];
                columnaCurrent += direccion[1];

                if (filaCurrent == posObjetivo[0] && columnaCurrent == posObjetivo[1]) { //Comprueba si el movimiento es posible
                    if (tablero.getTablero()[fila][columna].getCasilla() == null || 
                        tablero.getTablero()[fila][columna].getCasilla().getColor().equals(valEqContrario)) {
                            
                        tablero.getTablero()[filaCurrent-1][columnaCurrent-1].fillCasilla(ficha, posObjetivo);
                        tablero.getTablero()[currentPosRey[0]-1][currentPosRey[1]-1].cleanCasilla();
                        return true;
                    }
                }
        }
        return true;
    }
}
