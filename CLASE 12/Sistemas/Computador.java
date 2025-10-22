package Sistemas;

public class Computador extends SitemaOperativo {
    private String marca;
    private int modelo;

    public Computador(String sofware, int version, String marca, int modelo) {
        super(sofware, version);
        this.marca = marca;
        this.modelo = modelo;
    }

        @Override
        public String mostrarInfo() {
            return "Computador - " + marca + 
                               " " + modelo + 
                               ", SO" + sofware + 
                               " " + version;


    
    }
}