package com.app.Movimientos;


import java.util.ArrayList;
import java.util.List;

import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public class MovRey implements Movimientos{
    @Override
    public Boolean movimiento(Ficha ficha, TableroJuego tablero, int fila, int columna) {
        int[] currentPosRey = ficha.getPos();
        int[] posObjetivo = new int[]{fila+1,columna+1};
        String equipo = ficha.getColor();
        String valEqContrario = equipo.equals("Blanco") ? "Negro" : "Blanco";
        int[][] direcciones = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };
        
        for (int[] direccion : direcciones) {
            int filaCurrent = currentPosRey[0];
                int columnaCurrent = currentPosRey[1];
                
                filaCurrent += direccion[0];
                columnaCurrent += direccion[1];

                if (filaCurrent == posObjetivo[0] && columnaCurrent == posObjetivo[1]) { //Comprueba si el movimiento es posible
                    if (tablero.getTablero()[fila][columna].getCasilla() == null || 
                        tablero.getTablero()[fila][columna].getCasilla().getColor().equals(valEqContrario)) {
                            
                        tablero.getTablero()[filaCurrent-1][columnaCurrent-1].fillCasilla(ficha, posObjetivo);
                        tablero.getTablero()[currentPosRey[0]-1][currentPosRey[1]-1].cleanCasilla();
                        return true;
                    }
                }
        }
        return true;
    }

   @Override
    public List<int[]> movDef(Ficha ficha, TableroJuego tablero) {
        List<int[]> casAtq = new ArrayList<>();
        int[] currentPosTorre = ficha.getPos();
        String equipo = ficha.getColor();
        String valEqContrario = equipo.equals("Blanco") ? "Negro" : "Blanco";

        int[][] direcciones = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };
        for(int[] direccion : direcciones){
            int filaCurrent = currentPosTorre[0]-1;
            int columnaCurrent = currentPosTorre[1]-1;
            // Avanzar en la dirección mientras no se salga del tablero\
        
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
                }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(tablero.getTablero()[currentPosTorre[0]-1][currentPosTorre[1]-1].getCasilla().getColor())) {
                    //
                    break;
                }
            }
        
        }
        return casAtq;
    }

@Override
public List<int[]> movAtq(Ficha ficha, TableroJuego tablero, Integer[][] tableroDef) {
    List<int[]> casAtq = new ArrayList<>();
        int[] currentPosTorre = ficha.getPos();
        String equipo = ficha.getColor();
        String valEqContrario = equipo.equals("Blanco") ? "Negro" : "Blanco";

        int[][] direcciones = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };
        for(int[] direccion : direcciones){
            int filaCurrent = currentPosTorre[0]-1;
            int columnaCurrent = currentPosTorre[1]-1;
            // Avanzar en la dirección mientras no se salga del tablero\
        
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
                }else if (tablero.getTablero()[filaCurrent][columnaCurrent].getCasilla().getColor().equals(tablero.getTablero()[currentPosTorre[0]-1][currentPosTorre[1]-1].getCasilla().getColor())) {
                    //
                    break;
                }
            }
        
        }
        return casAtq;
}
    
}
