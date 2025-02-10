package com.app.state;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.app.Fichas.Alfil;
import com.app.Fichas.Caballo;
import com.app.Fichas.Ficha;
import com.app.Fichas.Peon;
import com.app.Fichas.Reina;
import com.app.Fichas.Rey;
import com.app.Fichas.Torre;
import com.app.Movimientos.MovAlfil;
import com.app.Movimientos.MovCaballo;
import com.app.Movimientos.MovPeon;
import com.app.Movimientos.MovReina;
import com.app.Movimientos.MovRey;
import com.app.Movimientos.MovTorre;
import com.app.Tablero.TableroJuego;

public class checkOrChackemate {
    private TableroJuego instanciaTablero;
    private Integer[][] tableroValidador = new Integer[8][8];
    private Integer[][] tableroEqCont = new Integer[8][8];
    private String[] filas = {"a","b","c","d","e","f","g","h"};
    private HashMap<Integer, String> casillas = new HashMap<>();
    public checkOrChackemate(TableroJuego tablero, String turno, Ficha fichaMovida){
        Integer i = 1;
        for(String fila : filas){
            casillas.put(i, fila);
            i++;
        }
        instanciaTablero = tablero;
        System.out.println(casillas);
        logicCM(turno, tablero, fichaMovida);
    }
    private void logicCM(String Turno, TableroJuego tableroJuego, Ficha fichaMovida){
        Ficha reyEnemigo;
        String estadoSimple;
        String valeqContrario = Turno.equals("Blanco") ? "Negro" : "Blanco";
        HashMap<List<Integer>, Integer> posAmenazadas = new HashMap<>();
        arrayEqCont(valeqContrario);
            for(int i = 0 ; i<8 ; i++){
                for(int j = 0 ; j<8 ; j++){
                    List<int[]> posAmenazadasTemp = new ArrayList<>();
                    Ficha fichaElegida = instanciaTablero.getTablero()[j][i].getCasilla();
                    if (fichaElegida != null && fichaElegida.getColor().equals(Turno) ) {
                        if (fichaElegida instanceof Peon) {
                            posAmenazadasTemp = new MovPeon().movAtq(fichaElegida, instanciaTablero, tableroEqCont);
                        } else if (fichaElegida instanceof Torre) {
                            posAmenazadasTemp = new MovTorre().movAtq(fichaElegida, instanciaTablero, tableroEqCont);
                        } else if (fichaElegida instanceof Caballo) {
                            posAmenazadasTemp = new MovCaballo().movAtq(fichaElegida, instanciaTablero, tableroEqCont);
                        } else if (fichaElegida instanceof Alfil) {
                            posAmenazadasTemp = new MovAlfil().movAtq(fichaElegida, instanciaTablero, tableroEqCont);
                        } else if (fichaElegida instanceof Reina) {
                            posAmenazadasTemp = new MovReina().movAtq(fichaElegida, instanciaTablero, tableroEqCont);
                        } else if (fichaElegida instanceof Rey) {
                            posAmenazadasTemp = new MovRey().movAtq(fichaElegida, instanciaTablero, tableroEqCont);
                        }
                    }for(int[] array : posAmenazadasTemp){
                        posAmenazadas.put(Arrays.asList(array[0],array[1]), -1);
                    }
                    if (fichaElegida instanceof Rey) {
                        reyEnemigo = fichaElegida;
                        estadoSimple = new amenazaIndv(fichaMovida, tableroJuego, reyEnemigo).getState();
                    }
                }
            }
            for (int i = 0 ; i < 8 ; i++) {
                for(int j = 0; j < 8; j++){
                    if (posAmenazadas.containsKey(Arrays.asList(i,j))) {
                        tableroValidador[i][j] = posAmenazadas.get(Arrays.asList(i,j));
                    }else{
                        tableroValidador[i][j] = 0;
                    }
                    System.out.print(tableroValidador[i][j]);
                }
                System.out.println();
            }
    }

    private Integer[][] arrayEqCont(String turnoContrario){
        HashMap<List<Integer>, Integer> posAmenazadas = new HashMap<>();
        for(int i = 0 ; i<8 ; i++){
            for(int j = 0 ; j<8 ; j++){
                List<int[]> posAmenazadasTemp = new ArrayList<>();
                Ficha fichaElegida = instanciaTablero.getTablero()[j][i].getCasilla();
                if (fichaElegida != null && fichaElegida.getColor().equals(turnoContrario)) {
                    if (fichaElegida instanceof Peon) {
                        posAmenazadasTemp = new MovPeon().movDef(fichaElegida, instanciaTablero);
                    } else if (fichaElegida instanceof Torre) {
                        posAmenazadasTemp = new MovTorre().movDef(fichaElegida, instanciaTablero);
                    } else if (fichaElegida instanceof Caballo) {
                        posAmenazadasTemp = new MovCaballo().movDef(fichaElegida, instanciaTablero);
                    } else if (fichaElegida instanceof Alfil) {
                        posAmenazadasTemp = new MovAlfil().movDef(fichaElegida, instanciaTablero);
                    } else if (fichaElegida instanceof Reina) {
                        posAmenazadasTemp = new MovReina().movDef(fichaElegida, instanciaTablero);
                    } else if (fichaElegida instanceof Rey) {
                        posAmenazadasTemp = new MovRey().movDef(fichaElegida, instanciaTablero);
                    }
                    for(int[] array : posAmenazadasTemp){
                        posAmenazadas.put(Arrays.asList(array[0],array[1]), 1);
                    }
                }
            }
        }
        for (int i = 0 ; i < 8 ; i++) {
            for(int j = 0; j < 8; j++){
                if (posAmenazadas.containsKey(Arrays.asList(i,j))) {
                    tableroEqCont[i][j] = posAmenazadas.get(Arrays.asList(i,j));
                }else{
                    tableroEqCont[i][j] = 0;
                }
            }
        }
        
        return tableroEqCont;
    }
}
