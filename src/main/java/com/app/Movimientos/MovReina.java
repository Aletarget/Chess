package com.app.Movimientos;

import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public class MovReina implements Movimientos{

    @Override
    public Boolean movimiento(Ficha ficha, TableroJuego tablero, int fila, int columna) {
        int[] currentPosReina = ficha.getPos();
        int[] posObjetivo = new int[]{fila+1,columna+1};
        String equipo = ficha.getColor();
        String valEqContrario;
        //Creamos un validador de equipo para validar si puede ir a una casilla que no esté vacia.
        if (equipo.equals("Blanco")) {
            valEqContrario = "Negro";
        }else{
            valEqContrario = "Blanco";
        }
        
        // Direcciones posibles (vertical, horizontal y diagonal)
        int[][] direccionesVH = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1} // Movimientos verticales y horizontales
        };
        int[][] direccionesDI = {
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // Movimientos En diagonal
        };
        if (currentPosReina[0] != posObjetivo[0] && currentPosReina[1] != posObjetivo[1]) {
            for (int[] direccion : direccionesDI) {
                int filaCurrent = currentPosReina[0]-1;
                int columnaCurrent = currentPosReina[1]-1;
                // Avanzar en la dirección mientras no se salga del tablero\
                while (true) { // Permitir que el alfil siga moviéndose hasta chocar con algo
                    filaCurrent += direccion[0];  
                    columnaCurrent += direccion[1];
            
                    // Verificar si la nueva posición está dentro del tablero
                    if (columnaCurrent > 7 || columnaCurrent < 0 || filaCurrent > 7 || filaCurrent < 0) {
                        break; // Salir del bucle si se sale del tablero
                    }
                    //Comprueba si el camino hasta el destino esta libre de fichas, si por alguna razon hay una ficha que no deja pasar al alfil
                    //sea blanca o negra, se quedara quieta ya que el movimiento debe ser el que el usuario desea mas no el que podria llegar a realizar
                    if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla() == null ) {
                        if (filaCurrent == fila && columnaCurrent == columna) {
                            tablero.getTablero()[filaCurrent][columnaCurrent].fillCasilla(ficha, posObjetivo);
                            tablero.getTablero()[currentPosReina[0]-1][currentPosReina[1]-1].cleanCasilla();
                            return true;
                        
                        }
                    }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(valEqContrario)) {
                        if (filaCurrent == fila && columnaCurrent == columna) {
                            tablero.getTablero()[filaCurrent][columnaCurrent].fillCasilla(ficha, posObjetivo);
                            tablero.getTablero()[currentPosReina[0]-1][currentPosReina[1]-1].cleanCasilla();
                            return true;
                        }
                        break;
                    }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(tablero.getTablero()[currentPosReina[0]-1][currentPosReina[1]-1].getCasilla().getColor())) {
                        break;
                    }
                }
            }
        }else if(currentPosReina[0] == posObjetivo[0] || currentPosReina[1] == posObjetivo[1]){
            for (int[] direccion : direccionesVH) {
                int filaCurrent = currentPosReina[0]-1;
                int columnaCurrent = currentPosReina[1]-1;
                System.out.println(direccion[0]+" "+direccion[1]);
                while(true) {
                    if (currentPosReina[1] == posObjetivo[1]) {
                        filaCurrent += direccion[0];  
                    }else if(currentPosReina[0] == posObjetivo[0]){
                        columnaCurrent += direccion[1];
                    }
            
                    // Verificar si la nueva posición está dentro del tablero
                    if (columnaCurrent > 7 || columnaCurrent < 0 || filaCurrent > 7 || filaCurrent < 0) {
                        break; // Salir del bucle si se sale del tablero
                    }
    
                    System.out.println("Fila: "+ filaCurrent+" Columna: "+ columnaCurrent);
                    if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla() == null ) {
                        if (filaCurrent == fila && columnaCurrent == columna) {
                           
                            tablero.getTablero()[filaCurrent][columnaCurrent].fillCasilla(ficha, posObjetivo);
                            tablero.getTablero()[currentPosReina[0]-1][currentPosReina[1]-1].cleanCasilla();
                            return true;
                        
                        }
                    }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(valEqContrario)) {
                        if (filaCurrent == fila && columnaCurrent == columna) {
                            tablero.getTablero()[filaCurrent][columnaCurrent].fillCasilla(ficha, posObjetivo);
                            tablero.getTablero()[currentPosReina[0]-1][currentPosReina[1]-1].cleanCasilla();
                            return true;
                        }
                        break;
                    }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(tablero.getTablero()[currentPosReina[0]-1][currentPosReina[1]-1].getCasilla().getColor())) {
                        break;
                    }
                    
                }
            }
        }
        return false;
    }

}
