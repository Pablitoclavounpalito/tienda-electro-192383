import java.io.*;

class Archivo {

	public static void guardar(ArbolProductos arbol) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("productos.txt"))) {
			escribirInorden(arbol.raiz, writer);
			System.out.println("Inventario guardado correctamente.");
		} catch (IOException e) {
			System.out.println("Error al guardar archivo: " + e.getMessage());
		}
	}

	private static void escribirInorden(Producto nodo, PrintWriter writer) {
		if (nodo == null) return;

		escribirInorden(nodo.izquierda, writer);

		writer.println(
			nodo.codigo + "," +
			nodo.nombre + "," +
			nodo.precio + "," +
			nodo.cantidad
		);

		escribirInorden(nodo.derecha, writer);
	}

	public static ArbolProductos cargar() {
		ArbolProductos arbol = new ArbolProductos();

		try (BufferedReader br = new BufferedReader(new FileReader("productos.txt"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] p = linea.split(",");
				arbol.agregar(
					p[0], p[1],
					Double.parseDouble(p[2]),
					Integer.parseInt(p[3])
				);
			}
		} catch (IOException e) {
			System.out.println("Inventario vacío.");
		}

		return arbol;
	}
}