package org.example.Ejercicio;

import java.io.*;

/**
 * Fusión de múltiples ficheros en uno solo (Concatenación)
 * Desarrolla una rutina que tome dos ficheros de texto (parte1.txt y parte2.txt) y
 * fusione sus contenidos en un único archivo llamado documento_completo.txt. Introduce una
 * línea divisoria decorativa entre el final del primer archivo y el inicio del segundo.
 * @author Hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        String archivo1 = "parte1.txt";
        File archivo = new File(archivo1);
        String archivo2 = "parte2.txt";
        File archivo3 = new File(archivo2);
        String resultado = "documento_completo.txt";
        File resultadoFile = new File(resultado);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultadoFile));
             BufferedReader br = new BufferedReader(new FileReader(archivo));
             BufferedReader br2 = new BufferedReader(new FileReader(archivo3))){
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            if(!archivo3.exists()){
                archivo3.createNewFile();
            }
            if(!resultadoFile.exists()){
                resultadoFile.createNewFile();
            }
            escribir(br, bw);
            bw.write("--------------------------");
            bw.newLine();
            escribir(br2, bw);
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    private static void escribir (BufferedReader br , BufferedWriter bw) throws IOException{
            String lineas;
            while ((lineas = br.readLine()) != null){
                bw.write(lineas);
                bw.newLine();
            }
    }
}
