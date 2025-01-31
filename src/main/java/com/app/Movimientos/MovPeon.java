package com.app.Movimientos;


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
            validarMovimientos(movimientosB, ficha, tablero, fila, columna, valEqContrario);
        }else if (equipo.equals("Negro")) {
            validarMovimientos(movimientosN, ficha, tablero, fila, columna, valEqContrario);
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
}




