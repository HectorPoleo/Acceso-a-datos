package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Biblioteca {

    List<Libro> libros;

    public Biblioteca() {
    }

    public Biblioteca(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Libro> getColeccion(){
        return libros;
    }

    public void addLibro(Libro libro){
        libros.add(libro);
        System.out.println("Se a añadido el libro: "+libro);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Biblioteca that = (Biblioteca) o;
        return Objects.equals(libros, that.libros);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(libros);
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "libros=" + libros +
                '}';
    }
}
