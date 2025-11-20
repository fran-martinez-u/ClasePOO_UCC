package ELEVADOR;

public class Piso {
    private int numero;
    private Boton botonSubir;
    private Boton botonBajar;
    private Ascensor ascensor;

    public Piso(int numero, int totalPisos, Ascensor ascensor) {
        this.numero = numero;
        this.ascensor = ascensor;

        if (numero != totalPisos) {
            this.botonSubir = new BotonPiso("subir");
        }
        if (numero != 1) {
            this.botonBajar = new BotonPiso("bajar");
        }
    }
    // Solicita subir 
    public void solicitarSubir() {
        if (botonSubir != null) {
            botonSubir.solicitar(); //
            ascensor.solicitarPiso(numero);
        } else {
            System.out.println("No se puede SUBIR desde el piso " + numero + " (último piso)");
        }
    }
    // Solicita bajar
    public void solicitarBajar() {
        if (botonBajar != null) {
            botonBajar.solicitar();
            ascensor.solicitarPiso(numero);
        } else {
            System.out.println("No se puede BAJAR desde el piso " + numero + " (primer piso)");
        }
    }

    public void ascensorLlego() {
        if (botonSubir != null)
            botonSubir.apagar();
        if (botonBajar != null)
            botonBajar.apagar();
    }
    // Getters
    public int getNumero() {
        return numero;
    }

    public Boton getBotonSubir() {
        return botonSubir;
    }

    public Boton getBotonBajar() {
        return botonBajar;
    }
}