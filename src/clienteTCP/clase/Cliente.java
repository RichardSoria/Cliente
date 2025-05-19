package clienteTCP.clase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
    private static final int PUERTO = 8080;
    private static final String IP = "localhost";

    public static String enviarRegistro(String nombre, String hora_ingreso, String hora_salida, String hora_almuerzo_inicio, String hora_almuerzo_fin) throws Exception {
        Socket Cliente = new Socket(IP, PUERTO);
        InputStream input = Cliente.getInputStream();
        OutputStream output = Cliente.getOutputStream();

        // Enviar datos al servidor
        DataOutputStream dataOutputStream = new DataOutputStream(output);
        dataOutputStream.writeUTF(nombre);
        dataOutputStream.writeUTF(hora_ingreso);
        dataOutputStream.writeUTF(hora_salida);
        dataOutputStream.writeUTF(hora_almuerzo_inicio);
        dataOutputStream.writeUTF(hora_almuerzo_fin);

        // Leer respuesta del servidor
        DataInputStream dataInputStream = new DataInputStream(input);
        String respuesta = dataInputStream.readUTF();
        Cliente.close();
        return respuesta;
    }
}
