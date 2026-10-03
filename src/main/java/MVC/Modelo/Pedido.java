package MVC.Modelo;

import MVC.Vista;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Pedido {
    private LocalDateTime fecha;
    private Usuario usuario;
    private HashMap<Producto,Integer> listaProductos;
    private float total = 0;

    public Pedido(Usuario usuario,HashMap<Producto,Integer> listaProductos){
        this.usuario = usuario;
        this.fecha = LocalDateTime.now();
        this.listaProductos = listaProductos;
        sumTotal();
    }

    public Pedido(Usuario usuario,HashMap<Producto,Integer> listaProductos,LocalDateTime fecha){
        this.usuario = usuario;
        this.fecha = fecha;
        this.listaProductos = listaProductos;
        sumTotal();
    }

    public void sumTotal(){
        for (Producto producto :listaProductos.keySet()){
            total+=producto.getPrecio()*listaProductos.get(producto);
        }
        listaProductos.keySet().forEach(System.out::println);
    }

    public void mostrarFactura(Vista vista){
        vista.adornofactura();
        listaProductos.forEach((p1,c1) -> System.out.println(p1 + "   x" + c1 + "-> " + p1.getPrecio()*c1 + "€"));
        vista.mostrarTotalAPagar(total);
        vista.adornofactura();
    }

//    public String toString(){
//        Producto[] productos = (Producto[]) listaProductos.keySet().stream().toArray();
//
//        String cadena = "--" + fecha.toString() + " ---- " + usuario.getEmail() + "--- \n";
//        for (int i = 0; i < productos.length; i++) {
//            cadena += productos[i] + " x " + listaProductos.get(productos[i]);
//        }
//
//        return cadena;
//    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public HashMap<Producto, Integer> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(HashMap<Producto, Integer> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
