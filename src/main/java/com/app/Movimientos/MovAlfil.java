package com.app.Movimientos;

import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public class MovAlfil implements Movimientos{
    @Override
    public Boolean movimiento(Ficha ficha, TableroJuego tablero, int fila, int columna) {
        int[] currentPosAlfil = ficha.getPos();
        int[] posDestino = new int[]{fila, columna};
        String equipo = ficha.getColor();
        String valEqContrario = equipo.equals("Blanco") ? "Negro" : "Blanco";
    
        int[][] direcciones = {
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        for (int[] direccion : direcciones) {
            int currentFila = currentPosAlfil[0];
            int currentColumna = currentPosAlfil[1];
    
            // Avanzar en la dirección mientras no se salga del tablero
            while (true) { // Permitir que el alfil siga moviéndose hasta chocar con algo
                currentFila += direccion[0];  
                currentColumna += direccion[1];
        
                // Verificar si la nueva posición está dentro del tablero
                if (currentFila < 0 || currentFila >= 8 || currentColumna < 0 || currentColumna >= 8) {
                    break; // Salir del bucle si se sale del tablero
                }
        
                // Si la casilla está vacía, permitir el movimiento
                if (tablero.getTablero()[currentFila][currentColumna].getCasilla() == null) {
                    if (currentFila == posDestino[0] && currentColumna == posDestino[1]) {
                        tablero.getTablero()[posDestino[0]][posDestino[1]].fillCasilla(ficha, posDestino);
                        tablero.getTablero()[currentPosAlfil[0]][currentPosAlfil[1]].cleanCasilla();
                        return true;
                    }
                } else {
                    // Si la casilla tiene una pieza del equipo contrario, permitir capturar
                    if (tablero.getTablero()[currentFila][currentColumna].getCasilla().getColor().equals(valEqContrario)) {
                        if (currentFila == posDestino[0] && currentColumna == posDestino[1]) {
                            tablero.getTablero()[posDestino[0]][posDestino[1]].fillCasilla(ficha, posDestino);
                            tablero.getTablero()[currentPosAlfil[0]][currentPosAlfil[1]].cleanCasilla();
                            return true;
                        }
                    }
                    System.err.println("Se encontro ficha en el caamino");
                    break; // Si encuentra cualquier pieza, detiene el movimiento
                }
            }
        }
    
        return false;
    }
}