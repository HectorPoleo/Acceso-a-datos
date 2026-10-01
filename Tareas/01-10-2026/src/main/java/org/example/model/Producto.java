package org.example.model;

import java.util.Objects;

public class Producto {
    Integer cod;
    String descr;
    Double prUnit;

    public Producto(Integer cod){
        this.cod = cod;
    }
    public Producto(Integer cod, String descr, Double prUnit) {
        this.cod = cod;
        this.descr = descr;
        this.prUnit = prUnit;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Double getPrUnit() {
        return prUnit;
    }

    public void setPrUnit(Double prUnit) {
        this.prUnit = prUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(cod, producto.cod);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cod);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "cod=" + cod +
                ", descr='" + descr + '\'' +
                ", prUnit=" + prUnit +
                '}';
    }
}
