package com.app.Movimientos;

import java.util.ArrayList;
import java.util.List;

import com.app.Fichas.Ficha;

public class MovCaballo implements Movimientos{
    
    @Override
    public List<int[]> movimiento(Ficha ficha) {
        int[] currentPosCaballo = ficha.getPos();
        List<int[]> posiblesMovimientos = new ArrayList<>();
        
        // Lista de posibles movimientos
        int[][] movimientos = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };
        
        // Generar todas las posiciones posibles basadas en los movimientos
        for (int[] movimiento : movimientos) {
            int[] nuevaPos = {
                currentPosCaballo[0] + movimiento[0],
                currentPosCaballo[1] + movimiento[1]
            };
            posiblesMovimientos.add(nuevaPos);
        }
        
        return posiblesMovimientos;
    }

}
