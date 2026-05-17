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
public class VentanaLoginAdmin extends JFrame {

    private JPanel panel;

    private JLabel lblUsuario;
    private JLabel lblContrasena;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;
    private ControladorParqueadero controlador;


    public VentanaLoginAdmin(
            ControladorParqueadero controlador
    ) {

        this.controlador = controlador;

        setTitle("Login Administrador");

        setSize(450, 350);

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

        //titulo
        JLabel titulo;

        titulo = new JLabel("ADMINISTRADOR");

        titulo.setBounds(100, 30, 300, 40);

        titulo.setForeground(Color.WHITE);

        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        panel.add(titulo);

        //usuario
        lblUsuario = new JLabel("Usuario:");

        lblUsuario.setBounds(50, 100, 100, 30);

        lblUsuario.setForeground(Color.WHITE);

        panel.add(lblUsuario);

        txtUsuario = new JTextField();

        txtUsuario.setBounds(170, 100, 180, 30);

        panel.add(txtUsuario);

        //contraseña
        lblContrasena = new JLabel("Contraseña:");

        lblContrasena.setBounds(50, 160, 100, 30);

        lblContrasena.setForeground(Color.WHITE);

        panel.add(lblContrasena);

        txtContrasena = new JPasswordField();

        txtContrasena.setBounds(170, 160, 180, 30);

        panel.add(txtContrasena);

        //boton
        btnIngresar = new JButton("INGRESAR");

        btnIngresar.setBounds(130, 240, 180, 40);

        btnIngresar.setBackground(new Color(255, 153, 0));

        btnIngresar.setForeground(Color.WHITE);

        btnIngresar.setFocusPainted(false);

        panel.add(btnIngresar);

        //evento
        btnIngresar.addActionListener(e -> {

            login();
        });
    }

    //login
    public void login() {

        String usuario;

        String contrasena;

        usuario = txtUsuario.getText();

        contrasena = String.valueOf(
                txtContrasena.getPassword()
        );

        boolean valido;

        valido = controlador.validarAdmin(
                usuario,
                contrasena
        );

        if (valido) {

            JOptionPane.showMessageDialog(
                    this,
                    "Bienvenido administrador"
            );

            dispose();

            new VentanaAdmin(controlador);
        }

        else {

            JOptionPane.showMessageDialog(
                    this,
                    "Credenciales incorrectas"
            );
        }
    }
}
