package com.app.Tablero;

import com.app.Fichas.Ficha;

public class TableroJuego {
    private static TableroJuego instancia;
    private Ficha[][] tablero;
    private TableroJuego(){
        tablero = new Ficha[8][8];
    }


    //USO DE UNA INSTANCIA PARA IMPEDIR LA MULTIPLE CREACION DE TABLEROS (USO DE PATRON SINGLETON)
    public static TableroJuego getInstancia(){
        if (instancia == null) {
            instancia = new TableroJuego();
        }
        return instancia;
    }


    public Ficha[][] getTablero(){
        return tablero;
    }
}
