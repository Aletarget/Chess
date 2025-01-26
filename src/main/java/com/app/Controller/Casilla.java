package com.app.Controller;

import com.app.Fichas.Ficha;

public class Casilla implements Tablero {
    private Ficha ficha;

    public Casilla(Ficha ficha){
        this.ficha = ficha;
    }

    @Override
    public Ficha getCasilla() {
        return ficha;
    }
    @Override
    public void fillCasilla(Ficha ficha) {
        this.ficha = ficha;
    }
    @Override
    public void cleanCasilla() {
        this.ficha = null;
    }
    
}
