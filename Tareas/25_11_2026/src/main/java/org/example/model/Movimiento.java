package org.example.model;

import org.example.connection.ConexionBBDD;

import java.sql.SQLException;
import java.util.Objects;

/**
 * Clase del objeto movimiento
 */
public class Movimiento {

    Integer id;
    Integer id_cuenta_origen;
    Integer id_cuenta_destino;
    double importe;
    String concepto;

    /**
     * Constructor vacio para inicializar la base de datos
     */
    public Movimiento() {
        try {
            ConexionBBDD.getConnection();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Constructor del identificador
     * @param id identifidacor del movimiento en la base de datos
     */
    public Movimiento(Integer id) {
        this.id = id;
    }

    /**
     * Constructor del objeto
     * @param id_cuenta_origen identicador de la cuenta de origen
     * @param id_cuenta_destino identificador de la cuenta de destino
     * @param importe importe de la transferencia
     * @param concepto concepto de la transferencia
     */
    public Movimiento(Integer id_cuenta_origen, Integer id_cuenta_destino, double importe, String concepto) {
        this.id = null;
        this.id_cuenta_origen = id_cuenta_origen;
        this.id_cuenta_destino = id_cuenta_destino;
        this.importe = importe;
        this.concepto = concepto;
    }

    /**
     * Constructor del objeto con el id
     * @param id identificador en la base de datos
     * @param id_cuenta_origen identicador de la cuenta de origen
     * @param id_cuenta_destino identificador de la cuenta de destino
     * @param importe importe de la transferencia
     * @param concepto concepto de la transferencia
     */
    public Movimiento(Integer id, Integer id_cuenta_origen, Integer id_cuenta_destino, double importe, String concepto) {
        this.id = id;
        this.id_cuenta_origen = id_cuenta_origen;
        this.id_cuenta_destino = id_cuenta_destino;
        this.importe = importe;
        this.concepto = concepto;
    }

    //GETTERS Y SETTERS

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

    //HASHCODE Y EQUALS

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

    //toString

    @Override
    public String toString() {
        return "Movimiento{" +
                "id=" + id +
                ", id_cuenta_origen=" + id_cuenta_origen +
                ", id_cuenta_destino=" + id_cuenta_destino +
                ", importe=" + importe +
                ", concepto='" + concepto + '\'' +
                '}';
    }
}