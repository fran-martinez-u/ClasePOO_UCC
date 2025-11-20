package ELEVADOR;

public class Puerta {
    private boolean abierta = false;

    public void abrir() {
        if (!abierta) {
            abierta = true;
            System.out.println("Puerta abierta");
        }
    }

    // Cierra la puerta
    public void cerrar() {
        if (abierta) {
            abierta = false;
            System.out.println("Puerta cerrada");
        }
    }

    public boolean isAbierta() {
        return abierta;
    }
    
    @Override
    public String toString() {
        return "Puerta [abierta=" + abierta + "]";
    }
}