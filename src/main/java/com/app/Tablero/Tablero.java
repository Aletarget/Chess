package com.app.Tablero;

import com.app.Fichas.Ficha;

public class Tablero {
    private static Tablero instancia;
    private Ficha[][] tablero;
    private Tablero(){
        tablero = new Ficha[8][8]; 
        inicializarTablero(tablero);
    }


    //USO DE UNA INSTANCIA PARA IMPEDIR LA MULTIPLE CREACION DE TABLEROS (USO DE PATRON SINGLETON)
    public static Tablero getInstancia(){
        if (instancia == null) {
            instancia = new Tablero();
        }
        return instancia;
    }

    //CREACION DEL TABLERO CON SUS FICHAS CORRESPODIENTE PARA CADA EQUIPO, INICIALIZANDO EL JUEG
    private void inicializarTablero(Ficha[][] tablero){
    }

}
