package org.example.Ejercicios.Ejercicio2;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

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
        Object[] empleados = new Object[5];
        try (FileInputStream fis = new FileInputStream(path);
             DataInputStream dis = new DataInputStream(fis)){
            while(dis.available() > 0){
                empleados[0]= dis.readInt();
                empleados[1]= dis.readUTF();
                empleados[2]= dis.readUTF();
                empleados[3]= dis.readDouble();
                empleados[4]= dis.readBoolean();
                System.out.printf("Id: %d, Dni: %s, Nombre: %s, Sueldo: %.2f, Tiempo Parcial: %b\n", empleados[0], empleados[1], empleados[2], empleados[3], empleados[4]);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
