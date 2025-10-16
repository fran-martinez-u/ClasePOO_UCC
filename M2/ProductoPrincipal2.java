public class ProductoPrincipal2 {
    public static void main(String[] args) {
        // Crear producto válido
        Producto producto1 = new Producto("A123", "Mouse óptico", 2, 25.0);
        System.out.println("Producto original:");
        System.out.println(producto1);

        // Calcular subtotal y aplicar descuento inicial
        double subtotalInicial = producto1.calcularSubtotal();
        double totalConDescuentoInicial = producto1.aplicarDescuento(20); // 20% de descuento
        System.out.println("Subtotal inicial: $" + subtotalInicial);
        System.out.println("Total con 20% de descuento: $" + totalConDescuentoInicial);

        // Incrementar cantidad
        producto1.incrementarCantidad(3); // ahora cantidad = 5
        System.out.println("\nDespués de incrementar cantidad:");
        System.out.println(producto1);

        // Recalcular subtotal y descuento con nueva cantidad
        double nuevoSubtotal = producto1.calcularSubtotal();
        double nuevoTotalConDescuento = producto1.aplicarDescuento(20);
        System.out.println("Nuevo subtotal: $" + nuevoSubtotal);
        System.out.println("Nuevo total con 20% de descuento: $" + nuevoTotalConDescuento);
    }
}