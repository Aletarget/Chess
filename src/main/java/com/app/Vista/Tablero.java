package com.app.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.app.Controller.Casilla;
import com.app.Controller.ControllerTablero;
import com.app.Fichas.Ficha;
import com.app.Tablero.TableroJuego;

public class Tablero extends JPanel {
    private TableroJuego tableroJuego;
    private ControllerTablero controller;
    private JButton[][] imagen;
    private Boolean selec = false;
    private Ficha fichaOrigen;
    private Ficha fichaDestino;
    private JButton currentSelect;
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

       
        // Crear las casillas del tablero
        imagen = new JButton[8][8];

        // Crear un único ActionListener
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int fila = 0; fila < 8; fila++) {
                    for (int columna = 0; columna < 8; columna++) {
                        //Esta comparacion lo que hace es ver si el objeto anadido en imagen[fila][columna].addActionListener(buttonListener)
                        //es el mismo que el creado en el objeto JButon[x][y]
                        if (e.getSource() == imagen[fila][columna]){
                            Casilla botonElegido = tableroJuego.getTablero()[fila][columna];

                            if(!selec){
                                if (botonElegido.getCasilla() != null) {
                                    System.out.println("La ficha seleccionada es: "+ botonElegido.getCasilla() +" en: fila "+ fila+ ", columna "+columna);
                                    selec = true;
                                    fichaOrigen = botonElegido.getCasilla();
                                    currentSelect = imagen[fila][columna];
                                }else{
                                    System.out.println("boton nulo");
                                }
                            }else{
                                System.out.println("Intentando mover " + fichaOrigen + " a fila " + fila + ", columna " + columna);

                                fichaDestino = botonElegido.getCasilla();
                                boolean validacion = controller.moverFicha(fichaOrigen, fichaDestino);

                                if(validacion){
                                    fichaOrigen = fichaDestino;
                                    System.out.println("el movimiento se ha hecho");
                                }else{
                                    System.out.println("El movimiento no ha sido elegido dentro de las posibilidades");
                                }

                            }
                        }   
                    }
                }
            }
        };




        //Agrega un boton por cada casilla dentro de tableroJuego
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                JPanel cell = new JPanel(new BorderLayout());
                // Alternar colores
                if ((fila + columna) % 2 == 0) {
                    cell.setBackground(lightColor);
                } else {
                    cell.setBackground(darkColor);
                }
                    imagen[fila][columna] = tableroJuego.getTablero()[fila][columna].getBoton();
                    imagen[fila][columna].setAlignmentX(CENTER_ALIGNMENT);
                    imagen[fila][columna].setAlignmentY(CENTER_ALIGNMENT);
                    // Agregar los botones a el action listener
                    imagen[fila][columna].addActionListener(buttonListener);
                    cell.add(imagen[fila][columna]);
                add(cell); // Agregar la celda al tablero

            }
        }
        
        

    }

}
