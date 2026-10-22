package org.example.model;

import java.util.List;
import java.util.Objects;

public class Alumno {
    String nombre;
    List<Asignatura> asignaturas;

    public Alumno() {
    }

    public Alumno(String nombre, List<Asignatura> asignaturas) {
        this.nombre = nombre;
        this.asignaturas = asignaturas;
    }

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

    double calcularNotaMedia(){
        double sumaDeNotas= 0.0;
        for(Asignatura asignatura : asignaturas){
           sumaDeNotas += asignatura.getCalificacion();
        }
        return sumaDeNotas/asignaturas.size();
    }

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

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
