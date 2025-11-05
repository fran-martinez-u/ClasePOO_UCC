public class Camara {
    private String modelo;
    private String marca;

    public Camara(String modelo, String marca){
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Camara [modelo=" + modelo + ", marca=" + marca + "]";
    }
}
