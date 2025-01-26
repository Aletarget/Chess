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
    public ArrayList<Casilla> piezasEquipo;
    public ArrayList<Casilla> piezasEquipoBlanco;
    public ArrayList<Casilla> piezasEquipoNegro;

    public ControllerTablero() {
        this.tablero = TableroJuego.getInstancia();
        piezasEquipo = new ArrayList<>();
        piezasEquipoBlanco = new ArrayList<>();
        piezasEquipoNegro = new ArrayList<>();
    }

    public ArrayList<Casilla> fichasBlancas(){
        EquipoBlanco equi_bl = new EquipoBlanco();
        for(int i = 1 ; i <= 8; i++ ){
            piezasEquipoBlanco.add(new Casilla(new Peon(equi_bl, 2, i)));
        }
        piezasEquipoBlanco.add(new Casilla(new Torre(equi_bl, 1, 1))); 
        piezasEquipoBlanco.add(new Casilla(new Torre(equi_bl, 1, 8))); 
        piezasEquipoBlanco.add(new Casilla(new Caballo(equi_bl, 1, 2)));
        piezasEquipoBlanco.add(new Casilla(new Caballo(equi_bl, 1, 7)));
        piezasEquipoBlanco.add(new Casilla(new Alfil(equi_bl, 1, 3)));
        piezasEquipoBlanco.add(new Casilla(new Alfil(equi_bl, 1, 6)));
        piezasEquipoBlanco.add(new Casilla(new Reina(equi_bl, 1, 4)));
        piezasEquipoBlanco.add(new Casilla(new Rey(equi_bl, 1, 5))); 

        return piezasEquipoBlanco;
    }

    public ArrayList<Casilla> fichasNegras(){
        EquipoNegro equi_ne = new EquipoNegro();
        for(int i = 1 ; i <= 8; i++ ){
            piezasEquipoBlanco.add(new Casilla(new Peon(equi_ne, 7, i)));
        }
        piezasEquipoNegro.add(new Casilla(new Torre(equi_ne, 8, 1))); 
        piezasEquipoNegro.add(new Casilla(new Torre(equi_ne, 8, 8))); 
        piezasEquipoNegro.add(new Casilla(new Caballo(equi_ne, 8, 2)));
        piezasEquipoNegro.add(new Casilla(new Caballo(equi_ne, 8, 7)));
        piezasEquipoNegro.add(new Casilla(new Alfil(equi_ne, 8, 3)));
        piezasEquipoNegro.add(new Casilla(new Alfil(equi_ne, 8, 6)));
        piezasEquipoNegro.add(new Casilla(new Reina(equi_ne, 8, 4)));
        piezasEquipoNegro.add(new Casilla(new Rey(equi_ne, 8, 5))); 

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
        Casilla casilla = new Casilla(ficha);

        tablero.getTablero()[fila - 1][columna - 1] = casilla; // Restar 1 porque las matrices comienzan en 0
        System.out.println("Colocando " + ficha.getClass().getSimpleName() + " de color " + ficha.getColor() +
                           " en la posición (" + fila + ", " + columna + ")");
    }
    
    public void iniciarJuego(){
    
        // Inicializar las piezas de ambos equipos
        piezasEquipoBlanco = fichasBlancas();
        piezasEquipoNegro = fichasNegras();
    
        // Agregar las piezas blancas al tablero
    for (Casilla ficha : piezasEquipoBlanco) {
        colocarFicha(ficha.getCasilla().getPos()[0], ficha.getCasilla().getPos()[1], ficha.getCasilla());
    }

    // Agregar las piezas negras al tablero
    for (Casilla ficha : piezasEquipoNegro) {
        colocarFicha(ficha.getCasilla().getPos()[0], ficha.getCasilla().getPos()[1], ficha.getCasilla());
    }
    
        // Unir ambas listas en piezasEquipo
        piezasEquipo.clear();
        piezasEquipo.addAll(piezasEquipoBlanco);
        piezasEquipo.addAll(piezasEquipoNegro);
    
        // Configuración inicial adicional (si aplica)
        System.out.println("El juego ha iniciado. ¡Buena suerte!");
    
    
    }

}
