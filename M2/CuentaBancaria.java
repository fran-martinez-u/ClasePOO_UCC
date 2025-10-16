public class CuentaBancaria {
    
    /* 
    
       1. La encapsulación protege los datos internos de la clase y controlar su acceso
          evita modificaciones indebidas.

       2. Un constructor inicializa el objeto al momento de crearlo.
          El método define acciones que el objeto puede realizar después de creado.

       3. Los atributos son privados para evitar acceso directo desde fuera de la clase 
          y permitir validaciones.

       4. Getters y setters permiten acceder y modificar atributos de forma controlada
          o la solicitud del programador.

       5. Falso, un método setter sí debe validar los datos que recibe,
          sin validación, se podrían asignar valores incorrectos que dañen el estado del objeto.

    */
    
    private String titular;
    private String numeroCuenta;
    private double saldo; // >= 0

    
    public CuentaBancaria() {
        this("Sin titular", "000000", 0.0);
    }

    public CuentaBancaria(String titular, String numeroCuenta, double saldo) {
        // Validación del titular
        this.titular = (titular != null && !titular.isEmpty()) ? titular : "Sin Titular";

        // Validación del número de cuenta
        this.numeroCuenta = (numeroCuenta != null && !numeroCuenta.isEmpty()) ? numeroCuenta : "000000";

        // Validación del saldo
        this.saldo = (saldo >= 0.0) ? saldo : 0.0;
    }

    // Getters
    public String getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    // Setters
    public void setTitular(String titular) {
        if (titular != null && !titular.isEmpty()) {
            this.titular = titular;
        }
    }

    public void setNumeroCuenta(String numeroCuenta) {
        if (numeroCuenta != null && !numeroCuenta.isEmpty()) {
            this.numeroCuenta = numeroCuenta;
        }
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0.0) {
            this.saldo = saldo;
        }
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        } else {
            System.out.println("Monto inválido para depósito.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }

    public String toString() {
        return "Titular: " + titular + ", Cuenta: " + numeroCuenta + ", Saldo: $" + saldo;
    }
}