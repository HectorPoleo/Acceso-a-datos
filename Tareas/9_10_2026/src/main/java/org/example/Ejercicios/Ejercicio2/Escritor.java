package org.example.Ejercicios.Ejercicio2;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Ejercicio 2: Serialización y Deserialización de Objetos (ObjectOutputStream y ObjectInputStream)
 * Desarrolla una solución en Java dividida en tres clases para gestionar el
 * registro de empleados de una empresa mediante el mecanismo de serialización de
 * objetos:
 * 1. Empleado (Clase Modelo): Debe implementar la interfaz Serializable para
 * permitir que sus instancias sean convertidas en flujos de bytes.
 * 2. EscritorObjetos: Crea varias instancias de la clase Empleado y escribirlas
 * individualmente en el fichero binario empleados.dat utilizando
 * ObjectOutputStream.
 */
public class Escritor {

    /**
     * Metodo para escribir un fichero binario
     * @param args
     */
    public static void main(String[] args) {
        String path = "empleados.dat";
        Object[][] empleados = {{1,"49512097c","Acel",33232.0,true},{2,"49522097c","Pepe",24.0,true}};
        try(FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            for (Object[] empleado : empleados){
                oos.writeObject(empleado);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
