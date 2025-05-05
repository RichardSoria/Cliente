package vista;


import cliente.clase.Cliente;

import javax.swing.*;

public class Ventana extends JFrame{
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private JLabel lblResultado;
    private JButton btnLimpiarCampos;

    public Ventana() {
        setTitle("Calculadora");
        setSize(300, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        Cliente cliente = new Cliente();


        txtNumero1 = new JTextField();
        txtNumero1.setBounds(50, 20, 200, 30);
        add(txtNumero1);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(50, 60, 200, 30);
        add(txtNumero2);

        btnSumar = new JButton("Sumar");
        btnSumar.setBounds(50, 100, 80, 30);
        add(btnSumar);

        btnRestar = new JButton("Restar");
        btnRestar.setBounds(140, 100, 80, 30);
        add(btnRestar);

        btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(50, 140, 100, 30);
        add(btnMultiplicar);

        btnDividir = new JButton("Dividir");
        btnDividir.setBounds(160, 140, 80, 30);
        add(btnDividir);

        btnLimpiarCampos = new JButton("C");
        btnLimpiarCampos.setBounds(50, 180, 80, 30);
        add(btnLimpiarCampos);

        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(50, 210, 200, 30);
        add(lblResultado);

        // Action listeners for buttons
        btnSumar.addActionListener(e -> {
            double num1 = Double.parseDouble(txtNumero1.getText());
            double num2 = Double.parseDouble(txtNumero2.getText());
            String resultado = cliente.sendNumbers("172.31.116.72", 5000, (int) num1, (int) num2, "sumar");
            lblResultado.setText("Resultado: " + resultado);
        });

        btnRestar.addActionListener(e -> {
            double num1 = Double.parseDouble(txtNumero1.getText());
            double num2 = Double.parseDouble(txtNumero2.getText());
            String resultado = cliente.sendNumbers("172.31.116.72", 5000, (int) num1, (int) num2, "restar");
            lblResultado.setText("Resultado: " + resultado);
        });

        btnMultiplicar.addActionListener(e -> {
            double num1 = Double.parseDouble(txtNumero1.getText());
            double num2 = Double.parseDouble(txtNumero2.getText());
            String resultado = cliente.sendNumbers("172.31.116.72", 5000, (int) num1, (int) num2, "multiplicar");
            lblResultado.setText("Resultado: " + resultado);
        });

        btnDividir.addActionListener(e -> {
            double num1 = Double.parseDouble(txtNumero1.getText());
            double num2 = Double.parseDouble(txtNumero2.getText());
            if (num2 != 0) {
                String resultado = cliente.sendNumbers("172.31.116.72", 5000, (int) num1, (int) num2, "dividir");
                lblResultado.setText("Resultado: " + resultado);
            } else {
                lblResultado.setText("Error: División por cero");
            }
        });

        btnLimpiarCampos.addActionListener(e -> {
            txtNumero1.setText("");
            txtNumero2.setText("");
            lblResultado.setText("Resultado: ");
        });

    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
