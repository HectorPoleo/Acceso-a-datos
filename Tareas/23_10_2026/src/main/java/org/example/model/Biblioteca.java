package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase biblioteca
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Biblioteca {

    List<Libro> libros;

    /**
     * Constructor para inicializar las lista de libros
     */
    public Biblioteca() {
        libros = new ArrayList<>();
    }

    /**
     * Constructor de la clase
     * @param libros lista de libros
     */
    public Biblioteca(List<Libro> libros) {
        this.libros = libros;
    }

    //GETTERS y SETTERS

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Libro> getColeccion(){
        return libros;
    }

    /**
     * Metodo para agregar un libro a la lista
     * @param libro libro a añadir
     */
    public void addLibro(Libro libro){
        libros.add(libro);
        System.out.println("Se a añadido el libro: "+libro);
    }

    //EQUALS y HASHCODE

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

    //toSTRING

    @Override
    public String toString() {
        return "Biblioteca{" +
                "libros=" + libros +
                '}';
    }
}
