package org.example.model;

import java.util.List;
import java.util.Objects;

/**
 * Clase asignatura
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Alumno {
    String nombre;
    List<Asignatura> asignaturas;

    /**
     * Constructor vacio
     */
    public Alumno() {
    }

    /**
     * Constructor de la clase asignatura
     * @param nombre nombre del alumno
     * @param asignaturas asignaturas del alumno
     */
    public Alumno(String nombre, List<Asignatura> asignaturas) {
        this.nombre = nombre;
        this.asignaturas = asignaturas;
    }

    //GETTERS y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    /**
     * Metodo para calcular la nota media de un alumno
     * @return
     */
    public double calcularNotaMedia(){
        double sumaDeNotas= 0.0;
        for(Asignatura asignatura : asignaturas){
           sumaDeNotas += asignatura.getCalificacion();
        }
        System.out.println(sumaDeNotas/asignaturas.size());
        return sumaDeNotas/asignaturas.size();
    }

    //EQUALS y HASHCODE

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(asignaturas, alumno.asignaturas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, asignaturas);
    }

    //toString

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
