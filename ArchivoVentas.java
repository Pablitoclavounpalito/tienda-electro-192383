import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class ArchivoVentas {

    public static void guardarVenta(String contenido) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("ventas.txt", true))) {
            writer.println(contenido);
            writer.println("----------------------------------------");
        } catch (IOException e) {
            System.out.println("Error al guardar venta: " + e.getMessage());
        }
    }
}