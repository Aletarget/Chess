package com.app.Vista;

import javax.swing.*;
import java.awt.*;

public class panelLateral extends JPanel {
    @SuppressWarnings("unused")
    public panelLateral(JFrame menu, JFrame Partida, Tablero tablero) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(50, 50, 50)); // Fondo oscuro
        setPreferredSize(new Dimension(250, 600)); // Tamaño del panel

        // 🔹 Etiqueta de título
        JLabel label = new JLabel("Opciones del Juego", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalStrut(20)); // Espaciado
        add(label);

        // 🔹 Botón "Rendirse"
        JButton btnRendirse = new JButton("Rendirse");
        configurarBoton(btnRendirse);
        btnRendirse.addActionListener(e -> {
            if (tablero.getTurno().equals("Blanco")) {
                JOptionPane.showMessageDialog(this, "Las fichas blancas han decidido rendirse", "Rendirse", JOptionPane.WARNING_MESSAGE);
            }else if(tablero.getTurno().equals("Negro")){
                JOptionPane.showMessageDialog(this, "Las fichas negras han decidido rendirse", "Rendirse", JOptionPane.WARNING_MESSAGE);
            }
            menu.setVisible(true);
            Partida.dispose();
        });

        add(Box.createVerticalStrut(20)); // Espaciado
        add(btnRendirse);

        // 🔹 Botón "Ofrecer Tablas"
        JButton btnTablas = new JButton("Ofrecer Tablas");
        configurarBoton(btnTablas);
        btnTablas.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Aceptas las tablas?", "Ofrecer Tablas", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "¡Partida empatada!", "Tablas", JOptionPane.INFORMATION_MESSAGE);
                menu.setVisible(true);
                Partida.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Las tablas han sido rechazadas.", "Tablas", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(Box.createVerticalStrut(20)); // Espaciado
        add(btnTablas);

        JButton btnSalir = new JButton("Salir");
        configurarBoton(btnSalir);
        btnSalir.addActionListener(e -> {
            menu.setVisible(true);
            Partida.dispose();
        });
        add(Box.createVerticalStrut(20)); // Espaciado
        add(btnSalir);

    }

    // Método para configurar el diseño de los botones
    private void configurarBoton(JButton boton) {
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setMaximumSize(new Dimension(200, 50));
        boton.setFocusPainted(false);
    }
}
