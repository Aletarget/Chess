package com.app.Controller;

import com.app.Fichas.Ficha;

public interface Tablero {
    public Ficha getCasilla();
    public void fillCasilla(Ficha ficha);
    public void cleanCasilla();
}
