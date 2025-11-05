public class Cliente{
     
    private String cedula;
    private String nombre;


    public Cliente(String cedula, String nombre){
        this.cedula = cedula;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente [cedula=" + cedula + ", nombre=" + nombre + "]";
    }

    

}