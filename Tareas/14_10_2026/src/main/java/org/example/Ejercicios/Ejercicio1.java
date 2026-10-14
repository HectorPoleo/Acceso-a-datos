package org.example.Ejercicios;

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        String fichero = "HolaMundo.txt";
        try (var raf = new RandomAccessFile(fichero, "rw")){
            raf.writeBytes("Hola mundo java");

            raf.seek(0);
            byte[]buffer = new byte[5];
            raf.read(buffer);
            System.out.println("He leído la primera palabra "+ new String(buffer));

            int skipb = raf.skipBytes(5);
            System.out.println("He avanzado numero de bytes: " + skipb);
            raf.read(buffer);
            System.out.println("He leido la palabra: "+new String(buffer));

        } catch (IOException e){
            System.out.println("ERROR: " +e.getMessage());

        }
    }
}
