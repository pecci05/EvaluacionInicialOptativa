package MVC.Modelo;

import java.util.ArrayList;

public class GestionProducto {
    private ArrayList<Producto> productos;
    private static int contadorProductos;

    public GestionProducto(){
        productos = new ArrayList<>();
        contadorProductos = 0;
    }

    public void agregarProductoFisico(String nombre, float precio, int stock, String categoria,float peso, float gastosEnvios){
        ProductoFisico productoFisico = new ProductoFisico(contadorProductos++,nombre,precio,stock,categoria,peso,gastosEnvios);
        productos.add(productoFisico);
    }

    public void agregarProductoDigital(String nombre, float precio, int stock, String categoria, float tamanoDescarga, String licencia){
        ProductoDigital productoDigital = new ProductoDigital(contadorProductos++,nombre,precio,stock,categoria,tamanoDescarga,licencia);
        productos.add(productoDigital);
    }

    public Producto buscarPorID(int id){
        for (Producto producto : productos){
            if (producto.getId() == id) return producto;
        }
        return null;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public static int getContadorProductos() {
        return contadorProductos;
    }

    public static void setContadorProductos(int contadorProductos) {
        GestionProducto.contadorProductos = contadorProductos;
    }
}
