package ELEVADOR;

public class Ascensor {
    private int pisoActual;
    private String direccion; // "subiendo", "bajando", "parado"
    private Puerta puerta;
    private boolean funcionando;
    private int[] solicitudes;
    private int numSolicitudes;
    private int totalPisos;

    public Ascensor(int totalPisos) {
        this.pisoActual = 0; // Empieza desde el primer piso
        this.direccion = "parado";
        this.puerta = new Puerta();
        this.funcionando = true;
        this.totalPisos = totalPisos;
        this.solicitudes = new int[totalPisos + 1];
        this.numSolicitudes = 0;
    }

    // Se solicita un piso al ascensor
    public void solicitarPiso(int pisoDestino) {
        if (!funcionando)
            return;

        // Valida que el piso existe
        if (pisoDestino < 0 || pisoDestino > totalPisos) {
            System.out.println("Piso " + pisoDestino + " no existe");
            return;
        }

        // Evitar duplicados
        boolean existe = false;
        for (int i = 0; i < numSolicitudes; i++) {
            if (solicitudes[i] == pisoDestino) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            solicitudes[numSolicitudes] = pisoDestino;
            numSolicitudes++;
            System.out.println("Solicitud recibida: Piso " + pisoDestino);
        }

        // Definir dirección inicial si no está en movimiento
        if ("parado".equals(direccion)) {
            direccion = (pisoDestino > pisoActual) ? "subiendo" : "bajando";
        }

        ejecutarRecorrido();
    }

    // Ejecuta el recorrido de todas las solicitudes
    private void ejecutarRecorrido() {
        while (numSolicitudes > 0) {
            ordenarSolicitudes();
            int siguientePiso = solicitudes[0];
            moverAPiso(siguientePiso);

            // Elimina la solicitud procesada
            for (int i = 0; i < numSolicitudes - 1; i++) {
                solicitudes[i] = solicitudes[i + 1];
            }
            numSolicitudes--;

            // Verifica el cambio de dirección
            if (numSolicitudes > 0) {
                boolean haySolicitudesArriba = false;
                boolean haySolicitudesAbajo = false;

                for (int i = 0; i < numSolicitudes; i++) {
                    if (solicitudes[i] > pisoActual)
                        haySolicitudesArriba = true;
                    if (solicitudes[i] < pisoActual)
                        haySolicitudesAbajo = true;
                }

                if ("subiendo".equals(direccion) && !haySolicitudesArriba) {
                    direccion = "bajando";
                } else if ("bajando".equals(direccion) && !haySolicitudesAbajo) {
                    direccion = "subiendo";
                }
            }
        }
        direccion = "parado";
    }

    // Ordena solicitudes según la dirección actual (Subir o Bajar)
    private void ordenarSolicitudes() {
        for (int i = 0; i < numSolicitudes - 1; i++) {
            for (int j = i + 1; j < numSolicitudes; j++) {
                boolean intercambiar = false;
                if ("subiendo".equals(direccion)) {
                    intercambiar = solicitudes[i] > solicitudes[j];
                } else {
                    intercambiar = solicitudes[i] < solicitudes[j];
                }

                if (intercambiar) {
                    int temp = solicitudes[i];
                    solicitudes[i] = solicitudes[j];
                    solicitudes[j] = temp;
                }
            }
        }
    }

    // Mueve el ascensor a un piso específico
    private void moverAPiso(int pisoDestino) {
        System.out.println("Ascensor se mueve de " + pisoActual + " a " + pisoDestino);
        pisoActual = pisoDestino;
        detener();
    }

    // Detiene el ascensor en un piso
    public void detener() {
        System.out.println("--- Parada en piso " + pisoActual + " ---");
        puerta.abrir();
        esperar(500);
        puerta.cerrar();
    }

    // Espera un tiempo simulado
    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            
        }
    }

    // Muestra el estado del ascensor
    @Override
    public String toString() {
        return "Ascensor [Piso: " + pisoActual +
                ", Dirección: " + direccion +
                ", Puerta: " + (puerta.isAbierta() ? "Abierta" : "Cerrada") +
                ", Solicitudes: " + numSolicitudes + "]";
    }

    // Getters
    public int getPisoActual() {
        return pisoActual;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean isFuncionando() {
        return funcionando;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public int getNumSolicitudes() {
        return numSolicitudes;
    }
}