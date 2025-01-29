package com.app.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.app.Controller.ControllerTablero;
import com.app.Tablero.TableroJuego;

public class Tablero extends JPanel {
    private TableroJuego tableroJuego;
    private ControllerTablero controller;
    private ImageIcon image;
    private JButton[][] imagen;
    public Tablero(){
        setLayout(new GridLayout(8, 8));
        setPreferredSize(new Dimension(800,800));
        setMaximumSize(new Dimension(800,800));
        // Colores para las casillas
        Color lightColor = new Color(253, 235, 208);
        Color darkColor = new Color(76,195,105);

        /*  DE EXTREMA IMPORTANCIA LAS SIGUIENTES DECLARACIONES CONTROLLER Y TALBEROJUEGO, APARTIR DE ESTOS DOS OBJETOS 
        DEPENDERA LA PARTE GRAFICA Y LA COMUNICACION CON LA VALIDACION DE TODOS LOS MOVIMIENTOS
        */
        controller = new ControllerTablero();
        tableroJuego = controller.iniciarJuego();

        // Test para la implemntacion de las casillas de forma grafica
        image = new ImageIcon(getClass().getResource(tableroJuego.getTablero()[0][7].getCasilla().getImg()));
        imagen = new JButton[8][8];
        imagen[0][7] = new JButton();
        imagen[0][7].setIcon(image);
        imagen[0][7].setPreferredSize(new Dimension(74,74));
        //imagen.setBorderPainted(false); // Quitar el borde del botón
        imagen[0][7].setFocusPainted(false); // Quitar el enfoque visual
        imagen[0][7].setContentAreaFilled(false);
        imagen[0][7].setAlignmentX(CENTER_ALIGNMENT);
        imagen[0][7].setAlignmentY(CENTER_ALIGNMENT);
        // Crear las casillas del tablero
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                JButton boton = new JButton();
                JPanel cell = new JPanel(new BorderLayout());
                // Alternar colores
                if ((fila + columna) % 2 == 0) {
                    cell.setBackground(lightColor);
                } else {
                    cell.setBackground(darkColor);
                }
                boton = imagen[0][7];
                cell.add(boton, BorderLayout.CENTER);
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
