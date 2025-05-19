package cliente.test;

import cliente.vista.ConsultarEstudainte;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        ConsultarEstudainte frame = new ConsultarEstudainte();
        frame.setTitle("Consultar Estudiante");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
