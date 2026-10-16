package org.example.tarea.model;

import java.util.Objects;

public class VideoJuego {
    Integer id;
    String titulo;
    Double precio;

    /**
     * Constructor vacio
     */
    public VideoJuego() {

    }

    /**
     * Constructor del id
     * @param id id del videojuegp
     */
    public VideoJuego(Integer id) {
        this.id = id;
    }

    /**
     * Constructor del objetp
     * @param id id del videojuego
     * @param titulo titulo del videojuego
     * @param precio precio del videojuego
     */
    public VideoJuego(Integer id, String titulo, Double precio) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
    }

    //GETTERS y SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio){
        this.precio = precio;
    }

    // EQUALS y HASHCODE

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VideoJuego that = (VideoJuego) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //ToSTRING

    @Override
    public String toString() {
        return "videoJuego{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
