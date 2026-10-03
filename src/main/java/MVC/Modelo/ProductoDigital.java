package MVC.Modelo;

public class ProductoDigital extends Producto {
    private float tamanoDescarga;
    private String licencia;


    public ProductoDigital(int id, String nombre, float precio, int stock,String categoria) {
        super(id, nombre, precio, stock, categoria);
    }

    public ProductoDigital(int id, String nombre, float precio, int stock, String categoria, float tamanoDescarga, String licencia) {
        super(id, nombre, precio, stock, categoria);
        this.tamanoDescarga = tamanoDescarga;
        this.licencia = licencia;
    }

    //EL PRIMER VALOR QUE SE GRABA EN CSV ES UN IDENTIFICADOR DE TIPO (Fisico o Digital)
    public String toCSV(){return "1;"+ super.getId()+";"+super.getNombre()+";"+super.getPrecio()+";"+super.getStock()+";"+super.getCategoria()+";"+tamanoDescarga+";"+licencia;}

    public float getTamanoDescarga() {
        return tamanoDescarga;
    }

    public void setTamanoDescarga(float tamanoDescarga) {
        this.tamanoDescarga = tamanoDescarga;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
}
