package org.example.Ejercicios;

import org.example.Ejercicios.model.Empleado;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 1: Gestión e Integridad de Datos de Empleados en Formato CSV
 * 1. Modelo de Dominio (Empleado.java): Diseña la clase de entidad Empleado para almacenar la
 * información del personal.
 * • Atributos:
 * ◦ numEmpleado (Integer): Número identificador de empleado.
 * ◦ dni (String): Documento Nacional de Identidad.
 * ◦ nombre (String): Nombre completo del empleado.
 * ◦ salarioBrutoAnual (Double): Remuneración económica con decimales.
 * ◦ tiempoParcial (Boolean): Indicador de jornada laboral (representado
 * obligatoriamente como un valor booleano en la clase).
 * • Requisitos: Incluir constructor parametrizado, metodo (getter) y sobrescribir
 * el metodo toString() para mostrar por pantalla el estado del objeto.
 * 2. Escritura de Datos (EscribeEmpleadosCSV.java): Crea una clase ejecutable con metodo main que
 * persista una colección de empleados en disco.
 * 1. Instancia una lista (ArrayList<Empleado>) con al menos 5 registros de prueba. Incluye
 * intencionadamente registros válidos y registros con el DNI o el nombre no
 * informados (null o vacío) para probar posteriormente los mecanismos de validación.
 * 2. Utiliza FileWriter y BufferedWriter dentro de un bloque try-with-resources para
 * escribir los datos en un archivo llamado empleados.csv.
 * 3. Emplea el punto y coma (;) como separador de campos.
 * 4. Transformación especial: El campo booleano tiempoParcial debe convertirse a 1 si es
 * verdadero (true) o a 0 si es falso (false) al momento de escribirse en el fichero.
 * 3. Lectura, Parseo y Validación (LeeEmpleadosCSV.java): Crea una clase ejecutable con metodo main
 * que lea el fichero generado anteriormente e imprima los empleados válidos por consola conforme
 * los procesa.
 * 1. Abre y recorre el fichero empleados.csv línea a línea utilizando FileReader y
 * BufferedReader.
 * 2. Divide cada línea usando linea.split(";", -1) para evitar omitir columnas vacías al final
 * del registro.
 * 3. Regla de integridad: Ni el dni ni el nombre pueden ser nulos o estar vacíos. Si alguna
 * línea no tiene informados estos campos, el programa debe mostrar un mensaje de
 * error explícito indicando el número de línea y continuar inmediatamente con la
 * lectura del resto de líneas sin detener la ejecución.
 * 4. Transforma el valor 1 o 0 del fichero al correspondiente booleano true o false para
 * reinstanciar el objeto Empleado.
 *
 * @author HectorPoleo
 * @version 1.0.0
 */
public class Ejercicio1 {

    public static void main(String[] args) {

    }
}
