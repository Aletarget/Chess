package com.app.state;

import com.app.Fichas.Ficha;

public class stateNoAmenaza extends state {
    stateNoAmenaza(Ficha rey){
        super(rey);
    }

    @Override
    public void jaque(Ficha rey) {
        state = null;
    }

    @Override
    public void jaqueMate(Ficha rey) {
        state = null;
    }

    @Override
    public void sinAmenaza(Ficha rey) {
        state = "SinAmenaza";
    }
    
}
