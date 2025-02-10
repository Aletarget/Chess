package com.app.state;

import com.app.Fichas.Ficha;

public class stateNoAmenaza extends state {
    stateNoAmenaza(Ficha rey){
        super(rey);
        sinAmenaza();
    }

    @Override
    public String jaque() {
        return state = null;
    }

    @Override
    public String jaqueMate() {
        return state = null;
    }

    @Override
    public String sinAmenaza() {
        return state = "SinAmenaza";
    }
    
}
