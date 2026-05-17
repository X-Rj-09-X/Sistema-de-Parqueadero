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
public class VentanaCliente extends JFrame{

    private JPanel panel;

    private JButton btnIngreso;
    private JButton btnPago;
    private JButton btnSalida;
    private JButton btnVolver;
    private ControladorParqueadero controlador;
    

    
    public VentanaCliente(ControladorParqueadero controlador) {

        this.controlador = controlador;

        setTitle("Cliente");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        iniciarComponentes();

        setVisible(true);
    }

    // componentes
    public void iniciarComponentes() {

        panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(new Color(20, 30, 48));

        this.add(panel);

        JLabel titulo;

        titulo = new JLabel("MENU CLIENTE");

        titulo.setBounds(130, 30, 300, 40);

        titulo.setForeground(Color.WHITE);

        titulo.setFont(new Font("Arial", Font.BOLD, 26));

        panel.add(titulo);

        //imngreso
        btnIngreso = new JButton("INGRESO");

        btnIngreso.setBounds(150, 90, 180, 40);

        btnIngreso.setBackground(new Color(0, 153, 255));

        btnIngreso.setForeground(Color.WHITE);

        btnIngreso.setFocusPainted(false);

        panel.add(btnIngreso);
        
        btnIngreso.addActionListener(e -> {

            new VentanaIngreso(controlador);
        });

        //pago
        btnPago = new JButton("PAGO");

        btnPago.setBounds(150, 150, 180, 40);

        btnPago.setBackground(new Color(0, 204, 102));

        btnPago.setForeground(Color.WHITE);

        btnPago.setFocusPainted(false);

        panel.add(btnPago);

        //salida
        btnSalida = new JButton("SALIDA");

        btnSalida.setBounds(150, 210, 180, 40);

        btnSalida.setBackground(new Color(255, 153, 0));

        btnSalida.setForeground(Color.WHITE);

        btnSalida.setFocusPainted(false);

        panel.add(btnSalida);

        //volver
        btnVolver = new JButton("VOLVER");

        btnVolver.setBounds(150, 270, 180, 40);

        btnVolver.setBackground(new Color(204, 0, 0));

        btnVolver.setForeground(Color.WHITE);

        btnVolver.setFocusPainted(false);

        panel.add(btnVolver);

        //volver accion
        btnVolver.addActionListener(e -> {

            dispose();
        });
    }
}
    

