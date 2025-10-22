package Banco;

public class DemoBanco {
    public static void main(String[] args) {
        Cuenta c1 = new Cuenta(1000);
        Cuenta c2 = new Cuenta(500);
        c1.retirar(100);
        c2.retirar(600);
        c1.mostrarSaldo();
        c2.mostrarSaldo();
    }
}
