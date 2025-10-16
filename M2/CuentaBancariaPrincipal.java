public class CuentaBancariaPrincipal {
    public static void main(String[] args) {
        // Cuenta válida
        CuentaBancaria cuenta1 = new CuentaBancaria("Ana Pérez", "123456", 500.0);
        cuenta1.depositar(200.0);   // saldo esperado: 700.0
        cuenta1.retirar(100.0);     // saldo esperado: 600.0
        System.out.println("Cuenta válida:");
        System.out.println(cuenta1);

        // Cuenta inválida (titular vacío, número corto, saldo negativo)
        CuentaBancaria cuenta2 = new CuentaBancaria("", "12", -50.0);
        cuenta2.depositar(-20.0); // no debe afectar el saldo
        cuenta2.retirar(10.0);    // no debe permitir retiro
        System.out.println("\nCuenta inválida:");
        System.out.println(cuenta2);
    }
}