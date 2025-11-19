public class BotonAscensor extends Boton {

    public BotonAscensor(Ascensor ascensor, int pisoDestino) {
        super(ascensor, pisoDestino);
    }

    @Override
    public void presionar() {
        if (activo) {
            System.out.println("Botón dentro del ASCENSOR presionado - Piso " + pisoDestino);
            ascensor.solicitarPiso(pisoDestino);
            iluminar();
        }
    }
}