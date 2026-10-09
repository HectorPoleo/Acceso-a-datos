package org.example.Ejercicios.Ejercicio1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Ejercicio 1: Datos Elementales en Ficheros Binarios (DataOutputStream y DataInputStream)
 * Desarrolla una aplicación en Java organizada en dos clases independientes
 * para gestionar el inventario simplificado de una tienda mediante flujos de datos
 * binarios primitivos.
 * La finalidad es guardar la información de varios productos en un archivo llamado
 * productos.dat y, posteriormente, recuperarla respetando el orden secuencial de los
 * datos.
 * • EscritorBinario: Almacena en una matriz de objetos (Object[][]) los datos de
 * varios productos. Recorre la matriz con un bucle para escribir secuencialmente
 * cada atributo en un fichero binario (productos.dat) usando DataOutputStream.
 * @author HectorPoleo
 * @version 1.0.0
 */
public class Escritor {
    /**
     * Metodo para escribir en un fichero serializado
     * @param args
     */
    public static void main(String[] args) {
        String path = "./productos.dat";
        Object[][] inventario = {{1,"Acelgas",3.0},{2,"Pepinillos",4.0}};
        try(FileOutputStream fos = new FileOutputStream(path);
            DataOutputStream dos = new DataOutputStream(fos)){
            for (Object[] producto : inventario){
                dos.writeInt((Integer) producto[0]);
                dos.writeUTF((String) producto[1]);
                dos.writeDouble((Double) producto[2]);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
