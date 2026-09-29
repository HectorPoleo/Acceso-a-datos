package org.example.Ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Contador de bytes específicos en un archivo binario
 * Crea un programa que lea un archivo binario datos.dat utilizando
 * FileInputStream. Recorre el fichero byte a byte con el metodo read(), contando la cantidad
 * total de bytes que contiene el archivo y cuántos de ellos equivalen exactamente al byte nulo
 * (0x00).
 * @author Hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio2 {

    /**
     * Metodo para recorrer un fichero por bytes y contar el total de bytes
     * @param args
     */
    public static void main(String[] args) {
        int totalBytes = 0;
        int bytesNulos = 0;
        int dato;
        File archivo = new File(args[0]);
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
                System.out.println("Archivo datos.dat creado.");
            }
            try (FileInputStream lector = new FileInputStream(archivo)) {
                while ((dato = lector.read()) != -1) {
                    totalBytes++;
                    if (dato == 0x00) {
                        bytesNulos++;
                    }
                }
            }
            System.out.println("Total de bytes: " + totalBytes);
            System.out.println("Bytes nulos (0x00): " + bytesNulos);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
