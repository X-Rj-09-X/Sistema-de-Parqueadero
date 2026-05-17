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
public class VentanaPrincipal extends JFrame {
    
    private JPanel panel;
    private JButton btnCliente;
    private JButton btnAdmin;
    private JButton btnContabilidad;
    private JButton btnSalir;
    private ControladorParqueadero controlador;

   
    public VentanaPrincipal() {

        controlador = new ControladorParqueadero();

        setTitle("Sistema Parqueadero");

        setSize(500, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        iniciarComponentes();

        setVisible(true);
    }

    //componentes
    public void iniciarComponentes() {

        panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(new Color(30, 30, 30));

        this.add(panel);

        JLabel titulo;

        titulo = new JLabel("SISTEMA PARQUEADERO");

        titulo.setBounds(80, 40, 350, 40);

        titulo.setForeground(Color.WHITE);

        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        panel.add(titulo);

        //boton cliente
        btnCliente = new JButton("CLIENTE");

        btnCliente.setBounds(150, 100, 180, 40);

        panel.add(btnCliente);
        
        btnCliente.addActionListener(e -> {

            new VentanaCliente(controlador);
        });

        //boton admin
        btnAdmin = new JButton("ADMINISTRADOR");

        btnAdmin.setBounds(150, 160, 180, 40);

        panel.add(btnAdmin);

        //boton contabilidad
        btnContabilidad = new JButton("CONTABILIDAD");

        btnContabilidad.setBounds(150, 220, 180, 40);

        panel.add(btnContabilidad);

        //boton salir
        btnSalir = new JButton("SALIR");

        btnSalir.setBounds(150, 280, 180, 40);

        panel.add(btnSalir);

        //salir
        btnSalir.addActionListener(e -> {

            System.exit(0);
        });
    }
    
}
