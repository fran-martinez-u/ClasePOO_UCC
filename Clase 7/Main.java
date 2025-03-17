public class Main {

    public static void main (String[] args) {

        //Instanciar el objeto (creaciiiion)
        Estudiante objEst1 = new Estudiante(1, "Gabriela", "Astorquiza", 15, "Ingenieria");
        Estudiante objEst2 = new Estudiante(2, "Milanesa", "Puberta", 48, "Ingenieria");

        System.out.println(objEst1);
        System.out.println(objEst2);

        //Modificar edad
        objEst1.setEdad(120);
        

        System.out.println(objEst1);
      
    }
}