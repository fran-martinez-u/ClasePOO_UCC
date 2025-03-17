public class Estudiante {
    //Atributos
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String facultad;

    // Constructor de la clase    Permite inicializar la clase
    public Estudiante(int id, string nombre, string apellido, int edad, string facultad){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.facultad = facultad;
    }


    //Metodos get y set / getter and setter
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(int nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return Apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public String getFacultad(){
        return facultad;
    }

    public void setFacultad(String facultad){
        this.facultad = facultad;



    //Métodos
    // Void no retorna
    public void matricularCursos(String curso){
        System.out.println("Curso: " + curso + " Matriculado!!.");
    }
    
    public String verificarCreditos(int creditos){
        String cad = "";
        if(creditos < 10){
            cad = "No puede matricular menos de 10 créditos";
        }else{
            cad = "Sus créditos cumplen con lo requerido";
        }
        return cad;
        
    }

     public String toString() {
         return "Estudiante { id:" + id +
                 " nombre:" + nombre +
                 " apellido:" + apellido +
                 " edad:" + edad +
                 " facultad:" + facultad + "}";

    }
}

