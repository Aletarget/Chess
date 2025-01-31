package com.app.Movimientos;

import java.util.ArrayList;
import java.util.List;

import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public class MovTorre implements Movimientos{
    @Override
     public Boolean movimiento(Ficha ficha, TableroJuego tablero, int fila, int columna) {
        List<int[]> posiblesMovimientos = new ArrayList<>();
        int[][] direcciones = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1} // Movimiento horizontal y vertical
        };
        
        for (int[] direccion : direcciones) {
            for (int i = 1; i < 8; i++) {  // Máximo 7 movimientos en una dirección dentro del tablero
                int[] nuevaPos = {
                    ficha.getPos()[0] + direccion[0] * i,
                    ficha.getPos()[1] + direccion[1] * i
                };
                // Comprobar que la nueva posición está dentro del tablero
                if (nuevaPos[0] >= 0 && nuevaPos[0] < 8 && nuevaPos[1] >= 0 && nuevaPos[1] < 8) {
                    posiblesMovimientos.add(nuevaPos);
                } else {
                    break; // Sale del tablero, no hay más movimientos en esta dirección
                }
            }
        }
        return true;
    }
}
