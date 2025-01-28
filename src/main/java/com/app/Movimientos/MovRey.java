package com.app.Movimientos;

import java.util.ArrayList;
import java.util.List;

import com.app.Fichas.Ficha;

public class MovRey implements Movimientos{
    @Override
    public List<int[]> movimiento(Ficha ficha) {
        List<int[]> posiblesMovimientos = new ArrayList<>();
        int[][] direcciones = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };
        
        for (int[] direccion : direcciones) {
            int[] nuevaPos = {
                ficha.getPos()[0] + direccion[0],
                ficha.getPos()[1] + direccion[1]
            };
            // Verificar que la nueva posición esté dentro de los límites del tablero
            if (nuevaPos[0] >= 0 && nuevaPos[0] < 8 && nuevaPos[1] >= 0 && nuevaPos[1] < 8) {
                posiblesMovimientos.add(nuevaPos);
            }
        }
        return posiblesMovimientos;
    }
}
