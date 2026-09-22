package org.example.Explicaciones;

/**
 * @author hectorpoleo
 * @version 1.0.0
 */
public class VariasExcepciones {

    /**
     * Metodo para generar valores dentro de la matriz en funcion del valor de j e i
     * @param args
     */
    public static void main(String[] args) {
        int lineas = 2;
        int columnas = 3;
        int[][] matriz = new int[lineas][columnas];

        for (int i = 0; i < lineas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j]= i+j;
                System.out.printf("%d \t",matriz[i][j]);
            }
            System.out.println();
        }
    }

}

