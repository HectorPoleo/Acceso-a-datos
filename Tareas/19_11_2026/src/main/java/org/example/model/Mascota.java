package org.example.model;

import java.util.Objects;

public class Mascota {
    Integer id;
    String nombre;
    String especie;
    Double peso;
    Integer idPropietario;

    public Mascota() {
    }

    public Mascota(Integer id) {
        this.id = id;
    }

    public Mascota(Integer id, String nombre, String especie, Double peso, Integer idPropietario) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.peso = peso;
        this.idPropietario = idPropietario;
    }

    public Mascota(String nombre, String especie, Double peso, Integer idPropietario) {
        this.id = null;
        this.nombre = nombre;
        this.especie = especie;
        this.peso = peso;
        this.idPropietario = idPropietario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mascota mascota = (Mascota) o;
        return Objects.equals(id, mascota.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", peso=" + peso +
                ", idPropietario=" + idPropietario +
                '}';
    }
}
