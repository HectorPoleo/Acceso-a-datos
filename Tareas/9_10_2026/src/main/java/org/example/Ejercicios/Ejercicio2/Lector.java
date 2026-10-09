package org.example.Ejercicios.Ejercicio2;

import org.example.Ejercicios.model.Empleado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 2: Serialización y Deserialización de Objetos (ObjectOutputStream y ObjectInputStream)
 * Objetivo: Desarrolla una solución en Java dividida en tres clases para gestionar el
 * registro de empleados de una empresa mediante el mecanismo de serialización de
 * objetos:
 * 3. LectorObjetos: Recupera los objetos del fichero empleados.dat mediante
 * ObjectInputStream en un bucle hasta alcanzar el final del archivo
 * (EOFException), realizando el correspondiente casting e imprimiendo los datos
 * por pantalla.
 */
public class Lector {

    /**
     * Metodo para leer un fichero por binario
     * @param args
     */
    public static void main(String[] args) {
        String path = "empleados.dat";
        List<Empleado> empleados = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream dis = new ObjectInputStream(fis)){
            while (true){
                try {
                    Object[] empleadosObject = (Object[]) dis.readObject() ;
                    Empleado empleado1 = new Empleado((Integer) empleadosObject[0], (String) empleadosObject[1], (String) empleadosObject[2],
                            (Double) empleadosObject[3], (Boolean) empleadosObject[4]);
                    empleados.add(empleado1);
                } catch (EOFException e){
                    break;
                }
            }
            System.out.println(empleados);
        }catch (IOException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
