package com.app.Movimientos;

import java.util.ArrayList;
import java.util.List;

import com.app.Fichas.Ficha;

public class MovReina implements Movimientos{

    @Override
    public List<int[]> movimiento(Ficha ficha) {
        int[] currentPosReina = ficha.getPos();
        List<int[]> posiblesMovimientos = new ArrayList<>();
        
        // Direcciones posibles (vertical, horizontal y diagonal)
        int[][] direcciones = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}, // Movimientos verticales y horizontales
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // Movimientos diagonales
        };
        
        // Generar todas las posiciones posibles en cada dirección
        for (int[] direccion : direcciones) {
            int fila = currentPosReina[0];
            int columna = currentPosReina[1];
            
            while (true) {
                // Calcular la nueva posición
                fila += direccion[0];
                columna += direccion[1];
                
                // Verificar si la nueva posición está dentro del tablero (límites 1-8)
                if (fila < 1 || fila > 8 || columna < 1 || columna > 8) {
                    break; // Salir del bucle si se sale del tablero
                }
                
                // Agregar la nueva posición a los movimientos posibles
                posiblesMovimientos.add(new int[]{fila, columna});
            }
        }
        return posiblesMovimientos;
    }

}
