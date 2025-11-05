import java.util.Arrays;

public class Impresion {
    private String color;
    private Foto [] foto;

    public Impresion(String color, Foto[] foto){
        this.color = color;
        this.foto = foto;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Foto[] getFoto() {
        return foto;
    }
    public void setFoto(Foto[] foto) {
        this.foto = foto;
    }
    @Override
    public String toString() {
        return "Impresion [color=" + color + ", foto=" + Arrays.toString(foto) + "]";
    }
}
