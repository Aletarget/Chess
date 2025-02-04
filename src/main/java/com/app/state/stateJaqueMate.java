package com.app.state;

import com.app.Fichas.Ficha;

public class stateJaqueMate extends state{

    stateJaqueMate(Ficha rey){
        super(rey);
    }

    @Override
    public String jaque(Ficha rey) {
        return null;
    }

    @Override
    public String jaqueMate(Ficha rey) {
        //Implementacion de logica para jaque mate
        return "JaqueMate";
    }
    
}
