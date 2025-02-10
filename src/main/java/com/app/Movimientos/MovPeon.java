package com.app.Movimientos;


import java.util.ArrayList;
import java.util.List;

import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public class MovPeon implements Movimientos{
    @Override
    public Boolean movimiento(Ficha ficha, TableroJuego tablero, int fila, int columna) {
        int[] currentPosPeon = ficha.getPos();
        int[] posObjetivo = new int[]{fila+1,columna+1}; 
        String equipo = ficha.getColor();
        String valEqContrario;
        int[][] movimientosB = {
            {-1, 1}, {-1, -1}, {-1, 0}
        };
        int[][] movimientosN = {
            {1, 1}, {1, -1}, {1, 0},
        };
        //Creamos un validador de equipo para validar si puede ir a una casilla que no esté vacia.
        if (equipo.equals("Blanco")) {
            valEqContrario = "Negro";
        }else{
            valEqContrario = "Blanco";
        }
        
        // Caso especial en el que el peon puede avanzar dos casillas si es el primer movimiento de la ficha
        if (equipo.equals("Blanco")) {
            if (posObjetivo[0] == currentPosPeon[0]-2 && ficha.getPrimerMov() == false && posObjetivo[1] == currentPosPeon[1]
                //Condicion para que solo se pueda mover unicamente si las dos casillas de enfrente esten vacias
                && (tablero.getTablero()[currentPosPeon[0]-3][posObjetivo[1]-1].getCasilla() == null && tablero.getTablero()[currentPosPeon[0]-2][posObjetivo[1]-1].getCasilla() == null)) {
                
                tablero.getTablero()[currentPosPeon[0]-1][currentPosPeon[1]-1].getCasilla().cambiarPrimerMov();
                tablero.getTablero()[posObjetivo[0]-1][posObjetivo[1]-1].fillCasilla(ficha, posObjetivo);
                tablero.getTablero()[currentPosPeon[0]-1][currentPosPeon[1]-1].cleanCasilla();
                return true;
            }
        }else if (equipo.equals("Negro")) {
            if (posObjetivo[0] == currentPosPeon[0]+2 && ficha.getPrimerMov() == false && posObjetivo[1] == currentPosPeon[1]
                //Condicion para que solo se pueda mover unicamente si las dos casillas de enfrente esten vacias
                && (tablero.getTablero()[currentPosPeon[0]+1][posObjetivo[1]-1].getCasilla() == null && tablero.getTablero()[currentPosPeon[0]][posObjetivo[1]-1].getCasilla() == null)) {
                
                tablero.getTablero()[currentPosPeon[0]-1][currentPosPeon[1]-1].getCasilla().cambiarPrimerMov();
                tablero.getTablero()[posObjetivo[0]-1][posObjetivo[1]-1].fillCasilla(ficha, posObjetivo);
                tablero.getTablero()[currentPosPeon[0]-1][currentPosPeon[1]-1].cleanCasilla();
                return true;
            }
        }


        if (equipo.equals("Blanco")) {
            return validarMovimientos(movimientosB, ficha, tablero, fila, columna, valEqContrario);
        }else if (equipo.equals("Negro")) {
            return validarMovimientos(movimientosN, ficha, tablero, fila, columna, valEqContrario);
        }
        return false;
    }
    public Boolean validarMovimientos(int[][] movimientos, Ficha ficha, TableroJuego tablero, int fila, int columna, String valEqContrario){
        int[] currentPosPeon = ficha.getPos();
        int[] posObjetivo = new int[]{fila+1,columna+1}; 
        for (int[] movimiento : movimientos) {
            int filaCurrent = currentPosPeon[0];
            int columnaCurrent = currentPosPeon[1];
            
            filaCurrent += movimiento[0];
            columnaCurrent += movimiento[1];
            if (filaCurrent == posObjetivo[0] && columnaCurrent == posObjetivo[1]) {

                if (columnaCurrent != currentPosPeon[1]) {
                    if (tablero.getTablero()[filaCurrent-1][columnaCurrent-1].getCasilla()!= null && tablero.getTablero()[filaCurrent-1][columnaCurrent-1].getCasilla().getColor().equals(valEqContrario)) {
                        
                        tablero.getTablero()[currentPosPeon[0]-1][currentPosPeon[1]-1].getCasilla().cambiarPrimerMov();
                        tablero.getTablero()[filaCurrent-1][columnaCurrent-1].fillCasilla(ficha, posObjetivo);
                        tablero.getTablero()[currentPosPeon[0]-1][currentPosPeon[1]-1].cleanCasilla();
                        return true;
                    }
                }else if(columnaCurrent == currentPosPeon[1]){
                    if (tablero.getTablero()[filaCurrent-1][columnaCurrent-1].getCasilla() == null) {
                        tablero.getTablero()[currentPosPeon[0]-1][currentPosPeon[1]-1].getCasilla().cambiarPrimerMov();
                        tablero.getTablero()[filaCurrent-1][columnaCurrent-1].fillCasilla(ficha, posObjetivo);
                        tablero.getTablero()[currentPosPeon[0]-1][currentPosPeon[1]-1].cleanCasilla();
                        return true;
                    }
                }
            }
        }
        return false;   
    }
    @Override
    public List<int[]> movDef(Ficha ficha, TableroJuego tablero) {
        List<int[]> casAtq = new ArrayList<>();
        int[] currentPosPeon = ficha.getPos();
        String equipo = ficha.getColor();
        String valEqContrario = equipo.equals("Blanco") ? "Negro" : "Blanco";

        int[][] movimientosB = {
            {-1, 1}, {-1, -1}
        };
        int[][] movimientosN = {
            {1, 1}, {1, -1}
        };

        if (ficha.getColor().equals("Blanco")) {
            for(int[] movimientoB : movimientosB){
                int filaCurrent = currentPosPeon[0]-1;
                int columnaCurrent = currentPosPeon[1]-1;
        
                filaCurrent += movimientoB[0];  
                columnaCurrent += movimientoB[1];
                
                // Verificar si la nueva posición está dentro del tablero
                if ((columnaCurrent <= 7 && columnaCurrent >= 0) && (filaCurrent <= 7 && filaCurrent >= 0)){
                        // Validar si la casilla esta vacia o esta ocupada por una ficha enemiga, si es asi se agrega esa casilla a una posible a atacar
                    if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla() == null ) {
                        casAtq.add(new int[]{filaCurrent,columnaCurrent});
                    }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(valEqContrario)) {
                        casAtq.add(new int[]{filaCurrent,columnaCurrent});
                        //Rompe el ciclo para ir con otra movimientosB ya que una pieza aliada se atraviesa
                        break;
                    }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(tablero.getTablero()[currentPosPeon[0]-1][currentPosPeon[1]-1].getCasilla().getColor())) {
                        //
                        break;
                    }
                }
            
        
            }
        }else if(ficha.getColor().equals("Negro")){
            for(int[] movimientoN : movimientosN){
                int filaCurrent = currentPosPeon[0]-1;
                int columnaCurrent = currentPosPeon[1]-1;
                   
                filaCurrent += movimientoN[0];  
                columnaCurrent += movimientoN[1];
        
                // Verificar si la nueva posición está dentro del tablero
                if ((columnaCurrent <= 7 && columnaCurrent >= 0) && (filaCurrent <= 7 && filaCurrent >= 0)) {
                    
                    // Validar si la casilla esta vacia o esta ocupada por una ficha enemiga, si es asi se agrega esa casilla a una posible a atacar
                    if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla() == null ) {
                        casAtq.add(new int[]{filaCurrent,columnaCurrent});
                        
                    }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(valEqContrario)) {
                        casAtq.add(new int[]{filaCurrent,columnaCurrent});
                        
                        //Rompe el ciclo para ir con otra movimientosB ya que una pieza aliada se atraviesa
                        break;
                    }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(tablero.getTablero()[currentPosPeon[0]-1][currentPosPeon[1]-1].getCasilla().getColor())) {
                        //
                        break;
                    }
                }
            
            }
        }

        return casAtq;
    }
    @Override
    public List<int[]> movAtq(Ficha ficha, TableroJuego tablero, Integer[][] tableroDef) {
        List<int[]> casAtq = new ArrayList<>();
        int[] currentPosPeon = ficha.getPos();
        String equipo = ficha.getColor();
        String valEqContrario = equipo.equals("Blanco") ? "Negro" : "Blanco";

        int[][] movimientosB = {
            {-1, 1}, {-1, -1}
        };
        int[][] movimientosN = {
            {1, 1}, {1, -1}
        };

        if (ficha.getColor().equals("Blanco")) {
            for(int[] movimientoB : movimientosB){
                int filaCurrent = currentPosPeon[0]-1;
                int columnaCurrent = currentPosPeon[1]-1;
        
                filaCurrent += movimientoB[0];  
                columnaCurrent += movimientoB[1];
                
                // Verificar si la nueva posición está dentro del tablero
                if ((columnaCurrent <= 7 && columnaCurrent >= 0) && (filaCurrent <= 7 && filaCurrent >= 0)){
                    if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla() == null && tableroDef[filaCurrent][columnaCurrent].equals(1)) {
                        casAtq.add(new int[]{filaCurrent,columnaCurrent});
                    }else if(tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla() == null){
                        casAtq.add(new int[]{filaCurrent,columnaCurrent});
                    
                    }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(valEqContrario) || tableroDef[filaCurrent][columnaCurrent].equals(1)) {
                        casAtq.add(new int[]{filaCurrent,columnaCurrent});
                        //Rompe el ciclo para ir con otra direccion ya que una pieza aliada se atraviesa
                        break;
                    }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(tablero.getTablero()[currentPosPeon[0]-1][currentPosPeon[1]-1].getCasilla().getColor())) {
                        //
                        break;
                    }
                }
            
        
            }
        }else if(ficha.getColor().equals("Negro")){
            for(int[] movimientoN : movimientosN){
                int filaCurrent = currentPosPeon[0]-1;
                int columnaCurrent = currentPosPeon[1]-1;
                   
                filaCurrent += movimientoN[0];  
                columnaCurrent += movimientoN[1];
        
                // Verificar si la nueva posición está dentro del tablero
                if ((columnaCurrent <= 7 && columnaCurrent >= 0) && (filaCurrent <= 7 && filaCurrent >= 0)) {
                    
                    // Validar si la casilla esta vacia o esta ocupada por una ficha enemiga, si es asi se agrega esa casilla a una posible a atacar
                    if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla() == null && tableroDef[filaCurrent][columnaCurrent].equals(1)) {
                        casAtq.add(new int[]{filaCurrent,columnaCurrent});
                    }else if(tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla() == null){
                        casAtq.add(new int[]{filaCurrent,columnaCurrent});
                    
                    }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(valEqContrario) || tableroDef[filaCurrent][columnaCurrent].equals(1)) {
                        casAtq.add(new int[]{filaCurrent,columnaCurrent});
                        //Rompe el ciclo para ir con otra direccion ya que una pieza aliada se atraviesa
                        break;
                    }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(tablero.getTablero()[currentPosPeon[0]-1][currentPosPeon[1]-1].getCasilla().getColor())) {
                        //
                        break;
                    }
                }
            
            }
        }

        return casAtq;
    }
    
    
}




