package org.example.Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Captura de múltiples excepciones no verificadas (Unchecked)
 *
 * Pide dos números enteros por consola al usuario y realiza su división. Captura
 * explícitamente InputMismatchException (si el usuario introduce texto en lugar de un
 * número) y ArithmeticException (si el usuario intenta dividir entre cero), mostrando un
 * mensaje de error personalizado para cada caso.
 *
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Ejercicio1 {

    /**
     * Metodo para hacer divisiones simples y que salten excepciones
     * en caso de input mal introducido o 0 como denominador.
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingresa un numero: ");
            int numerador = sc.nextInt();
            System.out.println("Ingrese otro numero mas: ");
            int denominador = sc.nextInt();
            int resultado = numerador/denominador;
            System.out.println("El resultado de la division = "+resultado);
        } catch (InputMismatchException e) {
            System.out.println("ERROR DE DATO INTRODUCIDO: "+e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("ERROR ARITMETICO: "+e.getMessage());
        }
        System.out.println();
    }
}
