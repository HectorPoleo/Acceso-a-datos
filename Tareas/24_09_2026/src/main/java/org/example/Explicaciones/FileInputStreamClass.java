package org.example.Explicaciones;

import java.io.IOException;
import java.io.FileInputStream;

/**
 * Forma de leer un fichero en bytes
 * @author hectorpoleo
 * @version 1.0.0
 */
public class FileInputStreamClass {

    /**
     * Metodo para leer un fichero o imagen en formato byte
     * @param args
     */
    public static void main(String[] args) {
        if(args.length<1){
            System.out.println("ERROR: No hay argumento");
            return;
        }
        String nombreFichero = args[0];
        try {
            FileInputStream imagen = new FileInputStream(nombreFichero);
            int b;
            while ((b = imagen.read()) != -1){
                imagen.read();
                System.out.printf("%02x\t", b);
            }

        }catch(IOException e){
            System.out.printf("Error: %s\n" ,e.getMessage());
        }
    }
}
