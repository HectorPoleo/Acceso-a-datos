package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase de Pelicula
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Pelicula {
    int id;
    String titulo;
    int duracionMin;
    Director director;
    List<String> reparto;

    /**
     * Constructor vacio
     */
    public Pelicula() {
    }

    /**
     * Constructor del id de la pelicula
     * @param id id de la pelicula
     */
    public Pelicula(int id) {
        this.id = id;
    }

    /**
     * Constructor de la clase Pelicula
     * @param id id de la pelicula
     * @param titulo titulo de la pelicula
     * @param duracionMin duracion en minutos de la pelicula
     * @param director director de la pelicula
     * @param reparto reparto de la pelicula
     */
    public Pelicula(int id, String titulo, int duracionMin, Director director, List<String> reparto) {
        this.id = id;
        this.titulo = titulo;
        this.duracionMin = duracionMin;
        this.director = director;
        this.reparto = reparto;
    }

    //GETTERS y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<String> getReparto() {
        return reparto;
    }

    public void setReparto(List<String> reparto) {
        this.reparto = reparto;
    }

    //HASHCODE y EQUALS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return id == pelicula.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //toString

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", duracionMin=" + duracionMin +
                ", director=" + director +
                ", reparto=" + reparto +
                '}';
    }
}
