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
        Boolean bucle;
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
            bucle = true;
            while(bucle) {
                // Calcular la nueva posición
                if (currentPosTorre[0] == posObjetivo[0]) {
                    columnaCurrent += direccion[1];  
                    if (columnaCurrent > 7 || columnaCurrent < 0 || direccion[1] == 0) {
                        bucle = false;
                    }
                }else if (currentPosTorre[1] == posObjetivo[1]) {
                    filaCurrent += direccion[0];
                    if (filaCurrent > 7 || filaCurrent < 0 || direccion[0] == 0) {
                        bucle = false;
                    }
                }else {
                    bucle = false;
                }


                if (filaCurrent == fila && columnaCurrent == columna) { //Comprueba si el movimiento es posible
                    if (tablero.getTablero()[fila][columna].getCasilla() == null || tablero.getTablero()[fila][columna].getCasilla().getColor().equals(valEqContrario)) {
                        
                        tablero.getTablero()[posObjetivo[0]-1][posObjetivo[1]-1].fillCasilla(ficha, posObjetivo);
                        tablero.getTablero()[currentPosTorre[0]-1][currentPosTorre[1]-1].cleanCasilla();
                        
                        return true;
                    }

                }
                // Verificar si la nueva posición está dentro del tablero (límites 1-8)
                
            }
        }
        return false;
    }
    

}
