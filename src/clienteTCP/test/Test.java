package clienteTCP.test;

import clienteTCP.clase.Cliente;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
       String nombre;
       String hora_ingreso;
       String hora_salida;
       String hora_almuerzo_inicio;
       String hora_almuerzo_fin;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese la hora de ingreso: ");
        hora_ingreso = scanner.nextLine();
        System.out.println("Ingrese la hora de salida: ");
        hora_salida = scanner.nextLine();
        System.out.println("Ingrese la hora de almuerzo inicio: ");
        hora_almuerzo_inicio = scanner.nextLine();
        System.out.println("Ingrese la hora de almuerzo fin: ");
        hora_almuerzo_fin = scanner.nextLine();
        String respuesta = Cliente.enviarRegistro(nombre, hora_ingreso, hora_salida, hora_almuerzo_inicio, hora_almuerzo_fin);
        System.out.println("Respuesta del servidor: " + respuesta);
    }
}
