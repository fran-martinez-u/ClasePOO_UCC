package ELEVADOR;

public class Ascensor {
    private int pisoActual = 1; 
    private String direccion = "parado";
    private Puerta puerta = new Puerta();
    private int[] solicitudes;
    private int numSolicitudes = 0;
    private int totalPisos;
    private Boton[] botones; 

    public Ascensor(int totalPisos) {
        this.totalPisos = totalPisos;
        this.solicitudes = new int[totalPisos + 1];
        this.botones = new Boton[totalPisos]; 

        for (int i = 0; i < totalPisos; i++) {
            botones[i] = new BotonAscensor(i + 1);
        }
    }

    public void solicitarPiso(int pisoDestino) {
        if (pisoDestino < 0 || pisoDestino > totalPisos)
            return;

        // Evitar duplicados
        for (int i = 0; i < numSolicitudes; i++) {
            if (solicitudes[i] == pisoDestino)
                return;
        }

        solicitudes[numSolicitudes++] = pisoDestino;

        if ("parado".equals(direccion)) {
            direccion = (pisoDestino > pisoActual) ? "subiendo" : "bajando";
        }

        ejecutarRecorrido();
    }

    public void solicitarPisoDesdeBoton(int pisoDestino) {
        System.out.println("Solicitud de piso : Piso " + pisoDestino);
        solicitarPiso(pisoDestino);
    }

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
        pisoDestino = pisoActual;
        detener();
    }

    private void detener() {
        System.out.println("--- Parada en piso " + pisoActual + " ---");
        puerta.abrir();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        puerta.cerrar();
    }

    public void usarBoton(int indiceBoton) {
        if (indiceBoton >= 0 && indiceBoton < botones.length) {
            botones[indiceBoton].solicitar();
        }
    }

    public Boton[] getBotones() {
        return botones;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumSolicitudes() {
        return numSolicitudes;
    }

    public Puerta getPuerta() {
        return puerta;
    } 
}