package cliente.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstudianteDetalle extends JFrame {
    JPanel panel2;
    private JButton buscarOtroEstudianteButton;
    private JLabel idLabel;
    private JLabel nombreLabel;
    private JLabel telefonoLabel;
    private JLabel carreraLabel;
    private JLabel semestreLabel;
    private JLabel gratuitidadLabel;

    public EstudianteDetalle(String id, String nombre, String telefono, String carrera, String semestre, String gratuitidad) {

        idLabel.setText(id);
        nombreLabel.setText(nombre);
        telefonoLabel.setText(telefono);
        carreraLabel.setText(carrera);
        semestreLabel.setText(semestre);
        gratuitidadLabel.setText(gratuitidad);

        buscarOtroEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual
                dispose();

                // Crear una nueva instancia de ConsultarEstudainte
                ConsultarEstudainte nuevaVentana = new ConsultarEstudainte();
                nuevaVentana.setTitle("Consultar Estudiante");
                nuevaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                nuevaVentana.setResizable(false);
                nuevaVentana.pack();
                nuevaVentana.setLocationRelativeTo(null);
                nuevaVentana.setVisible(true);

            }
        });
    }
}
