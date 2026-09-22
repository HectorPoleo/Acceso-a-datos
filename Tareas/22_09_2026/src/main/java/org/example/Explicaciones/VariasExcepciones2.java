package org.example.Explicaciones;

/**
 * @author hectorpoleo
 * @version 1.0.0
 */
public class VariasExcepciones2 {
    public static void main(String[] args) {
        int lineas = 3;
        int columnas = 3;
        int[][] matriz = new int[lineas][columnas];

        for (int i = 0; i <= lineas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("Segunda cifra de 5*matriz[%d][%d]: ",i,j,j);
                try {
                    System.out.println("La segunda cifra es: "+String.valueOf(5*matriz[i][j]/j).charAt(1));
                }catch (ArithmeticException e){
                    System.out.println("ERROR ARITMETICO: "+e.getMessage());
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("ERROR DE INDICE: "+e.getMessage());
                }catch (Exception e){
                    System.out.println("OTRO TIPO DE ERROR: "+e.getMessage());
                }
            }
            System.out.println();
        }


    }
}
