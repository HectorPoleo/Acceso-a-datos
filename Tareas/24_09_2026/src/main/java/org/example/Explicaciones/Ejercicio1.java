package org.example.Explicaciones;

import java.io.*;
import java.util.Scanner;

/**
 * Practica de generar un fichero para leer y escribir en el
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio1 {

    /**
     * Metodo que comprueba si un fichero existe y lo lee y escribe sobre el
     * @param args
     */
    public static void main(String[] args) {
        File document = new File(args[0]);
        try {
            if(!document.exists()){
                document.createNewFile();
            }
            System.out.println("Fichero Creado");
            FileWriter escribir = new FileWriter(document);
            Scanner sc = new Scanner(System.in);
            String texto = sc.nextLine();
            escribir.write(texto);
            escribir.close();
            FileReader leer = new FileReader(document);
            int carater;
            while((carater= leer.read())!=-1){
                char caracteres = (char) carater;
                System.out.printf("%s", caracteres);
            }
            leer.close();
            //BufferedReader conversor = new BufferedReader(leer);
            //System.out.println(conversor.readLine());
        } catch (IOException e){
            System.out.println("ERROR: Se ha producido una excepcion " +e.getMessage());
        }
    }
}
