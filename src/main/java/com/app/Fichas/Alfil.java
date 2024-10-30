package com.app.Fichas;

import com.app.EquipoBridge.Equipo;

public class Alfil extends Ficha{
    public Alfil(Equipo Color,int fila, int columna){
        super(Color, "Alfil", "", new int[]{fila,columna});
    }
}
