import java.io.*;
import java.util.Stack;

class Ventas {

    private Stack<String> historial = new Stack<>();

    public Ventas() {
        cargarHistorial();
    }

    // 🔥 CARGA VENTAS DESDE ventas.txt AL INICIAR
    private void cargarHistorial() {
        try (BufferedReader br = new BufferedReader(new FileReader("ventas.txt"))) {
            String linea;
            StringBuilder venta = new StringBuilder();

            while ((linea = br.readLine()) != null) {

                if (linea.equals("----------------------------------------")) {
                    historial.push(venta.toString());
                    venta = new StringBuilder();
                } else {
                    venta.append(linea).append("\n");
                }
            }

        } catch (IOException e) {
            System.out.println("No hay ventas previas guardadas.");
        }
    }

    // 🔥 REGISTRA UNA VENTA NUEVA
    public void venderProductos(ArbolProductos arbol, BufferedReader entrada) throws IOException {

        System.out.print("Nombre del cliente: ");
        String cliente = entrada.readLine();

        System.out.print("Teléfono: ");
        String telefono = entrada.readLine();

        System.out.print("DNI: ");
        String dni = entrada.readLine();

        double total = 0;
        StringBuilder venta = new StringBuilder();

        venta.append("Cliente: ").append(cliente)
             .append(" | Tel: ").append(telefono)
             .append(" | DNI: ").append(dni)
             .append("\n--- Detalle de compra ---\n");

        while (true) {

            arbol.mostrar();
            System.out.print("Código del producto (o 'fin'): ");
            String codigo = entrada.readLine();

            if (codigo.equalsIgnoreCase("fin")) break;

            Producto p = arbol.buscar(codigo);

            if (p == null) {
                System.out.println("❌ Producto no encontrado.");
                continue;
            }

            System.out.print("¿Cuántas unidades desea?: ");
            int cant = Integer.parseInt(entrada.readLine());

            if (cant <= 0 || cant > p.cantidad) {
                System.out.println("Cantidad inválida.");
                continue;
            }

            p.cantidad -= cant;

            double subtotal = p.precio * cant;
            total += subtotal;

            venta.append(p.nombre).append(" x").append(cant)
                 .append(" - $").append(subtotal).append("\n");
        }

        if (total > 0) {
            venta.append("TOTAL: $").append(total).append("\n");
            venta.append("Fecha: ").append(java.time.LocalDateTime.now()).append("\n");

            historial.push(venta.toString());
            ArchivoVentas.guardarVenta(venta.toString());

            System.out.println("\nVENTA REGISTRADA:\n" + venta);
        }
    }

    // 🔥 MOSTRAR HISTORIAL
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }

        System.out.println("\n--- HISTORIAL DE VENTAS ---\n");

        for (int i = historial.size() - 1; i >= 0; i--) {
            System.out.println(historial.get(i));
            System.out.println("----------------------------------------");
        }
    }
}