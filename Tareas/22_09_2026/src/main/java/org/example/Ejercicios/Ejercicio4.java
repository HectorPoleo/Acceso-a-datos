package org.example.Ejercicios;

import java.io.File;
import java.io.IOException;

/**
 * Resolución de rutas con getCanonicalPath() y bloque finally (Checked)
 *
 * Crea una instancia de la clase File pasándole una ruta relativa con redundancias
 * (por ejemplo, ./subcarpeta/../fichero.txt). Utiliza el método getCanonicalPath() para obtener
 * la ruta limpia y resuelta del archivo. Captura la posible IOException obligatoria y añade un
 * bloque finally que confirme por consola el término de la inspección.
 *
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        File fichero = new File("./subcarpeta/../fichero.txt");
        try {
            System.out.println(fichero.getAbsolutePath());
            System.out.println(fichero.getCanonicalPath());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
