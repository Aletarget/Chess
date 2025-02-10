package com.app.state;

import java.util.ArrayList;
import java.util.List;

import com.app.Fichas.*;
import com.app.Movimientos.*;
import com.app.Tablero.TableroJuego;

public class amenazaIndv {
    private String state;
    public amenazaIndv(Ficha ficha, TableroJuego tablero, Ficha reyFicha){
        List<int[]> posAmenazadasTemp = new ArrayList<>();
            if (ficha instanceof Peon) {
                posAmenazadasTemp = new MovPeon().movDef(ficha, tablero);
            } else if (ficha instanceof Torre) {
                posAmenazadasTemp = new MovTorre().movDef(ficha, tablero);
            } else if (ficha instanceof Caballo) {
                posAmenazadasTemp = new MovCaballo().movDef(ficha, tablero);
            } else if (ficha instanceof Alfil) {
                posAmenazadasTemp = new MovAlfil().movDef(ficha, tablero);
            } else if (ficha instanceof Reina) {
                posAmenazadasTemp = new MovReina().movDef(ficha, tablero);
            } else if (ficha instanceof Rey) {
                posAmenazadasTemp = new MovRey().movDef(ficha, tablero);
            }
        validadorJaque(reyFicha, posAmenazadasTemp);
    }

    public void validadorJaque(Ficha rey, List<int[]> movimientos){
        for (int[] array : movimientos) {
            int[] reyPos = rey.getPos();
            if ((reyPos[0]-1) == array[0] && (reyPos[1]-1) == array[1]) {
                state = new stateJaque(rey).jaque();
            }
        }
        state = new stateNoAmenaza(rey).sinAmenaza();
    }
    public String getState() {
        return state;
    }
}
