package org.example.Ejercicio;

import java.io.*;

/**
 * Transformación de texto y filtrado de líneas vacías
 * Diseña un programa que lea el archivo borrador.txt, transforme todo su texto a
 * letras mayúsculas y escriba el resultado en resultado_limpio.txt, omitiendo todas las líneas
 * que estén en blanco o contengan únicamente espacios.
 * @author Hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        File archivo = new File(args[0]);
        File resultado = new File(args[1]);
        try (BufferedReader br = new BufferedReader(new FileReader(archivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(resultado))){
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            if(!resultado.exists()){
                resultado.createNewFile();
            }
            int numeroLinea= 1;
            String linea;
            while((linea = br.readLine()) != null){
                if(!linea.isBlank()){
                    bw.write(linea.toUpperCase());
                    bw.newLine();
                }
                numeroLinea++;
            }

        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }

    }
}
