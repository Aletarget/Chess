package com.app.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessMenu extends JFrame {
    public ChessMenu() {
        setTitle("♔ Ajedrez ♚");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        // Panel principal con diseño de caja (BoxLayout)
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.DARK_GRAY); // Fondo oscuro

        // Etiqueta de título
        JLabel title = new JLabel("AJEDREZ", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(20)); // Espaciado

        panel.add(title);

        // Crear botones
        String[] opciones = {"Jugar Partida", "Ver Reglas", "Salir"};
        for (String opcion : opciones) {
            JButton boton = new JButton(opcion);
            boton.setFont(new Font("Arial", Font.BOLD, 16));
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
            boton.setMaximumSize(new Dimension(250, 50)); // Tamaño uniforme
            boton.setFocusPainted(false);

            // Evento de clic
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    manejarOpcion(opcion);
                }
            });

            panel.add(Box.createVerticalStrut(15)); // Espaciado
            panel.add(boton);
        }

        add(panel);
        setVisible(true);
    }

    // Manejo de opciones
    private void manejarOpcion(String opcion) {
        switch (opcion) {
            case "Jugar Partida":
                new MainWindow(this);
                setVisible(false);
                break;
            case "Ver Reglas":
                mostrarReglas();
                break;
            case "Salir":
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChessMenu::new);
    }
    private void mostrarReglas() {
        String reglas = """
            ♔ REGLAS BÁSICAS DEL AJEDREZ ♚
            
            1. El objetivo es hacer jaque mate al rey enemigo.
            2. Cada jugador tiene 16 piezas (rey, dama, torres, alfiles, caballos y peones).
            3. Movimiento de piezas:
                • Rey: 1 casilla en cualquier dirección.
                • Dama: Cualquier número de casillas en cualquier dirección.
                • Torre: Cualquier número de casillas en línea recta.
                • Alfil: Cualquier número de casillas en diagonal.
                • Caballo: Movimiento en "L" (2+1 o 1+2).
                • Peón: 1 casilla adelante (2 en su primer movimiento).
            4. Promoción de peón: Si llega al otro lado del tablero, se convierte en dama, torre, alfil o caballo.
            5. Tablas: Se declara empate si se repite la misma posición 3 veces, por insuficiencia de material o si no hay jugadas posibles.
            6. No se puede mover dejando al propio rey en jaque.
            
            ¡Buena suerte y diviértete jugando! 😊
        """;
    
        JOptionPane.showMessageDialog(this, reglas, "Reglas del Ajedrez", JOptionPane.INFORMATION_MESSAGE);
    }
}
