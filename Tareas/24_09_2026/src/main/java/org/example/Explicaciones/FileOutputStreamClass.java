package org.example.Explicaciones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Funcion para clonar imagenes o ficheros
 * @author hectorpoleo
 * @version 1.0.0
 */
public class FileOutputStreamClass {

    /**
     * Metodo para clonar un fichero o imagen con args
     * @param args
     */
    public static void main(String[] args) {
        File file = new File(args[1]);
        if(args.length<1){
            System.out.println("ERROR: No hay argumento");
            return;
        }
        String nombreFichero = args[0];
        String nuevoFichero = args[1];
        if(new File(nuevoFichero).exists()){
            System.out.printf("ERROR: El fichero con el nombre %s ya existe", nuevoFichero);
        }
        try {
            FileInputStream fis = new FileInputStream(nombreFichero);
            FileOutputStream imagenNueva = new FileOutputStream(nuevoFichero);
            int b;
           while ((b=fis.read()) !=-1){
               imagenNueva.write(b);
           }
            System.out.printf("Se creo la imagen nueva");
        }catch (IOException e){
            System.out.printf("ERROR: ", e.getMessage());
        }
    }
}
