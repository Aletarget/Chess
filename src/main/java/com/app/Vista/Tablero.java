package com.app.Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import com.app.Tablero.TableroJuego;

public class Tablero extends JPanel {
    private TableroJuego tableroJuego;
    public Tablero(){
        setLayout(new GridLayout(8, 8));
        setPreferredSize(new Dimension(800,800));
        setMaximumSize(new Dimension(800,800));
        // Colores para las casillas
        Color lightColor = new Color(253, 235, 208);
        Color darkColor = new Color(76,195,105);

        // Crear las casillas del tablero
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                JPanel cell = new JPanel();
                // Alternar colores
                if ((fila + columna) % 2 == 0) {
                    cell.setBackground(lightColor);
                } else {
                    cell.setBackground(darkColor);
                }
                add(cell); // Agregar la celda al tablero
            }
        }

        tableroJuego = TableroJuego.getInstancia();

        //Con esta anidacion de ciclos for lo que hacemos es asignarle a cada posicion de {fila,columna} al gridLayout
        for(int fila = 0;fila<8;fila++){
            for(int columna = 0;columna <2;columna ++){
            }
        }
        //A partir de aqui, lo que se debe de hacer es coger 'inicialTablero y comenzar a rellenar cada una de las casillas en el GridLayout'
    }
}
