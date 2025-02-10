package com.app.state;

import com.app.Fichas.Ficha;

public class stateJaque extends state{

    public stateJaque(Ficha rey){
        super(rey);
        jaque();
    }
    @Override
    public String jaque() {
        return state = "Jaque";
    }

    @Override
    public String jaqueMate() {
        return state = null;
    }
    @Override
    public String sinAmenaza() {
        return state = null;
    }
    
}
