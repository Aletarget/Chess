package com.app.Movimientos;


import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public interface Movimientos {
    public Boolean movimiento(Ficha ficha, TableroJuego tablero , int fila, int columna);
}
