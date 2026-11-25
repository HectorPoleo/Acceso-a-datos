package org.example.model;

import org.example.connection.ConexionBBDD;

import java.sql.SQLException;
import java.util.Objects;

public class Movimiento {

    Integer id;
    Integer id_cuenta_origen;
    Integer id_cuenta_destino;
    double importe;
    String concepto;

    public Movimiento() {
        try {
            ConexionBBDD.getConnection();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Movimiento(Integer id) {
        this.id = id;
    }

    public Movimiento(Integer id_cuenta_origen, Integer id_cuenta_destino, double importe, String concepto) {
        this.id = null;
        this.id_cuenta_origen = id_cuenta_origen;
        this.id_cuenta_destino = id_cuenta_destino;
        this.importe = importe;
        this.concepto = concepto;
    }

    public Movimiento(Integer id, Integer id_cuenta_origen, Integer id_cuenta_destino, double importe, String concepto) {
        this.id = id;
        this.id_cuenta_origen = id_cuenta_origen;
        this.id_cuenta_destino = id_cuenta_destino;
        this.importe = importe;
        this.concepto = concepto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_cuenta_origen() {
        return id_cuenta_origen;
    }

    public void setId_cuenta_origen(Integer id_cuenta_origen) {
        this.id_cuenta_origen = id_cuenta_origen;
    }

    public Integer getId_cuenta_destino() {
        return id_cuenta_destino;
    }

    public void setId_cuenta_destino(Integer id_cuenta_destino) {
        this.id_cuenta_destino = id_cuenta_destino;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movimiento that = (Movimiento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}