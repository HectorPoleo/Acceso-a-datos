package org.example.model;

import java.util.Objects;

public class Propietario {
    Integer id;
    String dni;
    String nombre;
    String telefono;

    public Propietario() {
    }

    public Propietario(int id) {
        this.id = id;
    }

    public Propietario(int id, String dni, String nombre, String telefono) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Propietario(String dni, String nombre, String telefono) {
        this.id = null;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Propietario that = (Propietario) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
