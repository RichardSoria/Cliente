package vista;

import cliente.clase.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarEstudainte extends JFrame {
    public JPanel panel1;
    private JTextField idEstudainte;
    private JButton buscarEstudainteButton;

    public ConsultarEstudainte() {

        setContentPane(panel1);

        Cliente cliente = new Cliente();

        buscarEstudainteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = idEstudainte.getText();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "Por favor, ingrese un ID de estudiante.");
                    return;
                }

                String respuesta = cliente.sendID("172.31.116.79", 5000, id);

                // Si no encuentra nada, muestra un mensaje
                if (respuesta.equals("Estudiante no encontrado.")) {
                    JOptionPane.showMessageDialog(panel1, "No se encontró el estudiante con ID: " + id);
                    return;
                }

                // Si encuentra el estudiante, muestra los detalles
                String[] partes = respuesta.split(", ");
                String idEstudiante = partes[0].split(": ")[1];
                String nombre = partes[1].split(": ")[1];
                String telefono = partes[2].split(": ")[1];
                String carrera = partes[3].split(": ")[1];
                String semestre = partes[4].split(": ")[1];
                String gratuitidad = partes[5].split(": ")[1];


                EstudianteDetalle estudianteDetalle = new EstudianteDetalle(idEstudiante, nombre, telefono, carrera, semestre, gratuitidad);
                estudianteDetalle.setContentPane(estudianteDetalle.panel2);
                estudianteDetalle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                estudianteDetalle.pack();
                estudianteDetalle.setLocationRelativeTo(null);
                estudianteDetalle.setVisible(true);
                // Cerrar la ventana actual
                dispose();


            }
        });
    }


}
