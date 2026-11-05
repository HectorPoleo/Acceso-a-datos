package org.example.model;

import java.util.Objects;

public class Departamentos {
    int id;
    String nombre;

    public Departamentos() {
    }

    public Departamentos(int id) {
        this.id = id;
    }

    public Departamentos(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Departamentos that = (Departamentos) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Departamentos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
