package ELEVADOR;

public class Puerta {
    private boolean abierta;
    // Empieza cerrada
    public Puerta() {
        this.abierta = false; 
    }

    // Abre la puerta
    public void abrir() {
        this.abierta = true;
        System.out.println("Puerta abierta");
    }

    // Cierra la puerta
    public void cerrar() {
        this.abierta = false;
        System.out.println("Puerta cerrada");
    }

    // Verifica si está abierta
    public boolean isAbierta() {
        return abierta;
    }

    // Muestra el estado de la puerta
    @Override
    public String toString() {
        return "Puerta: " + (abierta ? "Abierta" : "Cerrada");
    }
}