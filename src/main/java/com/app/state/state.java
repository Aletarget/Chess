package com.app.state;

import com.app.Fichas.Ficha;

public abstract class state {

    Ficha rey;

    state(Ficha rey){
        this.rey = rey;
    }

    public abstract String jaque(Ficha rey);
    public abstract String jaqueMate(Ficha rey); 
    
}
