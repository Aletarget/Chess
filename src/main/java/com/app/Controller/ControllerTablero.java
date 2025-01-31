package com.app.Controller;
import com.app.EquipoBridge.EquipoBlanco;
import com.app.EquipoBridge.EquipoNegro;
import com.app.Fichas.Alfil;
import com.app.Fichas.Caballo;
import com.app.Fichas.Ficha;
import com.app.Fichas.Peon;
import com.app.Fichas.Reina;
import com.app.Fichas.Rey;
import com.app.Fichas.Torre;
import com.app.Movimientos.MovAlfil;
import com.app.Movimientos.MovCaballo;
import com.app.Movimientos.MovPeon;
import com.app.Movimientos.MovReina;
import com.app.Movimientos.MovRey;
import com.app.Movimientos.MovTorre;
import com.app.Tablero.TableroJuego;

public class ControllerTablero {
    public TableroJuego tableroInstancia;
    public Casilla[][] piezasEquipo;
    public Casilla[][] piezasEquipoBlanco;
    public Casilla[][] piezasEquipoNegro;

    public ControllerTablero() {
        this.tableroInstancia = TableroJuego.getInstancia();
        piezasEquipo = new Casilla[8][8];
        piezasEquipoBlanco = new Casilla[8][8];
        piezasEquipoNegro = new Casilla[8][8];
    }

    public Casilla[][] fichasBlancas(){
        EquipoBlanco equi_bl = new EquipoBlanco();
        for(int i = 0 ; i < 8; i++ ){
            piezasEquipoBlanco[6][i] = new Casilla(new Peon(equi_bl,7,i+1));
        }
        piezasEquipoBlanco[7][0] = new Casilla(new Torre(equi_bl,8,1));
        piezasEquipoBlanco[7][7] = new Casilla(new Torre(equi_bl,8,8));
        piezasEquipoBlanco[7][1] = new Casilla(new Caballo(equi_bl,8,2));
        piezasEquipoBlanco[7][6] = new Casilla(new Caballo(equi_bl,8,7));
        piezasEquipoBlanco[7][2] = new Casilla(new Alfil(equi_bl,8,3));
        piezasEquipoBlanco[7][5] = new Casilla(new Alfil(equi_bl,8,6));
        piezasEquipoBlanco[7][3] = new Casilla(new Reina(equi_bl,8,4));
        piezasEquipoBlanco[7][4] = new Casilla(new Rey(equi_bl,8,5));
        

        return piezasEquipoBlanco;
    }

    public Casilla[][] fichasNegras(){
        EquipoNegro equi_ne = new EquipoNegro();

        for(int i = 0 ; i < 8; i++ ){
            piezasEquipoNegro[1][i] = new Casilla(new Peon(equi_ne,2,i+1));
        }
        piezasEquipoNegro[0][0] = new Casilla(new Torre(equi_ne,1,1));
        piezasEquipoNegro[0][7] = new Casilla(new Torre(equi_ne,1,8));
        piezasEquipoNegro[0][1] = new Casilla(new Caballo(equi_ne,1,2));
        piezasEquipoNegro[0][6] = new Casilla(new Caballo(equi_ne,1,7));
        piezasEquipoNegro[0][2] = new Casilla(new Alfil(equi_ne,1,3));
        piezasEquipoNegro[0][5] = new Casilla(new Alfil(equi_ne,1,6));
        piezasEquipoNegro[0][3] = new Casilla(new Reina(equi_ne,1,4));
        piezasEquipoNegro[0][4] = new Casilla(new Rey(equi_ne,1,5));


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

        tableroInstancia.setCasillaInTablero(casilla,(fila-1),(columna-1)); // Restar 1 porque las matrices comienzan en 0
        System.out.println("Colocando " + ficha.getClass().getSimpleName() + " de color " + ficha.getColor() +
                           " en la posición (" + fila + ", " + columna + ")");
    }
    
    public TableroJuego iniciarJuego(){
    
        // Inicializar las piezas de ambos equipos
        Casilla[][] piezasEquipoBlanco = fichasBlancas();
        Casilla[][] piezasEquipoNegro = fichasNegras();

        // Inicializar el tablero con null en todas las posiciones
    for (int i = 1; i < 9; i++) {
        for (int j = 1; j < 9; j++) {
            tableroInstancia.setCasillaInTablero(new Casilla(null), i-1, j-1);
        }
    }
    
        // Agregar las piezas blancas al tablero
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                Casilla pieza = piezasEquipoNegro[i][j];
                System.out.println(pieza.getCasilla().getImg());
                colocarFicha(pieza.getCasilla().getPos()[0],pieza.getCasilla().getPos()[1],pieza.getCasilla());
            }
        }

        // Agregar las piezas negras al tablero
        for (int i = 7; i >= 6; i--) {
            for (int j = 0; j < 8; j++) {
                Casilla pieza = piezasEquipoBlanco[i][j];
                colocarFicha(pieza.getCasilla().getPos()[0],pieza.getCasilla().getPos()[1],pieza.getCasilla()); 
            }
        }

        System.out.println("El juego ha iniciado. ¡Buena suerte!");
    
        return tableroInstancia;
    }

    public boolean moverFicha(Ficha fichaElegida, int fila, int columna){


        // Crear una instancia de la clase de movimiento correspondiente
        Boolean movimiento;
        if (fichaElegida instanceof Peon) {
            movimiento = new MovPeon().movimiento(fichaElegida, tableroInstancia ,fila, columna);
        } else if (fichaElegida instanceof Torre) {
            movimiento = new MovTorre().movimiento(fichaElegida, tableroInstancia, fila, columna);
        } else if (fichaElegida instanceof Caballo) {
            movimiento = new MovCaballo().movimiento(fichaElegida, tableroInstancia, fila, columna);
        } else if (fichaElegida instanceof Alfil) {
            movimiento = new MovAlfil().movimiento(fichaElegida, tableroInstancia, fila, columna);
        } else if (fichaElegida instanceof Reina) {
            movimiento = new MovReina().movimiento(fichaElegida, tableroInstancia, fila, columna);
        } else if (fichaElegida instanceof Rey) {
            movimiento = new MovRey().movimiento(fichaElegida, tableroInstancia, fila, columna);
        } else {
            System.out.println("Tipo de ficha desconocido.");
            return false;
        }
        //Mostrar la lista de movimientos disponibles
        //List<int[]> lista_mov = movimiento.movimiento(ficha);

        

        System.out.println("Movimiento realizado: " + fichaElegida.getClass().getSimpleName() +
                        " de (" + fichaElegida.getPos()[0] + ", " + 
                        fichaElegida.getPos()[1] 
                        + ") a (" + (fila+1) + ", " 
                        + (columna+1) + ").");
        return movimiento;
    }

    public Casilla[][] getPiezasEquipo() {
        return piezasEquipo;
    }

    public Casilla[][] getPiezasEquipoBlanco() {
        return piezasEquipoBlanco;
    }

    public Casilla[][] getPiezasEquipoNegro() {
        return piezasEquipoNegro;
    }
    

    
    
}
