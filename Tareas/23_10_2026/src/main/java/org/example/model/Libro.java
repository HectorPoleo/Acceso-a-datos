package org.example.model;

import java.util.Objects;

/**
 * Clase libro
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Libro {
    String isbn;
    String titulo;
    String autor;
    double precio;

    /**
     * Constructor vacio
     */
    public Libro() {
    }

    /**
     * Constructor del identificador
     * @param isbn identificaador del libro
     */
    public Libro(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Constructor de la clase
     * @param isbn identificador del libro
     * @param titulo titulo del libro
     * @param autor autor del libro
     * @param precio precio del libro
     */
    public Libro(String isbn, String titulo, String autor, double precio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    //GETTERS y SETTERS

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //HASHCODE y EQUALS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    //toSTRING

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", precio=" + precio +
                '}';
    }
}
