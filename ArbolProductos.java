class ArbolProductos {

	public Producto raiz;

	public boolean agregar(String codigo, String nombre, double precio, int cantidad) {


		Producto existente = buscar(codigo);
		if (existente != null) {
			System.out.println("ERROR: Ya existe un producto con el código " + codigo);
			return false;
		}


		Producto nuevo = new Producto(codigo, nombre, precio, cantidad);
		raiz = insertarRec(raiz, nuevo);

		System.out.println("✔ Producto agregado correctamente.");
		return true;
	}

	private Producto insertarRec(Producto nodo, Producto nuevo) {
		if (nodo == null) return nuevo;

		int cmp = nuevo.codigo.compareToIgnoreCase(nodo.codigo);

		if (cmp < 0) nodo.izquierda = insertarRec(nodo.izquierda, nuevo);
		else if (cmp > 0) nodo.derecha = insertarRec(nodo.derecha, nuevo);
		else nodo.cantidad += nuevo.cantidad;

		return nodo;
	}

	public Producto buscar(String codigo) {
		return buscarRec(raiz, codigo);
	}

	private Producto buscarRec(Producto nodo, String codigo) {
		if (nodo == null) return null;

		int cmp = codigo.compareToIgnoreCase(nodo.codigo);

		if (cmp == 0) return nodo;
		if (cmp < 0) return buscarRec(nodo.izquierda, codigo);

		return buscarRec(nodo.derecha, codigo);
	}

	public void mostrar() {
		if (raiz == null) {
			System.out.println("No hay productos registrados.");
			return;
		}

		System.out.println("\n--- INVENTARIO DE ELECTRODOMÉSTICOS ---");
		mostrarInorden(raiz);
	}

	private void mostrarInorden(Producto nodo) {
		if (nodo == null) return;
		mostrarInorden(nodo.izquierda);
		System.out.println("Código: " + nodo.codigo +
						   " | " + nodo.nombre +
						   " | Precio: $" + nodo.precio +
						   " | Cantidad: " + nodo.cantidad);
		mostrarInorden(nodo.derecha);
	}

	public boolean modificar(String codigo, String nuevoNombre, double nuevoPrecio, int nuevaCantidad) {
		Producto p = buscar(codigo);

		if (p == null) {
			System.out.println("❌ No existe un producto con ese código.");
			return false;
		}

		p.nombre = nuevoNombre;
		p.precio = nuevoPrecio;
		p.cantidad = nuevaCantidad;

		System.out.println("✔ Producto modificado correctamente.");
		return true;
	}

	public boolean eliminar(String codigo) {
		if (buscar(codigo) == null) {
			System.out.println("❌ No existe un producto con ese código.");
			return false;
		}

		raiz = eliminarRec(raiz, codigo);
		System.out.println("✔ Producto eliminado correctamente.");
		return true;
	}
	private Producto eliminarRec(Producto nodo, String codigo) {
		if (nodo == null) return null;

		int cmp = codigo.compareToIgnoreCase(nodo.codigo);

		if (cmp < 0) {
			nodo.izquierda = eliminarRec(nodo.izquierda, codigo);
		} else if (cmp > 0) {
			nodo.derecha = eliminarRec(nodo.derecha, codigo);
		} else {

			// CASO 1: Sin hijos
			if (nodo.izquierda == null && nodo.derecha == null) {
				return null;
			}

			// CASO 2: Un solo hijo
			if (nodo.izquierda == null) return nodo.derecha;
			if (nodo.derecha == null) return nodo.izquierda;

			// CASO 3: Dos hijos → buscar sucesor
			Producto sucesor = buscarMin(nodo.derecha);

			nodo.codigo = sucesor.codigo;
			nodo.nombre = sucesor.nombre;
			nodo.precio = sucesor.precio;
			nodo.cantidad = sucesor.cantidad;

			nodo.derecha = eliminarRec(nodo.derecha, sucesor.codigo);
		}

		return nodo;
	}
	private Producto buscarMin(Producto nodo) {
		while (nodo.izquierda != null) {
			nodo = nodo.izquierda;
		}
		return nodo;
	}
}