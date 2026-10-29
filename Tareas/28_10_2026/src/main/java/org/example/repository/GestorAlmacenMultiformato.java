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
    static List<Producto> productos = new ArrayList<>();

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
                productos.add(producto);
            }
            return productos;
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
                    raf.writeChars(producto.getNombre());
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

            raf.seek(posicionRegistro+TAMANO_ID+TAMANO_NOMBRE* 2 + TAMANO_PRECIO);
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

    public static List<Producto> getProductos(){
        return productos;
    }
}
