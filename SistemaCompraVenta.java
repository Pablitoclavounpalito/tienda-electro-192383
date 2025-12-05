import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class SistemaCompraVenta {

	public static void main(String[] args) throws IOException {

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		ArbolProductos arbol = Archivo.cargar();
		Ventas ventas = new Ventas();

		while (true) {

			System.out.println("\n--- SISTEMA DE ELECTRODOMÉSTICOS - ABB ---");
			System.out.println("1. Agregar producto / aumentar stock");
			System.out.println("2. Mostrar inventario");
			System.out.println("3. Registrar venta");
			System.out.println("4. Mostrar historial de ventas");
			System.out.println("5. Modificar producto");
			System.out.println("6. Eliminar producto");
			System.out.println("7. Guardar y salir");
			System.out.print("Opción: ");

			String opcion = entrada.readLine();

			switch (opcion) {

			case "1":
				System.out.print("Código: ");
				String cod = entrada.readLine();

				System.out.print("Nombre: ");
				String nom = entrada.readLine();

				System.out.print("Precio: ");
				double precio = Double.parseDouble(entrada.readLine());

				System.out.print("Cantidad: ");
				int cant = Integer.parseInt(entrada.readLine());

				boolean ok = arbol.agregar(cod, nom, precio, cant);

				if (!ok) {
					System.out.println("⚠️ No se pudo agregar el producto (código repetido).");
				}
				break;

			case "2":
				arbol.mostrar();
				break;

			case "3":
				ventas.venderProductos(arbol, entrada);
				break;

			case "4":
				ventas.mostrarHistorial();
				break;

			case "5":
				System.out.print("Ingrese código del producto a modificar: ");
				String codMod = entrada.readLine();

				Producto p = arbol.buscar(codMod);

				if (p == null) {
					System.out.println("❌ No existe producto con ese código.");
				} else {
					System.out.println("Producto encontrado: " + p.nombre);

					System.out.print("Nuevo nombre: ");
					String nuevoNombre = entrada.readLine();

					System.out.print("Nuevo precio: ");
					double nuevoPrecio = Double.parseDouble(entrada.readLine());

					System.out.print("Nueva cantidad: ");
					int nuevaCantidad = Integer.parseInt(entrada.readLine());

					arbol.modificar(codMod, nuevoNombre, nuevoPrecio, nuevaCantidad);
				}
				break;

			case "6":
				System.out.print("Ingrese el código del producto a eliminar: ");
				String codEliminar = entrada.readLine();

				boolean elim = arbol.eliminar(codEliminar);

				if (!elim) {
					System.out.println("❌ No se pudo eliminar (no existe ese código).");
				}
				break;

			case "7":
				Archivo.guardar(arbol);
				System.out.println("Inventario guardado. Saliendo...");
				return;

			default:
				System.out.println("Opción no válida.");
			}
		}
	}
}