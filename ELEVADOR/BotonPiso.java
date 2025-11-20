package ELEVADOR;

public class BotonPiso extends Boton {
    private String direccion;

    public BotonPiso(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void solicitar() {
        System.out.println("Solicitud de " + direccion.toUpperCase() + " desde pasillo");
        presionar();
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "BotonPiso [direccion=" + direccion + ", iluminado=" + iluminado + "]";
    }
}