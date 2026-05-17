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
public class VentanaContabilidad extends JFrame {

    private JPanel panel;
    private JLabel lblDia;
    private JLabel lblSemana;
    private JLabel lblMes;
    private ControladorParqueadero controlador;


    public VentanaContabilidad(
            ControladorParqueadero controlador
    ) {

        this.controlador = controlador;

        setTitle("Contabilidad");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        iniciarComponentes();

        setVisible(true);
    }

    //compnenentes
    public void iniciarComponentes() {

        panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(new Color(20, 30, 48));

        this.add(panel);

        //titulo
        JLabel titulo;

        titulo = new JLabel("CONTABILIDAD");

        titulo.setBounds(120, 30, 300, 40);

        titulo.setForeground(Color.WHITE);

        titulo.setFont(new Font("Arial", Font.BOLD, 26));

        panel.add(titulo);

        //dia
        lblDia = new JLabel(
                "Total Día: $"
                +
                controlador.getParqueadero()
                        .getTotalDia()
        );

        lblDia.setBounds(80, 120, 300, 30);

        lblDia.setForeground(Color.WHITE);

        lblDia.setFont(new Font("Arial", Font.BOLD, 18));

        panel.add(lblDia);

        //semnana
        lblSemana = new JLabel(
                "Total Semana: $"
                +
                controlador.getParqueadero()
                        .getTotalSemana()
        );

        lblSemana.setBounds(80, 180, 300, 30);

        lblSemana.setForeground(Color.WHITE);

        lblSemana.setFont(new Font("Arial", Font.BOLD, 18));

        panel.add(lblSemana);

        //mes
        lblMes = new JLabel(
                "Total Mes: $"
                +
                controlador.getParqueadero()
                        .getTotalMes()
        );

        lblMes.setBounds(80, 240, 300, 30);

        lblMes.setForeground(Color.WHITE);

        lblMes.setFont(new Font("Arial", Font.BOLD, 18));

        panel.add(lblMes);
    }
}