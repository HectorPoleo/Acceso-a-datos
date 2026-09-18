package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 1: Explorador de contenidos de un directorio
 * • Objetivo: Recorrer estructuras del sistema de archivos distinguiendo carpetas de ficheros.
 * • Enunciado: Diseña un programa que reciba la ruta del directorio actual (.), obtenga todo su
 * contenido y muestre por pantalla cada elemento etiquetándolo como [DIR] o [FICHERO].
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio1 {

    /**
     * Metodo para recorre una lista de carpetas y ficheros y diferenciarlos
     * @param args
     */
    public static void main(String[] args) {
        String path = "/home/tarde/Escritorio/Acceso a datos/18_09_2026/";
        File directory = new File(path);
        File[] contenidos = directory.listFiles();

        for(File contenido : contenidos){
            if (contenido.isDirectory()){
                System.out.println("Es un directorio: "+contenido.getName());
            } else if(contenido.isFile()){
                System.out.println("Es un fichero: "+contenido.getName());
            } else {
                System.out.println("No es ni un fichero ni un directorio");
            }
        }



    }
}