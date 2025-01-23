package com.app.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

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


        // Crear el panel central redondeado
        JPanel panelCentral = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                // Establecer suavizado de bordes
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Dibujar un rectángulo con bordes redondeados
                g2d.setColor(Color.WHITE); // Color de fondo
                g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50)); // Ajustar el radio de las esquinas
            }
        };

        tablero = new Tablero();
        // Crear un panel envolvente para que no se estire
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.add(Box.createVerticalGlue());
        panelCentral.add(tablero);
        panelCentral.add(Box.createVerticalGlue());

        // Añadir el panel central al centro del BorderLayout
        add(panelCentral, BorderLayout.CENTER);

        setVisible(true);
    }

}
