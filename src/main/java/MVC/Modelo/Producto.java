package MVC.Modelo;
import MVC.Modelo.Categorias;

public abstract class Producto {
    private int id;
    private String nombre;
    private float precio;
    private int stock;
    private Categorias categoria;


    public Producto(int id, String nombre, float precio, int stock, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = Categorias.detectarCategoria(categoria);
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + ": " + precio+"€";
    }

    abstract public String toCSV();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
