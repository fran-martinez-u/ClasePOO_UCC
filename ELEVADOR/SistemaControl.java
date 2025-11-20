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

        System.out.println("\n=== BOTONES INTERNOS DEL ASCENSOR ===");
        Boton[] botones = ascensor.getBotones();
        for (Boton boton : botones) {
            System.out.println("Botón: " + boton.toString()); // ← POLIMORFISMO
        }

        System.out.println("\n=== DISTRIBUCIÓN DE BOTONES POR PISO ===");
        for (Piso piso : pisos) {
            String botonesInfo = "Piso " + piso.getNumero() + ": ";
            if (piso.getBotonSubir() != null)
                botonesInfo += "SUBIR ";
            if (piso.getBotonBajar() != null)
                botonesInfo += "BAJAR";
            System.out.println(botonesInfo);
        }

        System.out.println("\n=== FUNCIONAMIENTO DE BOTONES INTERNOS ===");
        System.out.println("Presionando botones internos: Piso 3, 5, 2");
        for (Boton boton : botones) {
            BotonAscensor botonAscensor = (BotonAscensor) boton;
            if (botonAscensor.getNumeroPiso() == 3 ||
                    botonAscensor.getNumeroPiso() == 5 ||
                    botonAscensor.getNumeroPiso() == 2) {
                botonAscensor.solicitar();
            }
        }

        System.out.println("\n=== FUNCIONAMIENTO DE BOTONES EXTERNOS ===");
        System.out.println("Desde PISO 1: solicitar SUBIR");
        pisos[0].solicitarSubir();
        System.out.println("Desde PISO 4: solicitar BAJAR");
        pisos[3].solicitarBajar();

        System.out.println("\n=== RESTRICCIONES DE BOTONES ===");
        System.out.println("Piso 1 intentando BAJAR (debe fallar):");
        pisos[0].solicitarBajar();
        System.out.println("Piso 5 intentando SUBIR (debe fallar):");
        pisos[4].solicitarSubir();

        System.out.println("\n=== SISTEMA DE LUCES ===");
        System.out.println("Antes de presionar - Piso 3 subir: " +
                (pisos[2].getBotonSubir().estaIluminado() ? "ENCENDIDA" : "APAGADA"));
        pisos[2].solicitarSubir();
        System.out.println("Después de presionar - Piso 3 subir: " +
                (pisos[2].getBotonSubir().estaIluminado() ? "ENCENDIDA" : "APAGADA"));

        System.out.println("\n--- Ascensor llegando al piso 4 ---");
        pisos[3].ascensorLlego();
        System.out.println("Después de llegada - Piso 4 subir: " +
                (pisos[2].getBotonSubir().estaIluminado() ? "ENCENDIDA" : "APAGADA"));

        System.out.println("\nFIN DE LA SIMULACIÓN (づ￣ 3￣)づ");
    }
}