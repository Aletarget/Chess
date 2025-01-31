package com.app.Movimientos;

import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public class MovAlfil implements Movimientos{
    @Override
    public Boolean movimiento(Ficha ficha, TableroJuego tablero, int fila, int columna) {
       int[] currentPosAlfil = ficha.getPos();
       int[] posDestino = new int[]{fila, columna};
       String equipo = ficha.getColor();
       String valEqContrario;
       //Creamos un validador de equipo para validar si puede ir a una casilla que no esté vacia.
       if (equipo.equals("Blanco")) {
           valEqContrario = "Negro";
       }else{
           valEqContrario = "Blanco";
       }
        int[][] direcciones = {
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };
        
        for (int[] direccion : direcciones) {
            int currentFila = currentPosAlfil[0];
            int currentColumna = currentPosAlfil[1];

            for (int i = 0; i < 8; i++) {
                currentFila = direccion[0] * i;
                currentColumna = direccion[1] * i;
                if (tablero.getTablero()[fila][columna].getCasilla() == null) {
                    if (tablero.getTablero()[currentFila][currentColumna].getCasilla().getColor().equals(ficha.getColor())) {
                        System.out.println("El movimiento no es posible realizarlo debido a que hay una ficha del mismo color en el camino");
                        return false;
                    }else{
                        if (tablero.getTablero()[fila][columna].getCasilla().getColor().equals(valEqContrario)) {
                            //logica de eliminar la ficha que esta en esa posic
                        }
                        tablero.getTablero()[currentFila][currentColumna].fillCasilla(ficha, posDestino);
                        tablero.getTablero()[currentPosAlfil[0]][currentPosAlfil[1]].cleanCasilla();
                        return true;
                    }
                    
                    
                }
            }
        }
        return true;
    }
}