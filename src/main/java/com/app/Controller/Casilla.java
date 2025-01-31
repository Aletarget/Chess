package com.app.Controller;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.app.Fichas.Ficha;

public class Casilla implements Tablero {
    private Ficha ficha;
    private JButton imagen;
    public Casilla(Ficha ficha){
        this.ficha = ficha;
        if (ficha == null) {
            imagen = new JButton();
            imagen.setIcon(null);
            imagen.setPreferredSize(new Dimension(100,100));
            //imagen.setBorderPainted(false); // Quitar el borde del botón
            imagen.setFocusPainted(false); // Quitar el enfoque visual
            imagen.setContentAreaFilled(false);
        }else{
            imagen = new JButton();
            ImageIcon image = new ImageIcon(getClass().getResource(ficha.getImg()));
            imagen.setIcon(image);
            imagen.setPreferredSize(new Dimension(100,100));
            //imagen.setBorderPainted(false); // Quitar el borde del botón
            imagen.setFocusPainted(false); // Quitar el enfoque visual
            imagen.setContentAreaFilled(false);
        }
    }

    @Override
    public Ficha getCasilla() {
        return ficha;
    }
    @Override
    public void fillCasilla(Ficha ficha, int[] pos) {
        this.ficha = ficha;
        this.ficha.setPos(pos);
        this.imagen.setIcon(new ImageIcon(getClass().getResource(ficha.getImg())));
    }
    @Override
    public void cleanCasilla() {
        this.ficha = null;
        imagen.setIcon(null);
    }
    public JButton getBoton(){
        return imagen;
    }
    
}
