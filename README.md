# Sistema de Inventario y Ventas con ABB

## 1. Descripción del problema

El sistema tiene como objetivo administrar el inventario y las ventas de una tienda de electrodomésticos utilizando un **Árbol Binario de Búsqueda (ABB)**.  

Funciones principales:  
- Registrar, consultar, modificar y eliminar productos.  
- Realizar ventas y descontar stock automáticamente.  
- Mantener historial de ventas.  
- Guardar y cargar información desde archivos de texto (`productos.txt` y `ventas.txt`).  

El uso del ABB garantiza búsquedas rápidas, orden automático y manejo eficiente de los datos.

---

## 2. Requerimientos funcionales

| #  | Función              | Descripción                                                                 |
|----|---------------------|-----------------------------------------------------------------------------|
| 1  | Agregar producto    | Insertar un nuevo nodo en el ABB si el código no existe.                     |
| 2  | Buscar producto     | Ubicar un producto en el árbol mediante su código.                           |
| 3  | Modificar producto  | Cambiar nombre, precio y cantidad de un producto existente.                  |
| 4  | Eliminar producto   | Borrar un nodo del ABB usando su código.                                     |
| 5  | Mostrar inventario  | Recorrer el árbol en orden ascendente (inorden).                             |
| 6  | Registrar venta     | Realizar ventas con varios productos y descontar stock.                      |
| 7  | Guardar inventario  | Escribir el árbol en `productos.txt`.                                        |
| 8  | Cargar inventario   | Construir el árbol desde `productos.txt`.                                     |
| 9  | Guardar ventas      | Registrar cada venta en `ventas.txt`.                                         |
| 10 | Mostrar historial   | Visualizar todas las ventas registradas.                                      |

---

## 3. Entradas del sistema

| Entrada                         | Descripción                                              |
|---------------------------------|----------------------------------------------------------|
| Código del producto             | Identificador único del producto                         |
| Nombre del producto             | Nombre del producto                                      |
| Precio                          | Precio unitario del producto                              |
| Cantidad                        | Stock disponible del producto                              |
| Datos del cliente               | Nombre, teléfono e identificación                        |
| Productos a vender              | Códigos y cantidades de productos a vender              |
| Archivo `productos.txt`         | Para cargar inventario inicial                            |
| Archivo `ventas.txt`            | Para cargar historial de ventas                           |

---

## 4. Salidas del sistema

| Salida                           | Descripción                                           |
|---------------------------------|-------------------------------------------------------|
| Mensajes de confirmación o error | Indica si la operación fue exitosa o fallida         |
| Inventario ordenado              | Lista de productos ordenados por código             |
| Datos del producto               | Información del producto buscado o modificado       |
| Confirmación de eliminación      | Mensaje que confirma que el producto fue eliminado  |
| Detalle de ventas                | Registro completo de cada venta                     |
| Archivo `productos.txt`          | Inventario actualizado                                |
| Archivo `ventas.txt`             | Historial de ventas actualizado                        |
| Historial en pantalla            | Visualización de todas las ventas realizadas        |
