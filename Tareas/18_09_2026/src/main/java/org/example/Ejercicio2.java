package org.example;

import java.io.File;
import java.io.IOException;

/**
 * Ejercicio 2: Creación de directorios y reubicación de ficheros
 * • Objetivo: Crear carpetas en disco y mover/renombrar archivos entre ellas.
 * • Enunciado: Crea una carpeta llamada copias_seguridad. Dentro de ella, genera un fichero
 * datos_v1.txt y posteriormente renómbralo a datos_final.txt.
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio2 {
    /**
     * Metodo para crear carpetas, crear ficheros dentro de ellas y renombrarlos
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String path = "/home/tarde/Escritorio/Acceso a datos/copias_seguridad";
        File directory = new File(path);
        File nuevo = new File(path+"/datos_v1.txt");
        File renombre = new File(path+"/datos_final.txt");
        if (!directory.exists()){
            directory.mkdir();
            if(nuevo.createNewFile()){
                System.out.println(nuevo.getName());
            }
        }else {
            System.out.println("La carpeta ya existe");

            if(nuevo.exists()){
                System.out.println("Ya existe");
                nuevo.renameTo(renombre);
                if(nuevo.renameTo(renombre)){
                        System.out.println(nuevo.getName());
                }
            }else {
                if(nuevo.createNewFile()){
                    System.out.println(nuevo.getName());
                }
            }
        }
    }
}
