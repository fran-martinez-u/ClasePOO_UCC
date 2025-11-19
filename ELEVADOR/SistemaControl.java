package ELEVADOR;

public class SistemaControl {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CONTROL DEL ASCENSOR ===\n");

        int totalPisos = 5;

        System.out.println("=== CONFIGURACIÓN INICIAL ===");

        Ascensor ascensor = new Ascensor(totalPisos);
        Piso[] pisos = new Piso[totalPisos];
        for (int i = 0; i < totalPisos; i++) {
            pisos[i] = new Piso(i + 1, totalPisos, ascensor);
        }
        System.out.println("Estado: " + ascensor.toString());

        System.out.println("\n=== BOTONES DEL ASCENSOR ===");
        Boton[] botonesAscensor = new Boton[totalPisos];
        for (int i = 0; i < totalPisos; i++) {
            botonesAscensor[i] = new Boton(ascensor, i + 1);
            System.out.println("Creado botón para piso " + (i + 1));
        }

        System.out.println("\n=== FUNCIONAMIENTO DE BOTOS AL SOLICITAR PISO ===");
        System.out.println("Presionando botones de piso: 3, 5, 2");
        botonesAscensor[2].presionar(); // Piso 3
        botonesAscensor[4].presionar(); // Piso 5
        botonesAscensor[1].presionar(); // Piso 2

        System.out.println("\n=== FUNCIONAMIENTO DE BOTONES AL SOLICITAR ASCENSOR ===");
        System.out.println("Desde PISO 1: solicitar SUBIR");
        pisos[0].solicitarSubir(); // Piso 1 quiere subir

        System.out.println("Desde PISO 4: solicitar BAJAR");
        pisos[3].solicitarBajar(); // Piso 4 quiere bajar

        System.out.println("\n=== CONFIGURACIÓN DE BOTONES ===");
        System.out.println("Piso 1 intentando BAJAR (debe fallar):");
        pisos[0].solicitarBajar(); // No debe funcionar

        System.out.println("Piso 5 intentando SUBIR (debe fallar):");
        pisos[4].solicitarSubir(); // No debe funcionar

        System.out.println("\n=== SISTEMA DE LUCES ===");
        System.out.println("Antes de presionar - Piso 3 subir: " +
                (pisos[2].getBotonSubir().estaIluminado() ? "ENCENDIDA" : "APAGADA"));
        pisos[2].solicitarSubir();
        System.out.println("Después de presionar - Piso 3 subir: " +
                (pisos[2].getBotonSubir().estaIluminado() ? "ENCENDIDA" : "APAGADA"));
        pisos[2].ascensorLlego();
        System.out.println("Después de llegada - Piso 3 subir: " +
                (pisos[2].getBotonSubir().estaIluminado() ? "ENCENDIDA" : "APAGADA"));

        System.out.println("\nFIN DE LA SIMULACIÓN (づ￣ 3￣)づ");
    }
}