package org.example;

import java.io.File;

/**
 * Ejercicio 3: Limpieza y eliminación de recursos
 * • Objetivo: Eliminar archivos de manera segura y liberar espacio en disco.
 * • Enunciado: Crea una rutina que compruebe si existe un fichero temporal.txt dentro de una
 * carpeta temp. Elimina primero el archivo y, solo si la eliminación del archivo es exitosa,
 * elimina la carpeta contenedora.
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio3 {

    /**
     * Metodo que comprueba si un directorio existe y si es asi comprueba si tiene cierto
     * fichero para eliminarlo y si lo consigue se elimina el directorio
     * @param args
     */
    public static void main(String[] args) {
        String path = "/home/tarde/Escritorio/Acceso a datos/temp.";
        File directory = new File(path);
        File archivoDelete = new File(path+"/temporal.txt");
        if(directory.exists()) {
            if (archivoDelete.exists()) {
                archivoDelete.delete();
                System.out.println("Archivo eliminado");
                if (!archivoDelete.exists()) {
                    directory.delete();
                    System.out.println("Se a borrado el directorio");
                }
            } else {
                System.out.println("No existe o el archivo o el directorio no existe");
            }
        } else {
            System.out.println("No existe el directorio");
        }
    }
}
