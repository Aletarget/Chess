package com.app.state;

import com.app.Fichas.Ficha;

public class stateJaque extends state{

    public stateJaque(Ficha rey){
        super(rey);
    }
    @Override
    public void jaque(Ficha rey) {
        state = "Jaque";
    }

    @Override
    public void jaqueMate(Ficha rey) {
        state = null;
    }
    @Override
    public void sinAmenaza(Ficha rey) {
        state = null;
    }
    
}
