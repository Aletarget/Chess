package com.app.state;

import com.app.Fichas.Ficha;

public abstract class state {

    Ficha rey;
    String state;

    state(Ficha rey){
        this.rey = rey;
    }

    public abstract String jaque();
    public abstract String jaqueMate();
    public abstract String sinAmenaza(); 
    public String getState(){
        return state;
    }
    
}
