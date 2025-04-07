public class PrecioTotal {




    public void calcularTotales() {

    }

    public void mostrarTotales () {

        calcularTotales();
        System.out.println("Total Equipaje " + totalPrecios);
        System.out.println("Total Bodega " + totalBodega);
        System.out.println("Total Cabina " + totalCabina);

    }




}

public class Equipaje() {
    // CONSTANTE
    private static final double PESO = 10.0;
    private static final double TAMANO = 4.5;
    private static final double PRECIO_BASE = 1000.0;

    // ATRIBUTOS
    private double peso;
    private double tamano;
    private double precioBase;


    // CONSTRUCTORES
    public double calcularPrecio () {
        return 0.0;
    }

    // GETTERS/SETTERS SI LLEGA A TOCAR



}

public class Bodega extends Equipaje {
    // CONSTANTES
    private static final double CAPACIDAD = 8.0;

    // CONSTRUCTORES

    // METODOS
    public double calcularPrecio () {
        // CALCULOS
        return precioFinal;
    }
}

public class Cabina extends Equipaje {
    // CONSTANTES
    private static final int TIEMPO = 8.0;

    // CONSTRUCTORES

    // METODOS
    public double calcularPrecio () {
        // CALCULOS
        return precioFinal;
    }
}