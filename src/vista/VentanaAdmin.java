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

    private ControladorParqueadero controlador;

    public VentanaAdmin(
            ControladorParqueadero controlador
    ) {

        this.controlador = controlador;

        setTitle("Administrador");

        setSize(600, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();

        panel.setBackground(new Color(20, 30, 48));

        this.add(panel);

        setVisible(true);
    }
}
