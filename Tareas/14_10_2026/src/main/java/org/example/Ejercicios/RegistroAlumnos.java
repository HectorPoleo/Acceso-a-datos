package org.example.Ejercicios;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RegistroAlumnos {
    private static final int TAMANO_REGISTRO= 12;

    public static void main(String[] args) {
        String fichero = "alumnos.dat";

        try (var raf = new RandomAccessFile(fichero, "rw")){
            EscribirRegistros(raf,12,1,9.5);
            EscribirRegistros(raf,13,2,9.5);
            EscribirRegistros(raf,14,3,9.5);
            LeerRegistros(raf,13);
        }catch (IOException e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void EscribirRegistros(RandomAccessFile raf,int numeroRegistro,int id, double nota) throws IOException {
        long posicion = (long)numeroRegistro*TAMANO_REGISTRO;
        raf.seek(posicion);
        raf.writeInt(id);
        raf.writeDouble(nota);
    }

    public static void LeerRegistros(RandomAccessFile raf, int numRegistro) throws IOException {
        long posicion = (long)numRegistro*TAMANO_REGISTRO;
        raf.seek(posicion);
        int identificador = raf.readInt();
        double nota = raf.readDouble();
        System.out.printf("El registro numero %d tiene en el ID: %d y la nota %f \n",numRegistro,identificador,nota);
    }
}
