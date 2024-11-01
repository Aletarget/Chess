package com.app.Movimientos;

import java.util.ArrayList;
import java.util.List;

import com.app.Fichas.Caballo;

public class MovCaballo {

    public List<int[]> moverCaballo(Caballo caballo) {
    int[] currentPosCaballo = caballo.getPos();
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
