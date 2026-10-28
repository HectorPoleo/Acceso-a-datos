package org.example;

import org.example.model.Biblioteca;
import org.example.model.Libro;
import org.example.repository.GestorBiblioteca;

public class Main {
    public static void main(String[] args) {
        GestorBiblioteca gb = new GestorBiblioteca();
        gb.generarDatosIniciales();
        Biblioteca biblioteca = gb.cargarBiblioteca();
        Libro libro = new Libro("22dd22", "Paco Juan y el fenix perdido", "Manolito", 80.0);
        biblioteca.addLibro(libro);
        gb.guardarBiblioteca(biblioteca);
    }
}