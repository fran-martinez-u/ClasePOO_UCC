public class Foto {
    
    private String fichero;

    public Foto(String fichero){
        this.fichero = fichero;
    }
    public static void main(String[] args) {
        Foto foto1 = new Foto("foto1.jpg");
        System.out.println("Fichero de la foto: " + foto1.fichero);
    }
    @Override
    public String toString() {
        return "Foto [fichero=" + fichero + "]";
    }
}
