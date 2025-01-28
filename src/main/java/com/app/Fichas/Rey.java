package com.app.Fichas;

import com.app.EquipoBridge.Equipo;

public class Rey extends Ficha{
    public Rey(Equipo Color,int fila, int columna){
        super(Color, "Rey", Color.getDirImg("Rey"), new int[]{fila,columna});
    }
}
