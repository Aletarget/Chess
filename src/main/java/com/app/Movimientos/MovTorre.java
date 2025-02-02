package com.app.Movimientos;


import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public class MovTorre implements Movimientos{
    @Override
     public Boolean movimiento(Ficha ficha, TableroJuego tablero, int fila, int columna) {
        int[] currentPosTorre = ficha.getPos();
        int[] posObjetivo = new int[]{fila+1,columna+1}; 
        String equipo = ficha.getColor();
        String valEqContrario;
        int[][] direcciones = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1} // Movimiento horizontal y vertical
        };
        //Creamos un validador de equipo para validar si puede ir a una casilla que no esté vacia.
        if (equipo.equals("Blanco")) {
            valEqContrario = "Negro";
        }else{
            valEqContrario = "Blanco";
        }
        
        for (int[] direccion : direcciones) {
            int filaCurrent = currentPosTorre[0]-1;
            int columnaCurrent = currentPosTorre[1]-1;
            System.out.println(direccion[0]+" "+direccion[1]);
            while(true) {
                if (currentPosTorre[1] == posObjetivo[1]) {
                    filaCurrent += direccion[0];  
                }else if(currentPosTorre[0] == posObjetivo[0]){
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
                        tablero.getTablero()[currentPosTorre[0]-1][currentPosTorre[1]-1].cleanCasilla();
                        return true;
                    
                    }
                }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(valEqContrario)) {
                    if (filaCurrent == fila && columnaCurrent == columna) {
                        tablero.getTablero()[filaCurrent][columnaCurrent].fillCasilla(ficha, posObjetivo);
                        tablero.getTablero()[currentPosTorre[0]-1][currentPosTorre[1]-1].cleanCasilla();
                        return true;
                    }
                    break;
                }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(tablero.getTablero()[currentPosTorre[0]-1][currentPosTorre[1]-1].getCasilla().getColor())) {
                    break;
                }
                
            }
        }
        return false;
    }
    

}
