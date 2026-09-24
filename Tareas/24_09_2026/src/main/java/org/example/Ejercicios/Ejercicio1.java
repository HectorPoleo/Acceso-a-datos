package org.example.Ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Copia de un archivo binario mediante bloques de bytes
 * Desarrolla un programa que realice una copia exacta de un archivo binario (por
 * ejemplo, imagen.png o cualquier archivo de datos) creando un archivo de salida llamado
 * copia_imagen.png. Utiliza un array de bytes (byte[]) como búfer manual para transferir los
 * datos desde FileInputStream hacia FileOutputStream.
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        File file = new File(args[1]);
        if(args.length<1){
            System.out.println("ERROR: No hay argumento");
            return;
        }
        String imagen = args[0];
        String copiaImagen = args[1];
        byte[] buffer = new byte[4096];
        if(new File(copiaImagen).exists()){
            System.out.println("ERROR: La copia del fichero ya existe "+copiaImagen);
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(imagen);
            FileOutputStream fus = new FileOutputStream(copiaImagen);
            int bytes;
            while((bytes = fis.read(buffer))!=-1){
                fus.write(buffer, 0, bytes);
            }
            System.out.println("Se creo la copia de la imagen");
        }catch (IOException e){
            System.out.println("ERROR: Se ha producido una excepcion " +e.getMessage());
        }

    }
}
