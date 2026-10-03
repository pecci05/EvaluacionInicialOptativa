package MVC;

import MVC.Modelo.*;

import java.util.Scanner;

public class Controlador {
    Scanner s = new Scanner(System.in);
    private GestionUsuarios gestionUsuarios;
    private GestionProducto gestionProducto;
    private Carrito carrito;
    private Vista vista;
    private Pedido pedido;
    private HistorialPedidos historialPedidos;

    public Controlador(GestionUsuarios gestionUsuarios, GestionProducto gestionProducto, Carrito carrito, Vista vista) {
        this.gestionUsuarios = gestionUsuarios;
        this.carrito = carrito;
        this.vista = vista;
        this.gestionProducto = gestionProducto;
        this.historialPedidos = new HistorialPedidos(vista);
    }

    public Usuario login() {
        Usuario user = null;
        boolean logeado = false;
        do {
            vista.pedirNombreUsuario();
            String nombre = s.nextLine();
            user = gestionUsuarios.buscarUserPorNombre(nombre);
            if (user != null) {
                vista.pedirPasswUsuario();
                String passw = s.nextLine();
                if (passw.equals(user.getPassw())) {
                    logeado = true;
                }
            }
        } while (!logeado);
        return user;
    }

    public void inicioAplicacion() {
        Usuario user = login();

        if (user.isAdmin()) {
            menuAdmin(user);
        } else {
            menuUser(user);
        }
        vista.mostrarCredencialesLogin(user);
    }

    public void menuAdmin(Usuario user) {
        int opcionInicial;
        while (true) {
            vista.menuPrincipalAdmin();
            opcionInicial = Integer.parseInt(s.nextLine());
            switch (opcionInicial) {
                case 1: {
                    menuProductos();
                    break;
                }
                case 2: {
                    menuUsuarios();
                    break;
                }
                case 3: {
                    menuCarrito();
                    break;
                }
                case 4: {
                    pedido = new Pedido(user, carrito.getProductosCarrito());
                    this.historialPedidos = new HistorialPedidos(pedido.getListaProductos(),vista);
                    historialPedidos.escribirHistorial();
                    carrito = new Carrito();
                    pedido.mostrarFactura(vista);
                    break;
                }
                case 5: {
                    leerPedidosRealizados();
                    break;
                }
                case 6: {
                    inicioAplicacion();
                    break;
                }
                default: {
                    vista.errorSeleccion();
                }
            }
        }
    }

    public void menuUser(Usuario user) {
        int opcionInicial;
        while (true) {
            vista.menuPrincipalUser();
            opcionInicial = Integer.parseInt(s.nextLine());
            switch (opcionInicial) {
                case 1: {
                    menuCarrito();
                    break;
                }
                case 2: {
                    if (!carrito.getProductosCarrito().isEmpty()) {
                        pedido = new Pedido(user, carrito.getProductosCarrito());
                        this.historialPedidos = new HistorialPedidos(pedido.getListaProductos(),vista);
                        historialPedidos.escribirHistorial();
                        carrito = new Carrito();
                        pedido.mostrarFactura(vista);
                    } else {
                        vista.errorCarritoVacio();
                    }
                    break;
                }
                case 3: {
                    inicioAplicacion();
                    break;
                }
                default: {
                    vista.errorSeleccion();
                }
            }
        }
    }


    private void menuCarrito() {
        vista.menuGestionCarrito();
        int opcion = Integer.parseInt(s.nextLine());
        switch (opcion) {
            case 1: {
                carrito.mostrarCarrito(vista);
                gestionProducto.getProductos().forEach(System.out::println);
                vista.pedirProductoPorSeleccionar();
                int idProducto = Integer.parseInt(s.nextLine());
                vista.pedirCantidadPorComprar();
                int cantidad = Integer.parseInt(s.nextLine());
                Producto producto = gestionProducto.buscarPorID(idProducto);
                if (producto.getStock() > cantidad){
                    carrito.agregarProducto(producto, cantidad);
                }else {vista.errorNoHayStock(producto);}
                break;
            }
            case 2: {
                carrito.mostrarCarrito(vista);
                vista.preguntarIDPorRetirarCarrito();
                int id = Integer.parseInt(s.nextLine());
                carrito.eliminarProducto(id);
                break;
            }
            case 3: {
            } default: {vista.errorSeleccionarProducto();}
        }
        carrito.mostrarCarrito(vista);
    }

    private void menuUsuarios() {
        vista.menuGestionUsuarios();
        int opcion = Integer.parseInt(s.nextLine());
        switch (opcion) {
            case 1: {
                vista.pedirNombreUsuario();
                String nombre = s.nextLine();
                vista.pedirPasswUsuario();
                String passw = s.nextLine();
                vista.pedirEmailUsuario();
                String email = s.nextLine();
                vista.pedirRolUsuario();
                int rolUser = Integer.parseInt(s.nextLine());
                if (rolUser == 1) {
                    gestionUsuarios.crearNuevoUsuario(nombre, passw, email, true, true);
                } else {
                    gestionUsuarios.crearNuevoUsuario(nombre, passw, email, true, false);
                }
                break;
            }
            case 2: {
                gestionUsuarios.listarUsuarios();
                vista.elegirIDUsuario();
                int id = Integer.parseInt(s.nextLine());
                gestionUsuarios.borrarUsuario(id);
                break;
            }
            case 3: {
                gestionUsuarios.listarUsuarios();
                break;
            } default: {vista.errorSeleccion();}
        }
    }

    private void menuProductos() {
        vista.menuGestionProductos();
        int opcion = Integer.parseInt(s.nextLine());
        switch (opcion) {
            case 1: {
                vista.elegirTipoProducto();
                int opcionTipoProducto = Integer.parseInt(s.nextLine());
                if (opcionTipoProducto == 1) {
                    boolean datosCorrectos = false;

                    String nombreProducto = "";
                    float precioProducto = 0;
                    int stockProducto = 0;
                    String categoria = "";
                    float tamanoDescarga = 0;
                    String licencia = "";

                    while (!datosCorrectos) {
                        vista.pedirNombreProducto();
                        nombreProducto = s.nextLine();
                        vista.pedirPrecioProducto();
                        try {
                            precioProducto = Float.parseFloat(s.nextLine());
                        } catch (Exception e) {
                            continue;
                        }
                        vista.pedirStockProducto();
                        try {
                            stockProducto = Integer.parseInt(s.nextLine());
                        } catch (Exception e) {
                            vista.errorConversionANumero();
                            continue;
                        }
                        vista.pedirCategoria();
                        categoria = s.nextLine();
                        vista.pedirTamanoDescargaProductoDigital();
                        try {
                            tamanoDescarga = Float.parseFloat(s.nextLine());
                        } catch (Exception e) {
                            vista.errorConversionANumero();
                            continue;
                        }
                        vista.pedirLicenciaProductoDigital();
                        licencia = s.nextLine();
                        datosCorrectos = true;
                    }


                    gestionProducto.agregarProductoDigital(nombreProducto, precioProducto, stockProducto, categoria, tamanoDescarga, licencia);
                } else if (opcionTipoProducto == 2) {

                    boolean datosCorrectos = false;

                    String nombreProducto = "";
                    float precioProducto = 0;
                    int stockProducto = 0;
                    String categoria = "";
                    float peso = 0;
                    float gastosEnvios = 0;

                    while (!datosCorrectos) {
                        vista.pedirNombreProducto();
                        nombreProducto = s.nextLine();
                        vista.pedirPrecioProducto();
                        try {
                            precioProducto = Float.parseFloat(s.nextLine());
                        } catch (Exception e) {
                            vista.errorConversionANumero();
                            continue;
                        }
                        vista.pedirStockProducto();
                        try {
                            stockProducto = Integer.parseInt(s.nextLine());
                        } catch (Exception e) {
                            vista.errorConversionANumero();
                            continue;
                        }
                        vista.pedirCategoria();
                        categoria = s.nextLine();
                        vista.pedirPesoProductoFisico();

                        try {
                            peso = Float.parseFloat(s.nextLine());
                        } catch (Exception e) {
                            vista.errorConversionANumero();
                            continue;
                        }
                        vista.pedirGastosEnvioProductoFisico();
                        try {
                            gastosEnvios = Float.parseFloat(s.nextLine());
                        } catch (Exception e) {
                            vista.errorConversionANumero();
                            continue;
                        }
                        gestionProducto.agregarProductoFisico(nombreProducto, precioProducto, stockProducto, categoria, peso, gastosEnvios);
                        datosCorrectos = true;
                    }
                } else {
                    vista.errorSeleccionarProducto();
                }

                break;
            }
            case 2: {
                gestionProducto.getProductos().stream().forEach(System.out::println);
                int id = Integer.parseInt(s.nextLine());
                gestionProducto.getProductos().remove(id);
                break;
            }
            case 3: {
                gestionProducto.getProductos().stream().forEach(System.out::println);
                break;
            }
            case 4: {
                String terminoBusqueda = s.nextLine();
                try {
                    int precio = Integer.parseInt(terminoBusqueda);
                    vista.mensajeFiltrarPrecio();
                    gestionProducto.getProductos().stream().filter((p) -> p.getPrecio() == precio).forEach(System.out::println);
                } catch (Exception exception) {
                    vista.mensajeFiltrarCategoria();
                    gestionProducto.getProductos().stream().filter((p) -> p.getCategoria().toString().equals(Categorias.detectarCategoria(terminoBusqueda).toString())).forEach(System.out::println);
                }
                break;
            }
            default:
        }
        {

        }
    }

    private void leerPedidosRealizados() {
        historialPedidos.leerHistorial(vista);
    }
}
