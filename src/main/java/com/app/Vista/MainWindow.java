package com.app.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

    private Tablero tablero; 

    public MainWindow(){
        setLayout(new FlowLayout());
        setSize(new Dimension(1600,900));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CHESS");
        getContentPane().setBackground(Color.DARK_GRAY);




        tablero = new Tablero();
        // Crear un panel envolvente para que no se estire
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.add(Box.createVerticalGlue());
        panelCentral.add(tablero);
        panelCentral.add(Box.createVerticalGlue());

        // Añadir el panel central al centro del BorderLayout
        add(panelCentral, BorderLayout.CENTER);

        setVisible(true);
    }

}
