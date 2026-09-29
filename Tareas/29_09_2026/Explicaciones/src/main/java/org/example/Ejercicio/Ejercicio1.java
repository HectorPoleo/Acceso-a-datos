package org.example.Ejercicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lectura línea a línea y filtrado de registros (Búsqueda)
 * Desarrolla un programa que lea un archivo de registro llamado log.txt. El
 * programa debe recorrer el fichero línea por línea, contar cuántas veces aparece la palabra
 * "ERROR" e imprimir por consola tanto el número total de errores como el texto completo de
 * cada línea que contenga dicho error.
 * @author Hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        File  registro = new File(args[0]);
        try{
            if(!registro.exists()){
                registro.createNewFile();
            }
            FileReader fs = new FileReader(registro);
            BufferedReader fo = new BufferedReader(fs);
            int numeroRegistro = 0;
            String lineas;
            while((lineas = fo.readLine()) != null){
                if (lineas.toLowerCase().contains("error ")){
                    System.out.println(lineas);
                    numeroRegistro++;
                }
            }
            System.out.println("Repeticiones de error: "+numeroRegistro);
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
