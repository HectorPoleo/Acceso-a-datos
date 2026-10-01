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
    /**
     * Merodo para separar por puntos, guiones o espacios vacios un documento de texto
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero: ");
        args[0] = sc.nextLine();
        if(args[0].isBlank()){
            System.out.println("ERROR: Indicar fichero");
            sc.close();
        }
        File fichero = new File(args[0]);
        String recompRuta = args[0]+".recomp.txt";
        File ficheroRecomp = new File(recompRuta);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroRecomp));
            BufferedReader br = new BufferedReader(new FileReader(fichero))){
            String letras;
            while((letras = br.readLine()) != null){
                if(letras.isBlank()){
                   bw.newLine();
                } else {
                    if(letras.contains(".")){
                        String[] frases = letras.split("\\.");
                        for (String frase : frases) {
                            if(frase.contains("-")) {
                                String[] fraseCortada = frase.split("-");
                                bw.write(fraseCortada[0]);
                            }else {
                                bw.write(frase+ ".");
                                bw.newLine();
                            }
                        }
                    }else if(letras.endsWith("-")){
                        String[] fraseCortada = letras.split("-");
                        bw.write(fraseCortada[0]);
                    }else{
                        bw.write(letras+"{\\n}");
                        bw.newLine();
                    }
                }
            }
        }catch(IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }

    }
}
