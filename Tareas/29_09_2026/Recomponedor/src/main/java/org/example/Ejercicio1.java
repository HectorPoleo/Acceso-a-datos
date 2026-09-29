package org.example;

import java.io.*;
import java.util.Scanner;

/**
 * Procesador y Recomponedor de Archivos de Texto
 * Al extraer texto de archivos formateados (como documentos PDF o páginas web antiguas), es
 * común encontrarse con textos mal estructurados: oraciones continuas en una sola línea, palabras
 * cortadas con guiones debido al salto de línea del documento original, o párrafos que terminan
 * abruptamente sin puntuación.
 * Se solicita desarrollar una herramienta de consola en Java que actúe como un recomponedor de
 * texto para limpiar y dar un formato homogéneo a estos archivos.
 * @author Hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero: ");
        String ruta = sc.nextLine();
        if(ruta.isBlank()){
            System.out.println("ERROR: Indicar fichero");
            sc.close();
        }
        File fichero = new File(ruta);
        String recompRuta = ruta+".recomp.txt";
        File ficheroRecomp = new File(recompRuta);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroRecomp));
            BufferedReader br = new BufferedReader(new FileReader(fichero))){
            String letras;
            while((letras = br.readLine()) != null){
                if(letras.isBlank()){
                   bw.newLine();
                } else {
                    String[] frases = letras.split(".");
                    for (int i = 0; i < frases.length; i++) {
                        if(frases[i].equals(".")){
                            bw.newLine();
                        }
                    }
                }
            }
        }catch(IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }

    }
}
