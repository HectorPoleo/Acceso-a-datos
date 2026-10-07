package org.example.repository;

import org.example.model.Producto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCsvWriter {


    public static void main(String[] args) {
        String path = "Pratica.csv";
        File file = new File(path);
        List<Producto> productos = new ArrayList<>();
        Producto p1 = new Producto(null,null,12.3);
        productos.add(p1);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            if(!file.exists()|| !file.isFile()){
                file.createNewFile();
            }
            for (Producto producto : productos){
                String codigo = (producto.getCod() == null)? "": String.valueOf(producto.getCod());
                String descripcion = (producto.getDescr() == null)? "": String.valueOf(producto.getDescr());
                String precio = (producto.getPrUnit() == null)? "": String.valueOf(producto.getPrUnit());
                bw.write(codigo+";"+descripcion+";"+precio);
                bw.newLine();
            }

        } catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }

    }

}
