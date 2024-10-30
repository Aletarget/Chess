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
}
