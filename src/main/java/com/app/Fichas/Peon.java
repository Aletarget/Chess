package com.app.Fichas;

import com.app.EquipoBridge.Equipo;

public class Peon extends Ficha{
    public Peon(Equipo Color, int fila, int columna){
        super(Color, "Peon", "", new int[]{fila,columna});
    }
    
}