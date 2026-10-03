package MVC.Modelo;

public class ProductoFisico extends Producto {

    private float peso;
    private float gastosEnvio;

    public ProductoFisico(int id, String nombre, float precio, int stock, String categoria) {
        super(id, nombre, precio, stock, categoria);
    }

    public ProductoFisico(int id, String nombre, float precio, int stock,String categoria, float peso, float gastosEnvio) {
        super(id, nombre, precio, stock, categoria);
        this.peso = peso;
        this.gastosEnvio = gastosEnvio;
    }

    //EL PRIMER VALOR QUE SE GRABA EN CSV ES UN IDENTIFICADOR DE TIPO (Fisico o Digital)
    public String toCSV(){return "2;"+super.getId()+";"+super.getNombre()+";"+super.getPrecio()+";"+super.getStock()+";"+super.getCategoria()+";"+peso+";"+gastosEnvio;}

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(float gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }
}
