public class BotonPiso extends Boton {

public BotonPiso(Ascensor ascensor, int pisoDestino) {
        super(ascensor, pisoDestino);
    }

    @Override
    public void presionar() {
        if (activo) {
            System.out.println("Botón en el PISO presionado - Piso " + pisoDestino);
            ascensor.solicitarPiso(pisoDestino);
            iluminar();
        }
    }
}