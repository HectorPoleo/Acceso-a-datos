package org.example.Ejercicios;

import java.io.FileReader;
import java.io.IOException;

/**
 * Lectura secuencial de caracteres y análisis de texto
 * Escribe un programa que abra el archivo notas.txt creado en el ejercicio anterior
 * utilizando FileReader. Procesa el archivo carácter a carácter hasta llegar a -1, mostrando por
 * pantalla la cantidad total de caracteres leídos y el número total de vocales (incluyendo
 * mayúsculas y minúsculas).
 * @author Hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        int caracteres = 0;
        int vocales = 0;
        int caracter;

        try(FileReader file = new FileReader(args[0])){
            while ((caracter = file.read()) != -1){
                caracteres++;
                char letra = (char) caracter;
                if("aeiouAEIOU".indexOf(letra) != -1){
                    vocales++;
                }
            }
            System.out.println("Totales de caracteresr: " + caracteres);
            System.out.println("Totales de vocales: " + vocales);
        }catch (IOException e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
