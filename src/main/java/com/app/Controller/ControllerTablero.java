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
import com.app.Movimientos.Movimientos;
import com.app.Tablero.TableroJuego;

public class ControllerTablero {
    public TableroJuego tableroInstancia;
    public Casilla[][] piezasEquipo;
    public Casilla[][] piezasEquipoBlanco;
    public Casilla[][] piezasEquipoNegro;

    public ControllerTablero() {
        this.tableroInstancia = TableroJuego.getInstancia();
        piezasEquipo = new Casilla[9][9];
        piezasEquipoBlanco = new Casilla[9][9];
        piezasEquipoNegro = new Casilla[9][9];
    }

    public Casilla[][] fichasBlancas(){
        EquipoBlanco equi_bl = new EquipoBlanco();
        for(int i = 1 ; i < 9; i++ ){
            piezasEquipoBlanco[7][i] = new Casilla(new Peon(equi_bl,7,i));
        }
        piezasEquipoBlanco[8][1] = new Casilla(new Torre(equi_bl,8,1));
        piezasEquipoBlanco[8][8] = new Casilla(new Torre(equi_bl,8,8));
        piezasEquipoBlanco[8][2] = new Casilla(new Caballo(equi_bl,8,2));
        piezasEquipoBlanco[8][7] = new Casilla(new Caballo(equi_bl,8,7));
        piezasEquipoBlanco[8][3] = new Casilla(new Alfil(equi_bl,8,3));
        piezasEquipoBlanco[8][6] = new Casilla(new Alfil(equi_bl,8,6));
        piezasEquipoBlanco[8][4] = new Casilla(new Reina(equi_bl,8,4));
        piezasEquipoBlanco[8][5] = new Casilla(new Rey(equi_bl,8,5));
        

        return piezasEquipoBlanco;
    }

    public Casilla[][] fichasNegras(){
        EquipoNegro equi_ne = new EquipoNegro();

        for(int i = 1 ; i < 9; i++ ){
            piezasEquipoNegro[2][i] = new Casilla(new Peon(equi_ne,2,i));
        }
        piezasEquipoNegro[1][1] = new Casilla(new Torre(equi_ne,1,1));
        piezasEquipoNegro[1][8] = new Casilla(new Torre(equi_ne,1,8));
        piezasEquipoNegro[1][2] = new Casilla(new Caballo(equi_ne,1,2));
        piezasEquipoNegro[1][7] = new Casilla(new Caballo(equi_ne,1,7));
        piezasEquipoNegro[1][3] = new Casilla(new Alfil(equi_ne,1,3));
        piezasEquipoNegro[1][6] = new Casilla(new Alfil(equi_ne,1,6));
        piezasEquipoNegro[1][4] = new Casilla(new Reina(equi_ne,1,4));
        piezasEquipoNegro[1][5] = new Casilla(new Rey(equi_ne,1,5));


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
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 9; j++) {
                Casilla pieza = piezasEquipoNegro[i][j];
                System.out.println(pieza.getCasilla().getImg());
                colocarFicha(pieza.getCasilla().getPos()[0],pieza.getCasilla().getPos()[1],pieza.getCasilla());
            }
        }

        // Agregar las piezas negras al tablero
        for (int i = 8; i >= 7; i--) {
            for (int j = 1; j < 9; j++) {
                Casilla pieza = piezasEquipoBlanco[i][j];
                colocarFicha(pieza.getCasilla().getPos()[0],pieza.getCasilla().getPos()[1],pieza.getCasilla()); 
            }
        }

        System.out.println("El juego ha iniciado. ¡Buena suerte!");
    
        return tableroInstancia;
    }

    public boolean moverFicha(Ficha fichaElegida, Ficha destino){

        Ficha ficha = fichaElegida;

        // Verificar si hay una ficha en la posición inicial
        if (ficha == null) {
            System.out.println("No hay ficha en la posición inicial");
            return false;
        }

        // Validar que las coordenadas estén dentro del tablero
        if (fichaElegida.getPos()[0] < 1 || fichaElegida.getPos()[0] > 8 || 
            fichaElegida.getPos()[1] < 1 || fichaElegida.getPos()[1] > 8 ||
            destino.getPos()[0] < 1 || destino.getPos()[0] > 8 ||
            destino.getPos()[1] < 1 || destino.getPos()[1] > 8) {
            System.out.println("Movimiento fuera de los límites del tablero.");
            return false;
        }
        

        // Crear una instancia de la clase de movimiento correspondiente
        Movimientos movimiento;
        if (ficha instanceof Peon) {
            movimiento = new MovPeon();
        } else if (ficha instanceof Torre) {
            movimiento = new MovTorre();
        } else if (ficha instanceof Caballo) {
            movimiento = new MovCaballo();
        } else if (ficha instanceof Alfil) {
            movimiento = new MovAlfil();
        } else if (ficha instanceof Reina) {
            movimiento = new MovReina();
        } else if (ficha instanceof Rey) {
            movimiento = new MovRey();
        } else {
            System.out.println("Tipo de ficha desconocido.");
            return false;
        }
        //Mostrar la lista de movimientos disponibles
        //List<int[]> lista_mov = movimiento.movimiento(ficha);

        

        System.out.println("Movimiento realizado: " + ficha.getClass().getSimpleName() +
                        " de (" + fichaElegida.getPos()[0] + ", " + 
                        fichaElegida.getPos()[1] 
                        + ") a (" + destino.getPos()[0] + ", " 
                        + destino.getPos()[1] + ").");
        return true;
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
