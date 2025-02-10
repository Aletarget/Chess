package com.app.state;

import com.app.Fichas.Ficha;

public class stateJaqueMate extends state{

    stateJaqueMate(Ficha rey){
        super(rey);
        jaqueMate();
    }

    @Override
    public String jaque() {
        return state = null;
    }

    @Override
    public String jaqueMate() {
        return state = "JaqueMate";
    }

    @Override
    public String sinAmenaza() {
        return state = null;        
    }

    
    
}
