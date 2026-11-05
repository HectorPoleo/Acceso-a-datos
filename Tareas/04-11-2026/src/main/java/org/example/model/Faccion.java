package org.example.model;

import java.util.Objects;

public class Faccion {
    String faccion;
    String ubicacion;

    public Faccion() {
    }

    public Faccion(String faccion) {
        this.faccion = faccion;
    }

    public Faccion(String faccion, String ubicacion) {
        this.faccion = faccion;
        this.ubicacion = ubicacion;
    }

    public String getFaccion() {
        return faccion;
    }

    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Faccion faccion1 = (Faccion) o;
        return Objects.equals(faccion, faccion1.faccion);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(faccion);
    }

    @Override
    public String toString() {
        return "Faccion{" +
                "faccion='" + faccion + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
