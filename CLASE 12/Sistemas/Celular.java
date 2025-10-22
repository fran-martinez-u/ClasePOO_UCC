package Sistemas;

public class Celular extends SitemaOperativo {
    private String marca;
    private int modelo;

    public Celular(String sofware, int version, String marca, int modelo) {
        super(sofware, version);
        this.marca = marca;
        this.modelo = modelo;
    }

        @Override
        public String mostrarInfo() {
            return "Celular - " + marca + 
                               " " + modelo + 
                               ", SO" + sofware + 
                               " " + version;
    }
}