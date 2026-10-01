package org.example.repository;

import org.example.model.Producto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCsvReader {
    static String path = "Practica.csv";
    static File file;
    List<Producto> productos = new ArrayList<>();

    public FileCsvReader(String path){
        this.path = path;
        this.file = new File(path);

        if(!file.exists()|| !file.isFile()){
            System.err.println("ERROR: La ruta= "+path+"no es una ruta valida o no es un fichero");
            try {
                file.createNewFile();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        List<Producto> productoLeido = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                String[] datos = line.split(";");
                Producto producto = new Producto(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2]));
                productoLeido.add(producto);
            }
        }catch (IOException e){
            System.out.println("ERROR: No se a podido leer el archivo"+ e.getMessage());
        }
        System.out.println(productoLeido);
    }

}
