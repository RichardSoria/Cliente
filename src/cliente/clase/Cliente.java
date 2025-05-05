package cliente.clase;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Cliente {
    public String sendNumbers(String IP, int port, int numero1, int numero2, String operacion) {

        String respuesta = "";

        try{
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName(IP);

            // Convertir los números a cadena y enviarlos
            String mensaje = numero1 + "," + numero2 + "," + operacion;
            byte[] buffer = mensaje.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(packet);
            System.out.println("Mensaje enviado: " + mensaje);
            // Esperar respuesta del servidor
            byte[] bufferRespuesta = new byte[1024];
            DatagramPacket respuestaPacket = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
            socket.receive(respuestaPacket);
            respuesta = new String(respuestaPacket.getData(), 0, respuestaPacket.getLength());
            System.out.println("Respuesta del servidor: " + respuesta);

        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return respuesta;
    }
}
