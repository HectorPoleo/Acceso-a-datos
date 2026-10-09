package org.example.Ejercicios.Ejercicio1;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Ejercicio 1: Datos Elementales en Ficheros Binarios (DataOutputStream y DataInputStream)
 * Desarrolla una aplicación en Java organizada en dos clases independientes
 * para gestionar el inventario simplificado de una tienda mediante flujos de datos
 * binarios primitivos.
 * La finalidad es guardar la información de varios productos en un archivo llamado
 * productos.dat y, posteriormente, recuperarla respetando el orden secuencial de los
 * datos.
 * • LectorBinario: Lee el fichero productos.dat con DataInputStream utilizando un
 * bucle while (dis.available() > 0) para comprobar si quedan bytes pendientes de
 * lectura antes de cada iteración.
 * @author HectorPoleo
 * @version 1.0.0
 */
public class Lector {
    /**
     * Metodo para leer un fichero serializado
     * @param args
     */
    public static void main(String[] args) {
        String path = "productos.dat";
        Object[] inventario = new Object[3];
        try (FileInputStream fis = new FileInputStream(path);
             DataInputStream dis = new DataInputStream(fis)){
            while(dis.available() > 0){
                inventario[0]= dis.readInt();
                inventario[1]= dis.readUTF();
                inventario[2]= dis.readDouble();
                System.out.printf("Id: %d, Nombre Producto: %s, Precio: %.2f\n", inventario[0], inventario[1], inventario[2]);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
