package org.example.model;

import org.example.connection.ConexionBBDD;

import java.sql.SQLException;
import java.util.Objects;

public class Cuenta {

    Integer id;
    String iban;
    String titular;
    double saldo;

    public Cuenta() {
        try {
            ConexionBBDD.getConnection();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Cuenta(Integer id, String iban) {
        this.id = id;
        this.iban = iban;
    }

    public Cuenta(String iban, String titular, double saldo) {
        this.id = null;
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;
    }

    public Cuenta(Integer id, String iban, String titular, double saldo) {
        this.id = id;
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;
    }

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
}
