/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import controlador.ControladorParqueadero;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Ricardo J
 */
public class VentanaAdmin extends JFrame {

    private JPanel panel;
    private JButton btnVerPlazas;
    private JButton btnIngreso;
    private JButton btnSalida;
    private JButton btnVolver;
    private ControladorParqueadero controlador;
    

    public VentanaAdmin(
            ControladorParqueadero controlador
    ) {

        this.controlador = controlador;

        setTitle("Administrador");

        setSize(500, 450);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        iniciarComponentes();

        setVisible(true);
    }
    
    //componentes
    public void iniciarComponentes() {

        panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(new Color(20, 30, 48));

        this.add(panel);

        //titulos
        JLabel titulo;

        titulo = new JLabel("MENU ADMIN");

        titulo.setBounds(120, 30, 300, 40);

        titulo.setForeground(Color.WHITE);

        titulo.setFont(new Font("Arial", Font.BOLD, 26));

        panel.add(titulo);

        //ver plazas
        btnVerPlazas = new JButton("VER PLAZAS");

        btnVerPlazas.setBounds(140, 100, 200, 40);

        btnVerPlazas.setBackground(new Color(0, 153, 255));

        btnVerPlazas.setForeground(Color.WHITE);

        btnVerPlazas.setFocusPainted(false);

        panel.add(btnVerPlazas);

        //ingreso
        btnIngreso = new JButton("INGRESO MANUAL");

        btnIngreso.setBounds(140, 160, 200, 40);

        btnIngreso.setBackground(new Color(0, 204, 102));

        btnIngreso.setForeground(Color.WHITE);

        btnIngreso.setFocusPainted(false);

        panel.add(btnIngreso);

        //salida
        btnSalida = new JButton("SALIDA MANUAL");

        btnSalida.setBounds(140, 220, 200, 40);

        btnSalida.setBackground(new Color(255, 153, 0));

        btnSalida.setForeground(Color.WHITE);

        btnSalida.setFocusPainted(false);

        panel.add(btnSalida);

        //volver
        btnVolver = new JButton("VOLVER");

        btnVolver.setBounds(140, 280, 200, 40);

        btnVolver.setBackground(new Color(204, 0, 0));

        btnVolver.setForeground(Color.WHITE);

        btnVolver.setFocusPainted(false);

        panel.add(btnVolver);

        //e ver plazas
        btnVerPlazas.addActionListener(e -> {

            new VentanaPlazas(controlador);
        });

        //e ingreso
        btnIngreso.addActionListener(e -> {

            new VentanaIngresoAdmin(controlador);
        });

        //e salida
        btnSalida.addActionListener(e -> {

            new VentanaSalidaAdmin(controlador);
        });

        //e volver
        btnVolver.addActionListener(e -> {

            dispose();
        });
    }
}
