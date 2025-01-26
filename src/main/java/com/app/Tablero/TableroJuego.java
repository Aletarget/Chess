package com.app.Tablero;

import com.app.Controller.Casilla;

public class TableroJuego {
    private static TableroJuego instancia;
    private Casilla[][] tablero;
    private TableroJuego(){
        tablero = new Casilla[8][8];
    }


    //USO DE UNA INSTANCIA PARA IMPEDIR LA MULTIPLE CREACION DE TABLEROS (USO DE PATRON SINGLETON)
    public static TableroJuego getInstancia(){
        if (instancia == null) {
            instancia = new TableroJuego();
        }
        return instancia;
    }


    public Casilla[][] getTablero(){
        return tablero;
    }
}
