package MVC;

import MVC.Modelo.Producto;
import MVC.Modelo.Usuario;

public class Vista {
    ///MENUS
    public void menuPrincipalAdmin(){
        System.out.println("1. Gestionar productos");
        System.out.println("2. Gestionar usuarios");
        System.out.println("3. Gestionar carrito");
        System.out.println("4. Cerrar pedido");
        System.out.println("5. Consultar historial de pedidos");
        System.out.println("6. Salir de la aplicación");
    }

    public void menuPrincipalUser(){
        System.out.println("1. Gestionar carrito");
        System.out.println("2. Cerrar pedido");
        System.out.println("3. Salir de la aplicación");
    }


    public void menuGestionProductos(){
        System.out.println("1. Dar de alta un producto");
        System.out.println("2. Dar de baja un producto");
        System.out.println("3. Listar productos");
        System.out.println("4. Busquedad por categoría/precio");
    }

    public void menuGestionUsuarios(){
        System.out.println("1. Dar de alta un usuario");
        System.out.println("2. Dar de baja un usuario");
        System.out.println("3. Listar usuarios activos");
    }

    public void menuGestionCarrito(){
        System.out.println("1. Añadir producto al carrito");
        System.out.println("2. Quitar productor del carrito");
        System.out.println("3. Ver total");
    }


    public void mostrarCredencialesLogin(Usuario user){System.out.println("Te has logeado con: "+ user.getNombre() + " - " + user.getEmail());}

    public void pedirNombreUsuario(){
        System.out.println("Escribe el nombre del usuario");
    }

    public void pedirPasswUsuario(){System.out.println("Escribe la contraseña del usuario");}

    public void pedirEmailUsuario(){
        System.out.println("Escribe el email del usuario");
    }

    public void pedirProductoPorSeleccionar(){System.out.println("¿Qué producto quieres añadir?");}

    public void pedirCantidadPorComprar(){System.out.println("¿Cuántos quieres comprar?");}

    public void pedirRolUsuario(){System.out.println("¿Qué rol tendrá el usuario?" +
            "1 - admin" +
            "2 - normal");}

    public void elegirIDUsuario(){
        System.out.println("Elige el id del usuario:");
    }

    public void elegirTipoProducto(){
        System.out.println("Elige que tipo de producto quieres dar de alta:");
        System.out.println("1. Producto digital");
        System.out.println("2. Producto fisico");
    }

    public void pedirNombreProducto(){
        System.out.println("Escribe el nombre del producto");
    }
    public void pedirPrecioProducto(){System.out.println("Escribe el precio del producto");}
    public void pedirStockProducto(){System.out.println("Escribe el stock del producto");}
    public void pedirCategoria(){System.out.println("Escribe la categoría del artículo. (HOGAR/LIMPIEZA/ALIMENTACION/OCIO/TECNOLOGIA/OTROS)");}

    public void pedirPesoProductoFisico(){System.out.println("Escribe el peso del producto físico");}
    public void pedirGastosEnvioProductoFisico(){System.out.println("Escribe los gastos de envíos del producto físico");}

    public void pedirTamanoDescargaProductoDigital(){System.out.println("Escribe el tamano de descarga del producto digital");}
    public void pedirLicenciaProductoDigital(){System.out.println("Escribe la licencia del producto digital");}

    public void mensajeFiltrarPrecio(){System.out.println("Se va a filtrar por precio");}
    public void mensajeFiltrarCategoria(){System.out.println("Se va a filtrar por categoría");}

    public void errorSeleccionarProducto(){System.out.println("No se ha reconocido el tipo de producto");}

    public void errorSeleccion(){System.out.println("No se ha reconocido la opción");}

    public void errorConversionANumero(){System.out.println("El valor introducido no puede ser una cadena");}

    public void errorCarritoVacio(){System.out.println("No puedes cerrar el pedido si no añades nada al carrito");}

    public void errorNoHayStock(Producto producto){System.out.println("No Hay suficiente stock de " + producto.getNombre());}

    public void preguntarIDPorRetirarCarrito(){System.out.println("Escribe el ID del producto que quieras retirar del carrito");}
}
