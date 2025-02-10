package com.app.Movimientos;


import java.util.List;

import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public interface Movimientos {
    public Boolean movimiento(Ficha ficha, TableroJuego tablero , int fila, int columna);
    public List<int[]> movAtq(Ficha ficha, TableroJuego tablero, Integer[][] tableroDef);
    public List<int[]> movDef(Ficha ficha, TableroJuego tablero);

}
