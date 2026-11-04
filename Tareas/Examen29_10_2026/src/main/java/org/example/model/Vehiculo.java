package org.example.model;

import java.util.Objects;

/**
 * Clase de vehiculo
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Vehiculo {
    Integer id;
    String marca;
    Double precio;
    Integer stock;

    /**
     * Constructor vacio
     */
    public Vehiculo() {
    }

    /**
     * Constructor del identificador
     * @param id
     */
    public Vehiculo(Integer id) {
        this.id = id;
    }

    /**
     * Constructor de la clase
     * @param id id del vehiculo
     * @param marca marca del vehiculo
     * @param precio precio del vehiculo
     * @param stock stock del vehiculo
     */
    public Vehiculo(Integer id, String marca, Double precio, Integer stock) {
        this.id = id;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }

    //GETTERS y SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    //HASHCODE y EQUALS
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(id, vehiculo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //toSTRING
    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
