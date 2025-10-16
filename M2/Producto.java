public class Producto {

    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    // Constructor por defecto
    public Producto() {
        codigo = "000";
        descripcion = "Sin descripción";
        cantidad = 1;
        precioUnitario = 0.0;
    }

    // Constructor parametrizado
    public Producto(String codigo, String descripcion, int cantidad, double precioUnitario) {
        this.codigo = (codigo != null && !codigo.isEmpty()) ? codigo : "000";
        this.descripcion = (descripcion != null && !descripcion.isEmpty()) ? descripcion : "Sin descripción";
        this.cantidad = (cantidad >= 1) ? cantidad : 1;
        this.precioUnitario = (precioUnitario >= 0.0) ? precioUnitario : 0.0;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    // Setters
    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.isEmpty()) {
            this.codigo = codigo;
        }
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.isEmpty()) {
            this.descripcion = descripcion;
        }
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 1) {
            this.cantidad = cantidad;
        }
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario >= 0.0) {
            this.precioUnitario = precioUnitario;
        }
    }

    // Método calcularSubtotal
    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    // Método aplicarDescuento
    public double aplicarDescuento(double porcentaje) {
        if (porcentaje >= 0 && porcentaje <= 50) {
            double descuento = calcularSubtotal() * (porcentaje / 100);
            return calcularSubtotal() - descuento;
        } else {
            System.out.println("Porcentaje inválido.");
            return calcularSubtotal();
        }
    }

    // Método incrementarCantidad
    public void incrementarCantidad(int valor) {
        if (valor > 0) {
            cantidad += valor;
        }
    }

    // Método toString
    public String toString() {
        return "Código: " + codigo + ", Descripción: " + descripcion +
               ", Cantidad: " + cantidad + ", Precio unitario: $" + precioUnitario;
    }
}