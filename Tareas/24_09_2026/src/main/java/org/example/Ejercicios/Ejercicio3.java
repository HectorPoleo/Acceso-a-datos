package org.example.Ejercicios;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Escritura directa de texto y modo 'append'
 * Diseña un programa que cree un fichero de texto notas.txt y escriba un par de
 * líneas iniciales con FileWriter. Posteriormente, mediante una segunda apertura utilizando el
 * modo de anexo (append), añade una nueva línea al final del archivo sin borrar el contenido
 * anterior.
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio3 {
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
            String texto2 = sc.nextLine();
            escribir.write(texto);
            escribir.append(texto2);
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
