public class Boton {
    protected boolean iluminado;
    protected boolean activo;
    protected Ascensor ascensor;
    protected int pisoDestino;

    public Boton(Ascensor ascensor, int pisoDestino) {
        this.ascensor = ascensor;
        this.pisoDestino = pisoDestino;
        this.activo = true;
    }

    public void presionar() {
        if (activo) {
            System.out.println("Botón presionado - Piso " + pisoDestino);
            ascensor.solicitarPiso(pisoDestino);
            iluminar();
        }
    }

    public void iluminar() { iluminado = true; }
    public void apagar() { iluminado = false; }
    public void activar() { activo = true; }
    public void desactivar() { activo = false; }

    public boolean estaIluminado() { return iluminado; }
    public boolean estaActivo() { return activo; }
    public int getPisoDestino() { return pisoDestino; }

    @Override
    public String toString() {
        return "Botón hacia piso " + pisoDestino +
               " [iluminado=" + iluminado + ", activo=" + activo + "]";
    }
}