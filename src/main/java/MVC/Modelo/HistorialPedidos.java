package MVC.Modelo;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class HistorialPedidos {
    private HashMap<Producto, Integer> pedidos;
    private BufferedWriter bw;
    private BufferedReader br;

    public HistorialPedidos() {
        pedidos = new HashMap<>();
        try {
            this.bw = new BufferedWriter(new FileWriter("src/main/java/Files/registrosPedidos.csv", true));
            this.br = new BufferedReader(new FileReader("src/main/java/Files/registrosPedidos.csv"));
        } catch (IOException e) {
            System.out.println("El archivo de registros no se puede leer");
        }
    }

    public HistorialPedidos(HashMap<Producto, Integer> pedidos) {
        this.pedidos = pedidos;
        try {
            this.bw = new BufferedWriter(new FileWriter("src/main/java/Files/registrosPedidos.csv", true));
            this.br = new BufferedReader(new FileReader("src/main/java/Files/registrosPedidos.csv"));
        } catch (IOException e) {
            System.out.println("El archivo de registros no se puede leer");
        }
    }

    public void leerHistorial() {
        try {
            Producto producto = null;
            String linea = br.readLine();
            String fecha = "";

            String[] propiedades = new String[9];
            while (linea != null) {
                if (linea.startsWith("-")){
                    fecha = linea.replace("-","");
                    LocalDateTime fechaObj = LocalDateTime.parse(linea);
                    DateTimeFormatter formatoBonito = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    System.out.println("-- " + fechaObj.format(formatoBonito));
                }else {
                    propiedades = linea.split(";");

                    if (Integer.parseInt(propiedades[0]) == 1) {
                        producto = new ProductoDigital(Integer.parseInt(propiedades[1]), propiedades[2], Float.parseFloat(propiedades[3]), Integer.parseInt(propiedades[4]), propiedades[5], Float.parseFloat(propiedades[6]), propiedades[7]);
                    } else if (Integer.parseInt(propiedades[0]) == 2) {
                        producto = new ProductoFisico(Integer.parseInt(propiedades[1]), propiedades[2], Float.parseFloat(propiedades[3]), Integer.parseInt(propiedades[4]), propiedades[5], Float.parseFloat(propiedades[6]), Float.parseFloat(propiedades[7]));
                    }


                    System.out.println(producto + " x " + propiedades[8]);
                }
                linea = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("No se puede leer");
        }
    }

    public void escribirHistorial() {
        try {
            bw.write("-" + LocalDateTime.now().toString());
            bw.newLine();

            Producto[] productos = pedidos.keySet().stream().toArray(Producto[]::new);
            ArrayList<Producto> listaProducto = new ArrayList<>();

            for (int i = 0; i < productos.length; i++) {
                listaProducto.add(productos[i]);
            }
            for (Producto producto : listaProducto) {
                bw.write(producto.toCSV() + ";" + pedidos.get(producto));
                bw.newLine();
            }
            bw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


//    public HistorialPedidos(Pedido[] pedidos){
//        this.pedidos = new ArrayList<>();
//    }
