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
public class VentanaSalidaAdmin extends JFrame {

    private JPanel panel;
    private JLabel lblId;
    private JTextField txtId;
    private JButton btnSalida;
    private ControladorParqueadero controlador;


    public VentanaSalidaAdmin(
            ControladorParqueadero controlador
    ) {

        this.controlador = controlador;

        setTitle("Salida Manual");

        setSize(500, 350);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        iniciarComponentes();

        setVisible(true);
    }

    // componente
    public void iniciarComponentes() {

        panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(new Color(20, 30, 48));

        this.add(panel);

        // titulo
        JLabel titulo;

        titulo = new JLabel("SALIDA MANUAL");

        titulo.setBounds(120, 30, 300, 40);

        titulo.setForeground(Color.WHITE);

        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        panel.add(titulo);

        //id
        lblId = new JLabel("Placa / ID:");

        lblId.setBounds(50, 120, 120, 30);

        lblId.setForeground(Color.WHITE);

        panel.add(lblId);

        txtId = new JTextField();

        txtId.setBounds(180, 120, 180, 30);

        panel.add(txtId);

        // boton
        btnSalida = new JButton("DAR SALIDA");

        btnSalida.setBounds(150, 210, 180, 40);

        btnSalida.setBackground(
                new Color(255, 153, 0)
        );

        btnSalida.setForeground(Color.WHITE);

        btnSalida.setFocusPainted(false);

        panel.add(btnSalida);

        //evento
        btnSalida.addActionListener(e -> {

            salidaManual();
        });
    }

    // salida manual
    public void salidaManual() {

        String id;

        id = txtId.getText();

        String resultado;

        resultado =
                controlador.salidaManual(id);

        JOptionPane.showMessageDialog(
                this,
                resultado
        );
    }
}