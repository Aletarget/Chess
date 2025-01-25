package com.app.Controller;
import java.util.ArrayList;

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
    public ArrayList<Ficha> piezasEquipoBlanco;
    public ArrayList<Ficha> piezasEquipoNegro;

    public ControllerTablero() {
        tablero = tablero.getInstancia();
        piezasEquipo = new ArrayList<>();
        piezasEquipoBlanco = new ArrayList<>();
        piezasEquipoNegro = new ArrayList<>();
    }

    public ArrayList<Ficha> fichasBlancas(){
        EquipoBlanco equi_bl = new EquipoBlanco();
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

    public ArrayList<Ficha> fichasNegras(){
        EquipoNegro equi_ne = new EquipoNegro();
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
        if(equipo.equals("Blanco")){
            fichasBlancas();
        }else if(equipo.equals("Negro")){
            fichasNegras();
        }
    }

    public void colocarFicha(int fila, int columna, Ficha ficha) {
        if (fila < 1 || fila > 8 || columna < 1 || columna > 8) {
            System.out.println("Posición inválida: (" + fila + ", " + columna + ")");
            return;
        }

        tablero.getTablero()[fila - 1][columna - 1] = ficha; // Restar 1 porque las matrices comienzan en 0
        System.out.println("Colocando " + ficha.getClass().getSimpleName() + " de color " + ficha.getColor() +
                           " en la posición (" + fila + ", " + columna + ")");
    }
    
    public void iniciarJuego(){
    
        // Inicializar las piezas de ambos equipos
        piezasEquipoBlanco = fichasBlancas();
        piezasEquipoNegro = fichasNegras();
    
        // Agregar las piezas blancas al tablero
    for (Ficha ficha : piezasEquipoBlanco) {
        colocarFicha(ficha.getPos()[0], ficha.getPos()[1], ficha);
    }

    // Agregar las piezas negras al tablero
    for (Ficha ficha : piezasEquipoNegro) {
        colocarFicha(ficha.getPos()[0], ficha.getPos()[1], ficha);
    }
    
        // Unir ambas listas en piezasEquipo
        piezasEquipo.clear();
        piezasEquipo.addAll(piezasEquipoBlanco);
        piezasEquipo.addAll(piezasEquipoNegro);
    
        // Configuración inicial adicional (si aplica)
        System.out.println("El juego ha iniciado. ¡Buena suerte!");
    
    
    }

}
