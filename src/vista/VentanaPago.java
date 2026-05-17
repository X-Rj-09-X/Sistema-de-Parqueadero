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
public class VentanaPago extends JFrame {

    private JPanel panel;
    private JLabel lblId;
    private JLabel lblCompras;
    private JLabel lblCodigo;
    private JTextField txtId;
    private JTextField txtCompras;
    private JTextField txtCodigo;
    private JCheckBox checkEmpleado;
    private JButton btnPagar;
    private ControladorParqueadero controlador;

    
    
    public VentanaPago(ControladorParqueadero controlador) {

        this.controlador = controlador;

        setTitle("Pago Vehículo");

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

        // titulo
        JLabel titulo;

        titulo = new JLabel("PAGO VEHICULO");

        titulo.setBounds(120, 20, 300, 40);

        titulo.setForeground(Color.WHITE);

        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        panel.add(titulo);

        //id
        lblId = new JLabel("Placa / ID:");

        lblId.setBounds(50, 90, 120, 30);

        lblId.setForeground(Color.WHITE);

        panel.add(lblId);

        txtId = new JTextField();

        txtId.setBounds(180, 90, 180, 30);

        panel.add(txtId);

        //empleado
        checkEmpleado = new JCheckBox("Empleado");

        checkEmpleado.setBounds(180, 140, 150, 30);

        checkEmpleado.setBackground(new Color(20, 30, 48));

        checkEmpleado.setForeground(Color.WHITE);

        panel.add(checkEmpleado);

        // codigo
        lblCodigo = new JLabel("Código:");

        lblCodigo.setBounds(50, 190, 120, 30);

        lblCodigo.setForeground(Color.WHITE);

        panel.add(lblCodigo);

        txtCodigo = new JTextField();

        txtCodigo.setBounds(180, 190, 180, 30);

        panel.add(txtCodigo);

        //comnpras
        lblCompras = new JLabel("Valor Compras:");

        lblCompras.setBounds(50, 240, 120, 30);

        lblCompras.setForeground(Color.WHITE);

        panel.add(lblCompras);

        txtCompras = new JTextField();

        txtCompras.setBounds(180, 240, 180, 30);

        panel.add(txtCompras);

        //boton
        btnPagar = new JButton("PAGAR");

        btnPagar.setBounds(150, 320, 180, 40);

        btnPagar.setBackground(new Color(0, 153, 255));

        btnPagar.setForeground(Color.WHITE);

        btnPagar.setFocusPainted(false);

        panel.add(btnPagar);

        //empleado
        checkEmpleado.addActionListener(e -> {

            actualizarFormulario();
        });

        //e pagar
        btnPagar.addActionListener(e -> {

            pagarVehiculo();
        });

        actualizarFormulario();
    }

    //actualizar formato
    public void actualizarFormulario() {

        boolean empleado;

        empleado = checkEmpleado.isSelected();

        txtCodigo.setEnabled(empleado);
    }

    //pagar
    public void pagarVehiculo() {

        String id;

        boolean empleado;

        String codigo;

        double compras;

        id = txtId.getText();

        empleado = checkEmpleado.isSelected();

        codigo = txtCodigo.getText();

        try {

            compras = Double.parseDouble(
                    txtCompras.getText()
            );

        } catch (Exception e) {

            compras = 0;
        }

        String resultado;

        resultado = controlador.pagarVehiculo(
                id,
                empleado,
                codigo,
                compras
        );

        JOptionPane.showMessageDialog(
                this,
                resultado
        );
    }
}