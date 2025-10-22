package Sistemas;

public class ConsultarModelo {

public static void main (String[] args) {
    SitemaOperativo celular = new Celular("Android", 11, "Samsung", 2021);
    SitemaOperativo computador = new Computador("Windows", 10, "Dell", 2020);

    System.out.println(celular.mostrarInfo());
    System.out.println(computador.mostrarInfo());
  }

}
