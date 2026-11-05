package org.example.model;

import java.util.Objects;

public class Empleados {
    int id;
    String nombre;
    int id_departamento;

    public Empleados() {
    }

    public Empleados(int id) {
        this.id = id;
    }

    public Empleados(int id, String nombre, Departamentos id_departamento) {
        this.id = id;
        this.nombre = nombre;
        this.id_departamento = id_departamento.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleados empleados = (Empleados) o;
        return id == empleados.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", id_departamento=" + id_departamento +
                '}';
    }
}
