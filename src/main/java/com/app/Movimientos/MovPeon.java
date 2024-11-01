package com.app.Movimientos;

import com.app.Fichas.Peon;

public class MovPeon {
    public int[] avanzar(Peon peon){
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
    }

    /*public List<int[]> moverPeon(Peon peon) {
        List<int[]> posiblesMovimientos = new ArrayList<>();
        int direccion = peon.getColor().equals("Blanco") ? -1 : 1;

        // Movimiento de avance simple
        posiblesMovimientos.add(new int[]{peon.getPos()[0] + direccion, peon.getPos()[1]});

        // Movimiento de avance doble (solo si está en posición inicial)
        if ((peon.getColor().equals("Blanco") && peon.getPos()[0] == 6) || 
            (peon.getColor().equals("Negro") && peon.getPos()[0] == 1)) {
            posiblesMovimientos.add(new int[]{peon.getPos()[0] + 2 * direccion, peon.getPos()[1]});
        }

        // Captura en diagonal derecha
        posiblesMovimientos.add(new int[]{peon.getPos()[0] + direccion, peon.getPos()[1] + 1});

        // Captura en diagonal izquierda
        posiblesMovimientos.add(new int[]{peon.getPos()[0] + direccion, peon.getPos()[1] - 1});

        return posiblesMovimientos;
    }*/
}
