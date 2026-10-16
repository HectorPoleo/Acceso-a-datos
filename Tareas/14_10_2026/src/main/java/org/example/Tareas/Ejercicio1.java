package org.example.Tareas;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Ejercicio 1: Gestión de Cuentas Bancarias con RandomAccessFile
 * Desarrolla una aplicación en Java llamada GestorCuentasAleatorio.java que utilice la clase
 * RandomAccessFile en modo lectura y escritura ("rw") para administrar ficheros de acceso aleatorio
 * basados en registros de longitud fija.
 * El sistema gestionará cuentas bancarias fijando un tamaño de 32 bytes por registro estructurado de
 * la siguiente forma:
 * • ID de cuenta (int): 4 bytes.
 * • Titular (String de 10 caracteres fijos / 20 bytes en caracteres Java): 20 bytes.
 * • Saldo (double): 8 bytes.
 * El programa debe implementar los siguientes métodos dentro de una misma clase ejecutable:
 * 1. escribirCuenta(int nReg, int id, String titular, double saldo): Posiciona el puntero en la
 * posición adecuada (posicion = nReg * 32) y escribe o sobrescribe la información de la
 * cuenta.
 * 2. leerCuenta(int nReg): Recupera y muestra por consola los datos de la cuenta situada
 * en dicho número de registro.
 * 3. actualizarSaldo(int nReg, double incremento): Lee únicamente el saldo del registro
 * indicado, le suma la cantidad especificada y sobrescribe únicamente el valor del saldo
 * en el fichero sin modificar el resto de campos.
 *
 * @author HectorPoleo
 * @version 1.0.0
 */
public class Ejercicio1 {
    private static final int TAMANO_REGISTRO= 32;
    private static final int LONG_TITULAR= 10;
    private static final int OFFSET_SALDO = 24;

    public static void main(String[] args) {
        String fichero = "Registro.dat";

        try (var raf = new RandomAccessFile(fichero, "rw")){
            EscribirRegistro(raf, 1, 12, "Jose", 2000.0);
            LeerRegistro(raf, 1);
            ActualizarSaldo(raf, 1,500.0);
            LeerRegistro(raf, 1);
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }

    }

    /**
     * Metodo para escribir un registro en el ficherp definido
     * @param raf RandomAccessFile
     * @param nReg numero de registro
     * @param idCuenta id de la cuenta
     * @param titular titular de la cuenta
     * @param saldo saldo actual de la cuenta
     * @throws IOException
     */
    public static void EscribirRegistro(RandomAccessFile raf, int nReg, int idCuenta, String titular, double saldo) throws IOException {
        long posicion = (long)nReg*TAMANO_REGISTRO;
        raf.seek(posicion);
        raf.writeInt(idCuenta);
        raf.writeChars(AjustarTitular(titular));
        raf.writeDouble(saldo);
    }

    /**
     * Metodo para leer un registro
     * @param raf RandomAccessfile
     * @param nReg numero de registro
     * @throws IOException
     */
    public static void LeerRegistro(RandomAccessFile raf, int nReg) throws IOException {
        long posicion = (long)nReg*TAMANO_REGISTRO;
        raf.seek(posicion);
        int identificador = raf.readInt();
        char[] letras = new char[LONG_TITULAR];
        for (int i = 0; i < LONG_TITULAR; i++) {
            letras[i] = raf.readChar();
        }
        String titular = new String(letras).trim();
        double saldo = raf.readDouble();
        System.out.printf("El registro numero %d tiene en el ID: %d, Titular: %s y la saldo: %f \n",nReg,identificador,titular,saldo);
    }

    /**
     * Metodo para actualizar el saldo de una cuenta
     * @param raf RandomAccessFile
     * @param nReg numero de registro de la cuenta
     * @param incremento cantidadd a incrementar en el sueldo
     * @throws IOException
     */
    public static void ActualizarSaldo(RandomAccessFile raf, int nReg, double incremento) throws IOException {
        long posSaldo = (long) nReg*TAMANO_REGISTRO + OFFSET_SALDO;
        raf.seek(posSaldo);
        double saldoActual = raf.readDouble();
        raf.seek(posSaldo);
        raf.writeDouble(saldoActual+incremento);
    }

    /**
     * Metodo para forzar al titular a ocupar 10 bytes
     * @param titular titular a forzar a 10 bytes
     * @return
     */
    public static String AjustarTitular(String titular){
        StringBuffer sb = new StringBuffer(titular);
        sb.setLength(LONG_TITULAR);
        return sb.toString().replace('\0', ' ');
    }
}
