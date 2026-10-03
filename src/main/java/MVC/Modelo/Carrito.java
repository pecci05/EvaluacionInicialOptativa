package MVC.Modelo;

import MVC.Vista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Carrito {
    private HashMap<Producto,Integer> productosCarrito;
    private float total;

    public void mostrarCarrito(Vista vista){
        vista.adornoCarritoInicio();
        productosCarrito.forEach((p1,c1) -> System.out.println(p1 + "   x" + c1 + "-> " + p1.getPrecio()*c1 + "€"));
        vista.adornoCarritoFin();
    }

    public void agregarProducto(Producto producto, int cantidad){
        if (productosCarrito.containsKey(producto)){
            productosCarrito.put(producto,cantidad + productosCarrito.get(producto));
        } else {
            productosCarrito.put(producto,cantidad);
            total += producto.getPrecio() * cantidad;
        }

    }

    public void eliminarProducto(int id){
        Producto[] productos = productosCarrito.keySet().stream().toArray(Producto[]::new);
        ArrayList<Producto> listaProductos = new ArrayList<>();

        for (int i = 0; i < productos.length; i++) {
            listaProductos.add(productos[i]);
        }

        Producto[] productoElegido = listaProductos.stream().filter((p)->p.getId() == id).toArray(Producto[]::new);
        productosCarrito.remove(productoElegido[0]);
    }

    public Carrito(HashMap<Producto, Integer> productosCarrito) {
        this.productosCarrito = productosCarrito;
        total = 0;
    }

    public Carrito(){
        this.productosCarrito = new HashMap<>();
    }

    public HashMap<Producto, Integer> getProductosCarrito() {
        return productosCarrito;
    }

    public void setProductosCarrito(HashMap<Producto, Integer> productosCarrito) {
        this.productosCarrito = productosCarrito;
    }

    public void addProduct(Producto producto,int cantidad){
        productosCarrito.put(producto,cantidad);
    }

    public void deleteProduct(Producto producto){
        productosCarrito.remove(producto);
    }

}
