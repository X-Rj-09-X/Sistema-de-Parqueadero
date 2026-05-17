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
public class VentanaIngresoAdmin extends JFrame {

    private JPanel panel;

    private JLabel lblTipo;
    private JLabel lblId;
    private JLabel lblFila;
    private JLabel lblColumna;
    private JComboBox<String> comboTipo;
    private JTextField txtId;
    private JComboBox<Integer> comboFila;
    private JComboBox<Integer> comboColumna;
    private JCheckBox checkDiscapacitado;
    private JButton btnIngresar;
    private ControladorParqueadero controlador;

 
    public VentanaIngresoAdmin(
            ControladorParqueadero controlador
    ) {

        this.controlador = controlador;

        setTitle("Ingreso Manual");

        setSize(550, 500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        iniciarComponentes();

        setVisible(true);
    }

    //componente
    public void iniciarComponentes() {

        panel = new JPanel();

        panel.setLayout(null);

        panel.setBackground(new Color(20, 30, 48));

        this.add(panel);

        //titulo
        JLabel titulo;

        titulo = new JLabel("INGRESO MANUAL");

        titulo.setBounds(120, 20, 300, 40);

        titulo.setForeground(Color.WHITE);

        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        panel.add(titulo);

        //tipo
        lblTipo = new JLabel("Tipo:");

        lblTipo.setBounds(50, 90, 120, 30);

        lblTipo.setForeground(Color.WHITE);

        panel.add(lblTipo);

        comboTipo = new JComboBox<>();

        comboTipo.addItem("CARRO");

        comboTipo.addItem("MOTO");

        comboTipo.addItem("BICICLETA");

        comboTipo.setBounds(180, 90, 180, 30);

        panel.add(comboTipo);

        //id
        lblId = new JLabel("Placa / ID:");

        lblId.setBounds(50, 140, 120, 30);

        lblId.setForeground(Color.WHITE);

        panel.add(lblId);

        txtId = new JTextField();

        txtId.setBounds(180, 140, 180, 30);

        panel.add(txtId);

        //fila
        lblFila = new JLabel("Fila:");

        lblFila.setBounds(50, 190, 120, 30);

        lblFila.setForeground(Color.WHITE);

        panel.add(lblFila);

        comboFila = new JComboBox<>();

        for (int i = 1; i <= 6; i++) {

            comboFila.addItem(i);
        }

        comboFila.setBounds(180, 190, 180, 30);

        panel.add(comboFila);

        //columna
        lblColumna = new JLabel("Columna:");

        lblColumna.setBounds(50, 240, 120, 30);

        lblColumna.setForeground(Color.WHITE);

        panel.add(lblColumna);

        comboColumna = new JComboBox<>();

        for (int i = 1; i <= 5; i++) {

            comboColumna.addItem(i);
        }

        comboColumna.setBounds(180, 240, 180, 30);

        panel.add(comboColumna);

        //discapacitado
        checkDiscapacitado = new JCheckBox(
                "Discapacitado"
        );

        checkDiscapacitado.setBounds(
                180,
                290,
                150,
                30
        );

        checkDiscapacitado.setBackground(
                new Color(20, 30, 48)
        );

        checkDiscapacitado.setForeground(Color.WHITE);

        panel.add(checkDiscapacitado);

        //boton
        btnIngresar = new JButton("INGRESAR");

        btnIngresar.setBounds(160, 360, 180, 40);

        btnIngresar.setBackground(
                new Color(0, 153, 255)
        );

        btnIngresar.setForeground(Color.WHITE);

        btnIngresar.setFocusPainted(false);

        panel.add(btnIngresar);

        //evento
        btnIngresar.addActionListener(e -> {

            ingresarManual();
        });

        //e tipo
        comboTipo.addActionListener(e -> {

            actualizarFormulario();
        });

        actualizarFormulario();
    }

    //actualizar formato
    public void actualizarFormulario() {

        String tipo;

        tipo = comboTipo.getSelectedItem().toString();

        if (tipo.equals("BICICLETA")) {

            txtId.setEnabled(false);

            txtId.setText("");

            checkDiscapacitado.setSelected(false);

            checkDiscapacitado.setEnabled(false);
        }

        else {

            txtId.setEnabled(true);

            checkDiscapacitado.setEnabled(true);
        }
    }

    //ingreso manual
    public void ingresarManual() {

        int tipo;

        String id;

        boolean discapacitado;

        int fila;

        int columna;

        tipo = comboTipo.getSelectedIndex();

        id = txtId.getText();

        discapacitado =
                checkDiscapacitado.isSelected();

        fila =
                comboFila.getSelectedIndex();

        columna =
                comboColumna.getSelectedIndex();

        String resultado;

        resultado =
                controlador.ingresarVehiculoManual(
                        tipo,
                        id,
                        discapacitado,
                        fila,
                        columna
                );

        JOptionPane.showMessageDialog(
                this,
                resultado
        );
    }
}
