package com.app.Movimientos;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<int[]> movDef(Ficha ficha, TableroJuego tablero) {
        List<int[]> casAtq = new ArrayList<>();
        int[] currentPosReina = ficha.getPos();
        String equipo = ficha.getColor();
        String valEqContrario = equipo.equals("Blanco") ? "Negro" : "Blanco";

        int[][] direcciones = {
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1},{1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        for(int[] direccion : direcciones){
            int filaCurrent = currentPosReina[0]-1;
            int columnaCurrent = currentPosReina[1]-1;
            // Avanzar en la dirección mientras no se salga del tablero\
                while (true) { // Permitir que el alfil siga moviéndose hasta chocar con algo
                    filaCurrent += direccion[0];  
                    columnaCurrent += direccion[1];
            
                    // Verificar si la nueva posición está dentro del tablero
                    if ((columnaCurrent <= 7 && columnaCurrent >= 0) && (filaCurrent <= 7 && filaCurrent >= 0)) {
                        // Validar si la casilla esta vacia o esta ocupada por una ficha enemiga, si es asi se agrega esa casilla a una posible a atacar
                        if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla() == null ) {
                            casAtq.add(new int[]{filaCurrent,columnaCurrent});
                        }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(valEqContrario)) {
                            casAtq.add(new int[]{filaCurrent,columnaCurrent});
                            //Rompe el ciclo para ir con otra movimientosB ya que una pieza aliada se atraviesa
                            break;
                        }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(tablero.getTablero()[currentPosReina[0]-1][currentPosReina[1]-1].getCasilla().getColor())) {
                            //
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
        return casAtq;
    }

    @Override
    public List<int[]> movAtq(Ficha ficha, TableroJuego tablero, Integer[][] tableroDef) {
        List<int[]> casAtq = new ArrayList<>();
        int[] currentPosReina = ficha.getPos();
        String equipo = ficha.getColor();
        String valEqContrario = equipo.equals("Blanco") ? "Negro" : "Blanco";

        int[][] direcciones = {
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1},{1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        for(int[] direccion : direcciones){
            int filaCurrent = currentPosReina[0]-1;
            int columnaCurrent = currentPosReina[1]-1;
            // Avanzar en la dirección mientras no se salga del tablero\
                while (true) { // Permitir que el alfil siga moviéndose hasta chocar con algo
                    filaCurrent += direccion[0];  
                    columnaCurrent += direccion[1];
            
                    // Verificar si la nueva posición está dentro del tablero
                    if ((columnaCurrent <= 7 && columnaCurrent >= 0) && (filaCurrent <= 7 && filaCurrent >= 0)) {
                        if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla() == null && tableroDef[filaCurrent][columnaCurrent].equals(1)) {
                            casAtq.add(new int[]{filaCurrent,columnaCurrent});
                        }else if(tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla() == null){
                            casAtq.add(new int[]{filaCurrent,columnaCurrent});
                        
                        }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(valEqContrario) || tableroDef[filaCurrent][columnaCurrent].equals(1)) {
                            casAtq.add(new int[]{filaCurrent,columnaCurrent});
                            //Rompe el ciclo para ir con otra direccion ya que una pieza aliada se atraviesa
                            break;
                        }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(tablero.getTablero()[currentPosReina[0]-1][currentPosReina[1]-1].getCasilla().getColor())) {
                            //
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
        return casAtq;
    }

    
    

}
