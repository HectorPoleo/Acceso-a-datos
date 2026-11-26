package org.example.model;

import org.example.connection.ConexionBBDD;

import java.sql.SQLException;
import java.util.Objects;

/**
 * Clase de el objeto Cuenta
 */
public class Cuenta {

    Integer id;
    String iban;
    String titular;
    double saldo;

    /**
     * Constructor vacio en el que se inicializa al conexion a la base de datos
     */
    public Cuenta() {
        try {
            ConexionBBDD.getConnection();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Constructor con los identificadores
     * @param id
     * @param iban
     */
    public Cuenta(Integer id, String iban) {
        this.id = id;
        this.iban = iban;
    }

    /**
     * Constructor de objeto
     * @param iban identificador de la cuenta
     * @param titular titular de la cuenta
     * @param saldo saldo de la cuenta
     */
    public Cuenta(String iban, String titular, double saldo) {
        this.id = null;
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;
    }

    /**
     * Constructor del objeto con id
     * @param id identificador dentro de la base de datos
     * @param iban identificador de la cuenta
     * @param titular titular de la cuenta
     * @param saldo saldo de la cuenta
     */
    public Cuenta(Integer id, String iban, String titular, double saldo) {
        this.id = id;
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;
    }


    //GETTERS y SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //HAShCODE y EQUALS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(id, cuenta.id) && Objects.equals(iban, cuenta.iban);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iban);
    }

    //toString

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
