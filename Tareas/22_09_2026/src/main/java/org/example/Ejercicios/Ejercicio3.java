package org.example.Ejercicios;

import java.io.File;
import java.io.IOException;

/**
 * Creación de ficheros y captura de IOException (Checked)
 *
 * Crea un programa que intente crear un fichero llamado documento.txt dentro de
 * una subcarpeta llamada carpeta_inexistente. Al no existir previamente dicha carpeta
 * contenedora, el método createNewFile() fallará y lanzará una excepción. Captura la
 * excepción mediante un bloque try-catch para mostrar un mensaje de error explicativo sin
 * que la aplicación falle.
 *
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        String path = "/home/tarde/Escritorio/carpeta-inexistente";
        File fichero = new File(path+"/documento.txt");
        try {
            fichero.createNewFile();
        } catch (IOException e){
            System.out.println("El directorio donde se quiere crear el fichero no existe");
        }
    }
}
