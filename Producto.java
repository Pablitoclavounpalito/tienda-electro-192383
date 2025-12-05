class Producto {
    String codigo;
    String nombre;
    double precio;
    int cantidad;

    Producto izquierda;
    Producto derecha;

    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.izquierda = null;
        this.derecha = null;
    }

    public String toFileLine() {
        return codigo + "," + nombre + "," + precio + "," + cantidad;
    }
}