package org.example.model;

import java.util.Objects;

/**
 * Clase asignatura
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Asignatura {
    String nombre;
    double calificacion;

    /**
     * Constructor vacio
     */
    public Asignatura() {
    }

    /**
     * Constructor de la clase Asignatura
     * @param nombre
     * @param calificacion
     */
    public Asignatura(String nombre, double calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    //GETTERS y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    //HASHCODE y EQUALS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return Double.compare(calificacion, that.calificacion) == 0 && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, calificacion);
    }

    // toSTRING

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", calificacion=" + calificacion +
                '}';
    }
}
