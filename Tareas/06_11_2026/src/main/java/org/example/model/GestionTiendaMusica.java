package org.example.model;


import org.example.connection.ConnectionMYSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class GestionTiendaMusica extends ConnectionMYSQL {
    int id;
    String nombre;
    String pais;

    public GestionTiendaMusica() throws SQLException {
        super();

    }

    public GestionTiendaMusica(int id) {
        this.id = id;
    }

    public GestionTiendaMusica(int id, String nombre, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GestionTiendaMusica that = (GestionTiendaMusica) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "GestionTiendaMusica{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
