package com.app.Fichas;

import com.app.EquipoBridge.Equipo;

public class Torre extends Ficha{
    public Torre(Equipo Color,int fila, int columna){
        super(Color, "Torre", Color.getDirImg("Torre"), new int[]{fila,columna});
    }
}
