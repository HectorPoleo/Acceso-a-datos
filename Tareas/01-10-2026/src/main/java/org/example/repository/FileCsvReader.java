package org.example.repository;

import org.example.model.Producto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCsvReader {

    static List<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
         String path = "Pratica.csv";
         File file = new File(path);
         try (BufferedReader br = new BufferedReader(new FileReader(file))){
            if(!file.exists()|| !file.isFile()){
                file.createNewFile();
            }
            String line;
            while ((line = br.readLine()) != null){
                String[] datos = line.split(";");
                for (String dato : datos){
                    if (dato.isBlank()){
                        System.out.println("ERROR: la linea no cumple la estructura");
                       }
                }
                Producto producto = new Producto(datos[0].isBlank() ? null : Integer.parseInt(datos[0]), datos[1], datos[2].isBlank()  ? null : Double.parseDouble(datos[2]));
                productos.add(producto);
            }
            System.out.println(productos);
         }catch (IOException e){
            System.out.println("ERROR: No se a podido leer el archivo"+ e.getMessage());
         } catch (NumberFormatException e) {
             System.out.println("ERROR: "+e.getMessage());
         }
    }

}
