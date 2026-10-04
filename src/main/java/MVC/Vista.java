package MVC;

import MVC.Modelo.Producto;
import MVC.Modelo.Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Vista {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

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
        System.out.println(ANSI_CYAN + "Escribe el nombre del usuario" + ANSI_RESET);
    }

    public void pedirPasswUsuario(){System.out.println(ANSI_CYAN + "Escribe la contraseña del usuario" + ANSI_RESET);}

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
        System.out.println(ANSI_CYAN + "Escribe el nombre del producto" + ANSI_RESET);
    }
    public void pedirPrecioProducto(){System.out.println(ANSI_CYAN + "Escribe el precio del producto" + ANSI_RESET);}
    public void pedirStockProducto(){System.out.println(ANSI_CYAN + "Escribe el stock del producto" + ANSI_RESET);}
    public void pedirCategoria(){System.out.println(ANSI_CYAN + "Escribe la categoría del artículo. (HOGAR/LIMPIEZA/ALIMENTACION/OCIO/TECNOLOGIA/OTROS)" + ANSI_RESET);}

    public void pedirPesoProductoFisico(){System.out.println(ANSI_CYAN + "Escribe el peso del producto físico" + ANSI_RESET);}
    public void pedirGastosEnvioProductoFisico(){System.out.println(ANSI_CYAN + "Escribe los gastos de envíos del producto físico" + ANSI_RESET);}

    public void pedirTamanoDescargaProductoDigital(){System.out.println( ANSI_CYAN + "Escribe el tamano de descarga del producto digital" + ANSI_RESET);}
    public void pedirLicenciaProductoDigital(){System.out.println(ANSI_CYAN + "Escribe la licencia del producto digital" + ANSI_RESET);}

    public void mensajeFiltrarPrecio(){System.out.println(ANSI_YELLOW + "Se va a filtrar por precio" + ANSI_RESET);}
    public void mensajeFiltrarCategoria(){System.out.println(ANSI_YELLOW + "Se va a filtrar por categoría" + ANSI_RESET);}

    public void errorSeleccionarProducto(){System.out.println(ANSI_RED + "No se ha reconocido el tipo de producto" + ANSI_RESET);}

    public void errorSeleccion(){System.out.println(ANSI_RED + "No se ha reconocido la opción" + ANSI_RESET);}

    public void errorConversionANumero(){System.out.println(ANSI_RED + "El valor introducido no puede ser una cadena" + ANSI_RESET);}

    public void errorArchivoHistorial(){System.out.println(ANSI_RED + "El archivo de registros no se puede leer" + ANSI_RESET);}

    public void errorCarritoVacio(){System.out.println(ANSI_RED + "No puedes cerrar el pedido si no añades nada al carrito" + ANSI_RESET);}

    public void errorNoHayStock(Producto producto){System.out.println(ANSI_RED + "No Hay suficiente stock de " + producto.getNombre() + ANSI_RESET);}

    public void preguntarIDPorRetirarCarrito(){System.out.println(ANSI_CYAN + "Escribe el ID del producto que quieras retirar del carrito" + ANSI_RESET);}

    public void darFormatoAFecha(LocalDateTime fechaObj, DateTimeFormatter formatoBonito){System.out.println(ANSI_GREEN + "-- " + fechaObj.format(formatoBonito) + ANSI_RESET);}

    public void mostrarProducto(Producto producto, String propiedad){System.out.println( producto + " x " + propiedad);}

    public void adornoCarritoInicio(){System.out.println("-----------------Carrito-------------------");}

    public void adornoCarritoFin(){System.out.println("-------------------------------------------");}

    public void adornofactura(){System.out.println("-------------------------------------------");}

    public void mostrarTotalAPagar(float total){System.out.println("Total a pagar: " + ANSI_BLUE+ total + ANSI_RESET);}

}
