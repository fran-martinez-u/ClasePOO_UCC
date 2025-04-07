package Extra;

import java.util.Scanner;

public class Parqueadero {
    private static final int MAX_PUESTOS = 20;
    private static Moto[] puestos = new Moto[MAX_PUESTOS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar Moto");
            System.out.println("2. Cobrar Tarifa");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Validar que la entrada sea numérica
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarMoto(scanner);
                    break;
                case 2:
                    cobrarTarifa(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void registrarMoto(Scanner scanner) {
        System.out.print("Ingrese el puesto deseado (0-" + (MAX_PUESTOS - 1) + "): ");
        int puesto = scanner.nextInt();

        if (puesto < 0 || puesto >= MAX_PUESTOS) {
            System.out.println("Puesto inválido. Intente de nuevo.");
        } else if (puestos[puesto] != null) {
            System.out.println("El puesto está ocupado. Intente de nuevo.");
        } else {
            System.out.print("Ingrese la placa de la moto: ");
            String placa = scanner.next();
            puestos[puesto] = new Moto(placa);
            System.out.println("Moto registrada en el puesto " + puesto);
        }
    }

    private static void cobrarTarifa(Scanner scanner) {
        System.out.print("Ingrese el puesto de la moto (0-" + (MAX_PUESTOS - 1) + "): ");
        int puesto = scanner.nextInt();

        if (puesto < 0 || puesto >= MAX_PUESTOS || puestos[puesto] == null) {
            System.out.println("Puesto inválido o vacío. Intente de nuevo.");
        } else {
            Moto moto = puestos[puesto];
            System.out.print("Ingrese el tiempo de permanencia en minutos: ");
            int tiempo = scanner.nextInt();

            int tarifa = calcularTarifa(tiempo);
            System.out.println("El valor a pagar es de $" + tarifa);
            puestos[puesto] = null; // Desocupar el puesto
            System.out.println("El puesto " + puesto + " está ahora disponible.");
        }
    }

    private static int calcularTarifa(int tiempo) {
        if (tiempo <= 30) {
            return 0;
        } else if (tiempo <= 60) {
            return 800;
        } else {
            return 2000;
        }
    }
}

class Moto {
    private String placa;

    public Moto(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }
}