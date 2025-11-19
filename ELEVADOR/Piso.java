package ELEVADOR;

public class Piso {
    private int numero;
    private int totalPisos;
    private Boton botonSubir;
    private Boton botonBajar;

    public Piso(int numero, int totalPisos, Ascensor ascensor) {
        this.numero = numero;
        this.totalPisos = totalPisos;

        // Crea botones de subir y bajar
        this.botonSubir = new Boton(ascensor, numero);
        this.botonBajar = new Boton(ascensor, numero);

        // Aplicar restricciones de botones según el piso
        if (numero == 1) {
            // Primer piso: no puede bajar
            botonBajar.desactivar();
        } else if (numero == totalPisos) {
            // Último piso: no puede subir
            botonSubir.desactivar();
        }
    }

    // Solicita subir 
    public void solicitarSubir() {
        botonSubir.presionar(); 
    }

    // Solicita bajar desde este piso
    public void solicitarBajar() {
        botonBajar.presionar(); 
    }

    // Apaga las luces cuando llega el ascensor
    public void ascensorLlego() {
        botonSubir.apagar();
        botonBajar.apagar();
    }

    // Getters
    public boolean tieneBotonSubir() {
        return botonSubir.estaActivo();
    }

    public boolean tieneBotonBajar() {
        return botonBajar.estaActivo();
    }

    public int getNumero() {
        return numero;
    }

    public Boton getBotonSubir() {
        return botonSubir;
    }

    public Boton getBotonBajar() {
        return botonBajar;
    }

    // Muestra información del piso
    @Override
    public String toString() {
        return "Piso " + numero + " de " + totalPisos + " pisos totales - " +
                "Subir: " + (tieneBotonSubir() ? "SÍ" : "NO") +
                " | Bajar: " + (tieneBotonBajar() ? "SÍ" : "NO");
    }
}