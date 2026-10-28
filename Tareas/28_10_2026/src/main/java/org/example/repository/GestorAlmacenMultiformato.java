package org.example.repository;

import org.example.model.Producto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorAlmacenMultiformato {
    static String pathDirectorio = "./datos_almacen";
    static  String pathCSV = pathDirectorio+"/importacion_producto.csv";
    static List<Producto> productos = new ArrayList<>();

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

        return new ArrayList<>();
    }

    public static void escribirRandomAccess(String path, List<Producto> productos){

    }

    public static void actualizarStockRandomAccess(String path, int posicion, int nuevoStock){
        
    }

    public static void exportarJSON(String pathJson, List<Producto> productos){

    }
}
