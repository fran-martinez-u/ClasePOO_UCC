package ELEVADOR;

public class BotonAscensor extends Boton {
    private int numeroPiso;

    public BotonAscensor(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void solicitar() {
        System.out.println("Piso " + numeroPiso + " seleccionado");
        presionar();
    }

    @Override
    public String toString() {
        return "BotonAscensor [Piso= " + numeroPiso + ", iluminado = " + iluminado + "]";
    }
}