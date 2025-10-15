public class CuentaBancaria {

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
}
