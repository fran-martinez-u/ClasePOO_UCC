package ELEVADOR;

public class Boton {
    private boolean iluminado;
    private boolean activo;
    private Ascensor ascensor;
    private int pisoDestino;

    // Solicitar piso al ascensor
    public Boton(Ascensor ascensor, int pisoDestino) {
        this.iluminado = false;
        this.activo = true;
        this.ascensor = ascensor;
        this.pisoDestino = pisoDestino;
    }

    // Presiona el botón para solicitar el piso
    public void presionar() {
        if (!activo) {
            System.out.println("Botón no funciona");
            return;
        }

        iluminar();
        System.out.println("Botón presionado - Piso " + pisoDestino);
        ascensor.solicitarPiso(pisoDestino);
    }

    public void iluminar() {
        this.iluminado = true;
    }

    public void apagar() {
        this.iluminado = false;
    }

    public void desactivar() {
        this.activo = false;
        this.iluminado = false;
    }

    public void activar() {
        this.activo = true;
    }

    public boolean estaIluminado() {
        return iluminado;
    }

    public boolean estaActivo() {
        return activo;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    @Override
    public String toString() {
        return "Botón [Activo: " + activo + ", Iluminado: " + iluminado +
                ", PisoDestino: " + pisoDestino + "]";
    }
}