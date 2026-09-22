package org.example.Ejercicios;

import java.util.ArrayList;
import java.util.List;

/**
 * Conversión de datos y captura de NumberFormatException (Unchecked)
 *
 * Dado un array de cadenas de texto con valores numéricos y algunos datos
 * erróneos (por ejemplo, {"100", "250", "30A", "400", "XYZ"}), recorre el array convirtiendo
 * cada elemento a entero (Integer.parseInt). Muestra cada número convertido y, si se detecta
 * un valor no válido, captura la excepción NumberFormatException, muestra un aviso con el
 * índice del elemento corrupto y continúa procesando el resto del array.
 *
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        String[] valores = {"100", "250", "30A", "400", "XYZ"};
        int numero;
        int indice = -1;
        for (String valor : valores){
            indice++;
            try {
                numero = Integer.parseInt(valor);
                System.out.println(numero);
            }catch (NumberFormatException e){
                System.out.println("ERROR DE FORMATO : "+e.getMessage()+"El valor incorrecto se encuentra en : "+indice);
            }
        }
    }
}
