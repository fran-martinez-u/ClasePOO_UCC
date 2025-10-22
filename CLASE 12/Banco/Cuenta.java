package Banco;

public class Cuenta {
    protected double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= saldo)
            saldo -= monto;
    }


    public void mostrarSaldo() {
        System.out.println(" Saldo actual : $" + saldo);
    }


public class CuentaAhorros extends Cuenta {
    public CuentaAhorros(double saldo) {
        super(saldo);
    }

    public void aplicarInteres() {
        saldo += saldo * 0.02;
    }

    @Override
    public void mostrarSaldo() {
        System.out.println(" Cuenta de ahorros Saldo : $" +
                saldo);
    }
}

public class CuentaCorriente extends Cuenta {
    public CuentaCorriente(double saldo) {
        super(saldo);
    }

    @Override
    public void retirar(double monto) {
        if (saldo - monto >= -200)
            saldo -= monto;
        else
            System.out.println(" Sobregiro no permitido ! ");
    }

    @Override
    public void mostrarSaldo() {
        System.out.println(" Cuenta corriente Saldo : $" +
                saldo);
    }

}

}
