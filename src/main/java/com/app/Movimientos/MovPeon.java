package com.app.Movimientos;

import java.util.ArrayList;
import java.util.List;

import com.app.Fichas.Ficha;

public class MovPeon implements Movimientos{
    /*public int[] avanzar(Ficha ficha){
        int[] currentPostPeon = peon.getPos();
        if (peon.getColor().equals("Blanco")) {
            currentPostPeon[0] -= 1;
            
        }else{
            currentPostPeon[0] += 1;
        }
        return currentPostPeon;
    } 
    public int[] avanzarDoble(Peon peon){
        int[] currentPostPeon = peon.getPos();
        if (peon.getColor().equals("Blanco")) {
            currentPostPeon[0] -= 2;
            
        }else{
            currentPostPeon[0] += 2;
        }
        return currentPostPeon;
    }

    public int[] matarDer(Peon peon){
        int[] currentPostPeon = peon.getPos();
        if (peon.getColor().equals("Blanco")) {
            currentPostPeon[0] -= 1;
            currentPostPeon[1] +=1;
            
        }else{
            currentPostPeon[0] += 1;
            currentPostPeon[1] += 1;            
        }
        return currentPostPeon;
    } 
    
    public int[] matarIzq(Peon peon){
        int[] currentPostPeon = peon.getPos();
        if (peon.getColor().equals("Blanco")) {
            currentPostPeon[0] -= 1;
            currentPostPeon[1] -=1;
            
        }else{
            currentPostPeon[0] += 1;
            currentPostPeon[1] -= 1;            
        }
        return currentPostPeon;
    }*/
    @Override
    public List<int[]> movimiento(Ficha ficha) {
        List<int[]> posiblesMovimientos = new ArrayList<>();
        int direccion = ficha.getColor().equals("Blanco") ? -1 : 1;

        // Movimiento de avance simple
        posiblesMovimientos.add(new int[]{ficha.getPos()[0] + direccion, ficha.getPos()[1]});

        // Movimiento de avance doble (solo si está en posición inicial)
        if ((ficha.getColor().equals("Blanco") && ficha.getPos()[0] == 6) || 
            (ficha.getColor().equals("Negro") && ficha.getPos()[0] == 1)) {
            posiblesMovimientos.add(new int[]{ficha.getPos()[0] + 2 * direccion, ficha.getPos()[1]});
        }

        // Captura en diagonal derecha
        posiblesMovimientos.add(new int[]{ficha.getPos()[0] + direccion, ficha.getPos()[1] + 1});

        // Captura en diagonal izquierda
        posiblesMovimientos.add(new int[]{ficha.getPos()[0] + direccion, ficha.getPos()[1] - 1});

        return posiblesMovimientos;
    }
}
