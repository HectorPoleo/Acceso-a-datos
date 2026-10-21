package org.example.model;

import java.util.Objects;

/**
 * Clase de Director
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Director {

    String nombre;
    String nacionalidad;

    /**
     * Contructor vacio
     */
    public Director() {
    }

    /**
     * Constructor de Director
     * @param nombre nombre del director
     * @param nacionalidad nacionalidad del director
     */
    public Director(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    //GETTERS y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    //HASHCODE y EQUALS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return Objects.equals(nombre, director.nombre) && Objects.equals(nacionalidad, director.nacionalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nacionalidad);
    }

    //toSTRING

    @Override
    public String toString() {
        return "Director{" +
                "nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
