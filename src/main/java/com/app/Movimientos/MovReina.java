package com.app.Movimientos;

import java.util.ArrayList;
import java.util.List;

import com.app.Fichas.Reina;

public class MovReina {
    public List<int[]> moverReina(Reina reina, int n) {
    int[] currentPosReina = reina.getPos();
    List<int[]> posiblesMovimientos = new ArrayList<>();
    
    // Direcciones posibles (vertical, horizontal y diagonal)
    int[][] direcciones = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}, // Movimientos verticales y horizontales
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // Movimientos diagonales
    };
    
    // Generar todas las posiciones posibles en cada dirección
    for (int[] direccion : direcciones) {
        for (int i = 1; i <= n; i++) { // Moverse hasta n pasos en la misma dirección
            int[] nuevaPos = {
                currentPosReina[0] + direccion[0] * i,
                currentPosReina[1] + direccion[1] * i
            };
            posiblesMovimientos.add(nuevaPos);
        }
    }
    
    return posiblesMovimientos;
}

}
