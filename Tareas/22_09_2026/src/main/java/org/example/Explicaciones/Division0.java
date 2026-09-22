package org.example.Explicaciones;

/**
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Division0 {
    public static void main(String[] args) {

        int a,b,resultado;
        //Primer caso
        a = 6;
        b = 2;
        resultado = a/b;
        System.out.printf("El resultado de dividir %d/%d es %d ",a,b,resultado);

        //Segundo caso
        b=0;
        try {
            resultado = a/b;
        }catch (ArithmeticException e){
            System.out.println("ERROR: Ha ocurrido una excepcion: "+ e.getMessage());
        }

        //Tercer caso
        b=20;
        resultado = a/b;
        System.out.printf("El resultado de dividir %d/%d es %d ",a,b,resultado);


    }
}
