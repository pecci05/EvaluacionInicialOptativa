# FernanEvents2 ECO

### 🚀 Función
Este programa permite gestionar los productos y usuarios de una tienda con diversidad de tipos de productos. Permite dejar en un log los registros de las compras.
*Realizado con Java*

--- ❌ No guarda qué usuario ha realizado la compra, debido a que no tenemos persistencia de los usuarios

### 🔳 Diseño
 - ## MVC: Programa estructurado con la arquitectura Modelo-Vista-Controlador.
   ```text
   src/
   └── main/
        └── java/
              ├── Files/
              │   └── registrosPedidos.csv     # Archivo CSV para la persistencia/registro de pedidos
              └── MVC/
                   ├── Modelo/                  # Clases del modelo de dominio y lógica de negocio
                   │   ├── Carrito.java
                   │   ├── Categorias.java      # Enum de categorías de productos
                   │   ├── GestionProducto.java
                   │   ├── GestionUsuarios.java
                   │   ├── HistorialPedidos.java
                   │   ├── Pedido.java
                   │   ├── Producto.java
                   │   ├── ProductoDigital.java # Herencia de Producto (digital)
                   │   ├── ProductoFisico.java  # Herencia de Producto (físico)
                   │   └── Usuario.java
                   ├── Controlador.java         # Controlador para la mediación entre Vista y Modelo
                   ├── Main.java                # Punto de entrada de la aplicación
                   └── Vista.java               # Interfaz de usuario / presentación
   ```


### ➰ Extras elegidos

--- ⚫ Categorías que ordenan a los productos
--- ⚫ Persistencia en el historial de pedidos
--- ⚫ Sistema de roles


### Cómo ejecutarlo
-- Desde IDE
 1. Intalar JDK
 2. Importar el proyecto al IDE
 3. Ejecuta el Main.java

-- Desde .jar
 1. Instalar JDK
 2. Acceder al directorio ".\Evaluacion_inicial_OPT\out\artifacts\Evaluacion_inicial_OPT_jar"
 3. Abrir CMD
 4. ejecutar el comando "java -jar Evaluacion_inicial_OPT.jar"





