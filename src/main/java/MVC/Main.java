package MVC;

import MVC.Modelo.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static void main(String[] args) {
        Vista vista = new Vista();



        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        GestionProducto gestionProducto = new GestionProducto();
//        ProductoFisico producto1 = new ProductoFisico(1,"Disco",12,1);
//        ProductoFisico producto2 = new ProductoFisico(2,"Libro",10,1);

        Producto producto1 = new ProductoDigital(1,"W10",12,5,"tecnologia",100,"asdasdad");
        Producto producto2 = new ProductoFisico(2,"Libro",10,4,"ocio",10,10);

        gestionProducto.agregarProductoDigital("W10",12,5,"tecnologia",100,"asdasdad");
        gestionProducto.agregarProductoFisico("Libro",10,4,"ocio",10,10);

        gestionUsuarios.crearNuevoUsuario("Alejandro","1234","peccicarrilloalejandro@gmail.com",true,true);
        gestionUsuarios.crearNuevoUsuario("Luis","1234","luis@gmail.com",true,false);

        HashMap<Producto,Integer> listaPedido = new HashMap<>();
        listaPedido.put(producto1,1);
        listaPedido.put(producto2,2);

        Pedido pedido = new Pedido(gestionUsuarios.buscarUserPorID(1),listaPedido);
        System.out.println(pedido);
        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido);

//        HistorialPedidos historialPedidos = new HistorialPedidos(pedidos);


        HashMap<Producto,Integer> diccionario = new HashMap<>();




        Carrito carrito = new Carrito(diccionario);

        Controlador controlador = new Controlador(gestionUsuarios,gestionProducto,carrito,vista);

        controlador.inicioAplicacion();



    }
}
