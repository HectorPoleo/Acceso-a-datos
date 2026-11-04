package org.example.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorAlmacenMultiformato {
    static String pathDirectorio = "./datos_almacen";
    static  String pathCSV = pathDirectorio+"/importacion_producto.csv";
    static List<Producto> productosLeer = new ArrayList<>();
    static List<Producto> productosRandom = new ArrayList<>();

    private static final int TAMANO_ID= 4;
    private static final int LONG_NOMBRE = 30;
    private static final int TAMANO_NOMBRE= LONG_NOMBRE*2;
    private static final int TAMANO_PRECIO= 8;
    private static final int TAMANO_TOTAL= 76;

    public static void preparaEntorno(){
        File directorio = new File(pathDirectorio);
        File ficheroCsv = new File(pathCSV);
        try {
            if(!directorio.exists() || !directorio.isDirectory()){
                directorio.mkdirs();
                System.out.println("Se crea el directorio");
            }
            if(!ficheroCsv.exists() || !ficheroCsv.isFile()){
                ficheroCsv.createNewFile();
                System.out.println("Se crea el fichero");
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathCSV))){
                    bw.write("1;Teclado;20.0;2");
                    bw.newLine();
                    bw.write("2;Raton;20.0;2");
                    bw.newLine();
                    bw.write("3;Alfombrilla;20.0;2");
                    bw.newLine();
                    bw.write("4;Pantalla;20.0;2");
                }
            }


        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Producto> leerCSV(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                int contador = 0;
                String[] datos = line.split(";", -1);
                for (String dato : datos){
                    contador++;
                    if(dato.isBlank()){
                        System.out.println("ERROR: el dato "+ contador+" no cumple la estructura del produto: "+datos[0]);
                    }
                }
                Producto producto = new Producto(Integer.parseInt(datos[0]),
                        datos[1],Double.parseDouble(datos[2]), Integer.parseInt(datos[3]));
                productosLeer.add(producto);
            }
            return productosLeer;
        }catch (IOException e){
            System.out.println("ERROR: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void escribirRandomAccess(String path, List<Producto> productos){
          try (RandomAccessFile raf = new RandomAccessFile(path,"rw")){
                raf.setLength(0);
                for (Producto producto : productos){
                    raf.writeInt(producto.getId());
                    raf.writeChars(AjustarNombre(producto.getNombre()));
                    raf.writeDouble(producto.getPrecio());
                    raf.writeInt(producto.getStock());
                }
          }catch (IOException e){
              System.out.println("ERROR: "+ e.getMessage());
          }
    }

    public static void actualizarStockRandomAccess(String path, int posicion, int nuevoStock){
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw")){
            long posicionRegistro = (long) posicion * TAMANO_TOTAL;
            if(posicion < 0 || posicionRegistro + TAMANO_TOTAL > raf.length()){
                System.out.println("Posicion fuera de rango "+posicion);
                return;
            }
            raf.seek(posicionRegistro+TAMANO_ID+TAMANO_NOMBRE+TAMANO_PRECIO);
            raf.writeInt(nuevoStock);
        }catch (IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }

    public static void exportarJSON(String pathJson, List<Producto> productos){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fw = new FileWriter(pathJson)){
            gson.toJson(productos, fw);
        }catch (IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }

    public static List<Producto> leerRandomAccess(String rutaDat){
        try (RandomAccessFile raf = new RandomAccessFile(rutaDat, "r")){
            long numRegistro = raf.length()/TAMANO_TOTAL;
            for (int i= 0; i < numRegistro; i++){
                raf.seek((long) i * TAMANO_TOTAL);
                int id = raf.readInt();

                StringBuilder sb = new StringBuilder();
                for(int c = 0; c < LONG_NOMBRE; c++){
                    sb.append(raf.readChar());
                }
                String nombre = sb.toString().trim();
                double precio = raf.readDouble();
                int stock = raf.readInt();
                productosRandom.add(new Producto(id,nombre,precio,stock));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productosRandom;
    }


    public static String AjustarNombre(String nombre){
        StringBuffer sb = new StringBuffer(nombre);
        sb.setLength(LONG_NOMBRE);
        return sb.toString().replace('\0', ' ');
    }
}
