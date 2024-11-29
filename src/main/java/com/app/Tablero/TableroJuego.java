package com.app.Tablero;

import com.app.Fichas.Ficha;

public class TableroJuego {
    private static TableroJuego instancia;
    private Ficha[][] tablero;
    private TableroJuego(){
        tablero = new Ficha[8][8]; 
        inicializarTablero(tablero);
    }


    //USO DE UNA INSTANCIA PARA IMPEDIR LA MULTIPLE CREACION DE TABLEROS (USO DE PATRON SINGLETON)
    public static TableroJuego getInstancia(){
        if (instancia == null) {
            instancia = new TableroJuego();
        }
        return instancia;
    }

    //CREACION DEL TABLERO CON SUS FICHAS CORRESPODIENTE PARA CADA EQUIPO, INICIALIZANDO EL JUEG
    private void inicializarTablero(Ficha[][] tablero){
        /*AQUI VA TODA LA LOGICA EN DONDE SE INICIALIZA EL TABLERO, ES DECIR AQUI SE INICIALIZAN LAS POSISCIONES Y TAMBIEN SE ELIGEN LAS
        IMAGENES DE LAS FICHAS*/
    }
    public Ficha[][] getTablero(){
        return tablero;
    }
}
