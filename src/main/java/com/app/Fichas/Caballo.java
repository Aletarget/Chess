package com.app.Fichas;

import com.app.EquipoBridge.Equipo;

public class Caballo extends Ficha{
    public Caballo(Equipo Color,int fila, int columna){
        super(Color, "Caballo", "", new int[]{fila,columna});
    }
}
