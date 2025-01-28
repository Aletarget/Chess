package com.app.Movimientos;

import java.util.ArrayList;
import java.util.List;

import com.app.Fichas.Ficha;

public class MovAlfil implements Movimientos{
    @Override
    public List<int[]> movimiento(Ficha ficha) {
        List<int[]> posiblesMovimientos = new ArrayList<>();
        int[][] direcciones = {
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };
        
        for (int[] direccion : direcciones) {
            for (int i = 1; i < 8; i++) {  // Máximo 7 movimientos en una dirección dentro del tablero
                int[] nuevaPos = {
                    ficha.getPos()[0] + direccion[0] * i,
                    ficha.getPos()[1] + direccion[1] * i
                };
                // Comprobamos que la nueva posición está dentro del tablero
                if (nuevaPos[0] >= 0 && nuevaPos[0] < 8 && nuevaPos[1] >= 0 && nuevaPos[1] < 8) {
                    posiblesMovimientos.add(nuevaPos);
                } else {
                    break; // Sale del tablero, no hay más movimientos en esta dirección
                }
            }
        }
        return posiblesMovimientos;
    }
}