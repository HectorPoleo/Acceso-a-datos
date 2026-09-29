package org.example.Ejercicio;

import java.io.*;

/**
 * Generación de un archivo con numeración de líneas
 * Crea un programa que lea un archivo de código o texto llamado origen.txt y
 * genere un nuevo archivo destino_numerado.txt. Cada línea del fichero de salida debe incluir
 * su número correspondiente al principio con el formato 1: contenido, 2: contenido, etc.
 * @author Hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        File archivo = new File(args[0]);
        File archivoNuevo = new File(args[1]);
        try(FileReader fr = new FileReader(archivo);
            FileWriter fw = new FileWriter(archivoNuevo);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw)) {
            int numeroLinea= 1;
            String linea;
            while((linea = br.readLine()) != null){
                if(!linea.isBlank()){
                    System.out.println(linea);
                    bw.write(numeroLinea+": "+ linea);
                    bw.newLine();
                }
                numeroLinea++;
            }
        }catch (IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }


    }
}
