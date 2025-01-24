package com.app.Controller;
import java.util.ArrayList;

import com.app.EquipoBridge.EquipoBlanco;
import com.app.Fichas.Alfil;
import com.app.Fichas.Caballo;
import com.app.Fichas.Ficha;
import com.app.Fichas.Peon;
import com.app.Fichas.Reina;
import com.app.Fichas.Rey;
import com.app.Fichas.Torre;
import com.app.Tablero.TableroJuego;

public class ControllerTablero {
    public TableroJuego tablero;
    public ArrayList<Ficha> piezasEquipo;
    public ArrayList<Ficha> piezasEquipoBlanco;
    public ArrayList<Ficha> piezasEquipoNegro;

    public ControllerTablero() {
        tablero = tablero.getInstancia();
        piezasEquipo = new ArrayList<>();
        piezasEquipoBlanco = new ArrayList<>();
        piezasEquipoNegro = new ArrayList<>();
    }

    public ArrayList<Ficha> fichasBlancas(EquipoBlanco equi_bl){
        for(int i = 1 ; i <= 8; i++ ){
            piezasEquipoBlanco.add(new Peon(equi_bl, 2, i));
        }
        piezasEquipoBlanco.add(new Torre(equi_bl, 1, 1)); 
        piezasEquipoBlanco.add(new Torre(equi_bl, 1, 8)); 
        piezasEquipoBlanco.add(new Caballo(equi_bl, 1, 2));
        piezasEquipoBlanco.add(new Caballo(equi_bl, 1, 7));
        piezasEquipoBlanco.add(new Alfil(equi_bl, 1, 3));
        piezasEquipoBlanco.add(new Alfil(equi_bl, 1, 6));
        piezasEquipoBlanco.add(new Reina(equi_bl, 1, 4));
        piezasEquipoBlanco.add(new Rey(equi_bl, 1, 5)); 

        return piezasEquipoBlanco;
    }

    public ArrayList<Ficha> fichasNegras(EquipoBlanco equi_ne){
        for(int i = 1 ; i <= 8; i++ ){
            piezasEquipoBlanco.add(new Peon(equi_ne, 7, i));
        }
        piezasEquipoNegro.add(new Torre(equi_ne, 8, 1)); 
        piezasEquipoNegro.add(new Torre(equi_ne, 8, 8)); 
        piezasEquipoNegro.add(new Caballo(equi_ne, 8, 2));
        piezasEquipoNegro.add(new Caballo(equi_ne, 8, 7));
        piezasEquipoNegro.add(new Alfil(equi_ne, 8, 3));
        piezasEquipoNegro.add(new Alfil(equi_ne, 8, 6));
        piezasEquipoNegro.add(new Reina(equi_ne, 8, 4));
        piezasEquipoNegro.add(new Rey(equi_ne, 8, 5)); 

        return piezasEquipoNegro;
    }

    public void seleccionEquipo(String equipo){
        
    }
    
    public void iniciarJuego(){
        // Verificar que el tablero no es nulo
        if (tablero != null) {
            System.out.println("El tablero ha sido inicializado correctamente.");
        } else {
            System.out.println("Error: El tablero no fue inicializado.");
        }

        // Configurar el equipo Blanco
        seleccionEquipo("Blanco");

        // Verificar que las piezas del equipo Blanco han sido agregadas
        if (piezasEquipo.isEmpty()) {
            System.out.println("Error: No se inicializaron las piezas del equipo Blanco.");
        } else {
            System.out.println("Piezas del equipo Blanco inicializadas:");
            for (Ficha ficha : piezasEquipo) {
                System.out.println(
                    ficha.getClass().getSimpleName() + 
                    " en posición (" + ficha.getPos()[0] + ", " + ficha.getPos()[1] + 
                    ") - Color: " + ficha.getColor()
                );
            }
        }

        // Limpiar la lista de piezas para el siguiente test
        piezasEquipo.clear();

        // Configurar el equipo Negro
        seleccionEquipo("Negro");

        // Verificar que las piezas del equipo Negro han sido agregadas
        if (piezasEquipo.isEmpty()) {
            System.out.println("Error: No se inicializaron las piezas del equipo Negro.");
        } else {
            System.out.println("Piezas del equipo Negro inicializadas:");
            for (Ficha ficha : piezasEquipo) {
                System.out.println(
                    ficha.getClass().getSimpleName() + 
                    " en posición (" + ficha.getPos()[0] + ", " + ficha.getPos()[1] + 
                    ") - Color: " + ficha.getColor()
                );
            }
        }
    }

}
