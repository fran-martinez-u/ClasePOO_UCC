package ELEVADOR;

public abstract class Boton {
    protected boolean iluminado = false;
    protected boolean activo = true;

    public abstract void solicitar();

    public void presionar() {
        if (activo) {
            iluminado = true;
        }
    }

    public void apagar() {
        iluminado = false;
    }

    public boolean estaIluminado() {
        return iluminado;
    }

    public boolean estaActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Boton [iluminado=" + iluminado + ", activo=" + activo + "]";
    }
}