package org.example.Ejercicios.model;

import java.util.Objects;

public class Empleado {

    Integer numEmpleado;
    String dni;
    String nombre;
    Double salarioBrutoAnual;
    Boolean tiempoPracial;

    public Empleado() {
    }

    public Empleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public Empleado(Integer numEmpleado, String dni, String nombre, Double salarioBrutoAnual, Boolean tiempoPracial) {
        this.numEmpleado = numEmpleado;
        this.dni = dni;
        this.nombre = nombre;
        this.salarioBrutoAnual = salarioBrutoAnual;
        this.tiempoPracial = tiempoPracial;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getSalarioBrutoAnual() {
        return salarioBrutoAnual;
    }

    public Boolean getTiempoPracial() {
        return tiempoPracial;
    }

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalarioBrutoAnual(Double salarioBrutoAnual) {
        this.salarioBrutoAnual = salarioBrutoAnual;
    }

    public void setTiempoPracial(Boolean tiempoPracial) {
        this.tiempoPracial = tiempoPracial;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(numEmpleado, empleado.numEmpleado);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numEmpleado);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "numEmpleado=" + numEmpleado +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", salarioBrutoAnual=" + salarioBrutoAnual +
                ", tiempoPracial=" + tiempoPracial +
                '}';
    }
}
