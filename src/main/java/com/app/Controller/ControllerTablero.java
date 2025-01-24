package com.app.Controller;
import java.util.ArrayList;

import com.app.EquipoBridge.Equipo;
import com.app.EquipoBridge.EquipoBlanco;
import com.app.EquipoBridge.EquipoNegro;
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

    public ControllerTablero() {
        tablero = tablero.getInstancia();
        piezasEquipo = new ArrayList<>();
    }

    public void equipo(Equipo Color, int fila, int columna, String pieza){
        
        // Agregar piezas al equipo según el color
        for (int i = 0; i < columna; i++) {
            piezasEquipo.add(new Peon(Color, fila, columna)); // Agregar 8 peones
        }
        if (pieza.equals("Torre")) {
            piezasEquipo.add(new Torre(Color, fila, columna)); 
        }else if(pieza.equals("Caballo")){
            piezasEquipo.add(new Caballo(Color, fila, columna));
        }
        else if(pieza.equals("Alfil")){
            piezasEquipo.add(new Alfil(Color, fila, columna));  
        }
        else if(pieza.equals("Reina")){
            piezasEquipo.add(new Reina(Color, fila, columna)); // Agregar 1 dama
        }
        else if(pieza.equals("Rey")){
            piezasEquipo.add(new Rey(Color, fila, columna)); // Agregar 1 rey
        }

    }

    public void seleccionEquipo(String equipo){
        if (equipo.equals("Blanco")){
            EquipoBlanco eq_blanco = new EquipoBlanco();
            
            equipo(eq_blanco, 2, 8, "Peon");
            for(int i = 1; i == 8 ; i++){
                equipo(eq_blanco, 1, i, "Torre");    
            }
            for(int i = 2; i == 7 ; i++){
                equipo(eq_blanco, 1, i, "Caballo");    
            }
            for(int i = 3; i == 6 ; i++){
                equipo(eq_blanco, 1, i, "Alfil");    
            }
            equipo(eq_blanco, 1, 5, "Reina");
            equipo(eq_blanco, 1, 4, "Rey");
        }else if (equipo.equals("Negro")){
            EquipoNegro eq_negro = new EquipoNegro();

            equipo(eq_negro, 7, 8, "Peon");
            for(int i = 1; i == 8 ; i++){
                equipo(eq_negro, 8, i, "Torre");    
            }
            for(int i = 2; i == 7 ; i++){
                equipo(eq_negro, 8, i, "Caballo");    
            }
            for(int i = 3; i == 6 ; i++){
                equipo(eq_negro, 8, i, "Alfil");    
            }
            equipo(eq_negro, 8, 5, "Reina");
            equipo(eq_negro, 8, 4, "Rey");
        }
    }           

}
