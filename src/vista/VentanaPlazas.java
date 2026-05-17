/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import controlador.ControladorParqueadero;
import modelo.Vehiculo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author Ricardo J
 */
public class VentanaPlazas extends JFrame {

    private JPanel panel;
    private JTable tabla;
    private JScrollPane scroll;
    private ControladorParqueadero controlador;

    
    
    public VentanaPlazas(
            ControladorParqueadero controlador
    ) {

        this.controlador = controlador;

        setTitle("Plazas Parqueadero");

        setSize(700, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        iniciarComponentes();

        setVisible(true);
    }

    //componenetes
    public void iniciarComponentes() {

        panel = new JPanel();

        panel.setLayout(new BorderLayout());

        panel.setBackground(new Color(20, 30, 48));

        this.add(panel);

        //columnas
        String[] columnas = {
                "TIPO",
                "PLACA / ID",
                "FILA",
                "COLUMNA",
                "PAGADO"
        };

        DefaultTableModel modelo;

        modelo = new DefaultTableModel();

        modelo.setColumnIdentifiers(columnas);

        //agregar datos
        for (Vehiculo v :
                controlador.getParqueadero()
                        .getListaVehiculos()) {

            modelo.addRow(new Object[]{

                    v.getTipo(),
                    v.getId(),
                    v.getFila() + 1,
                    v.getColumna() + 1,
                    v.isPagado()
            });
        }

        tabla = new JTable(modelo);

        scroll = new JScrollPane(tabla);

        panel.add(scroll, BorderLayout.CENTER);
    }
}
