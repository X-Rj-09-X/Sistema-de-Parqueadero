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
public class VentanaIngreso extends JFrame {

    private JPanel panel;

    private JLabel lblTipo;
    private JLabel lblId;
    private JComboBox<String> comboTipo;
    private JTextField txtId;
    private JCheckBox checkDiscapacitado;
    private JButton btnIngresar;
    private ControladorParqueadero controlador;

    
    
    
    public VentanaIngreso(ControladorParqueadero controlador) {

        this.controlador = controlador;

        setTitle("Ingreso Vehículo");

        setSize(500, 400);

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

        titulo = new JLabel("INGRESO VEHICULO");

        titulo.setBounds(100, 20, 300, 40);

        titulo.setForeground(Color.WHITE);

        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        panel.add(titulo);

        //tipo
        lblTipo = new JLabel("Tipo Vehículo:");

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

        //discapacitado

        checkDiscapacitado = new JCheckBox("Discapacitado");

        checkDiscapacitado.setBounds(180, 190, 150, 30);

        checkDiscapacitado.setBackground(new Color(20, 30, 48));

        checkDiscapacitado.setForeground(Color.WHITE);

        panel.add(checkDiscapacitado);

        //boton
        btnIngresar = new JButton("INGRESAR");

        btnIngresar.setBounds(150, 260, 180, 40);

        btnIngresar.setBackground(new Color(0, 153, 255));

        btnIngresar.setForeground(Color.WHITE);

        btnIngresar.setFocusPainted(false);

        panel.add(btnIngresar);

        //ingresar
        btnIngresar.addActionListener(e -> {

            ingresarVehiculo();
        });

        //combo
        comboTipo.addActionListener(e -> {

            actualizarFormulario();
        });

        actualizarFormulario();
    }

    //actualizar formatpo
    public void actualizarFormulario() {

        String tipo;

        tipo = comboTipo.getSelectedItem().toString();

        //bicicleta
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

    //ingresa vehiculo
    public void ingresarVehiculo() {

        int tipo;

        String id;

        boolean discapacitado;

        tipo = comboTipo.getSelectedIndex();

        id = txtId.getText();

        discapacitado = checkDiscapacitado.isSelected();

        String resultado;

        resultado = controlador.ingresarVehiculo(
                tipo,
                id,
                discapacitado
        );

        JOptionPane.showMessageDialog(
                this,
                resultado
        );
    }
}