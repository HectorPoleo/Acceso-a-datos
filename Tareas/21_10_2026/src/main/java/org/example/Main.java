package org.example;

import org.example.model.Director;
import org.example.model.Pelicula;
import org.example.repository.GestorCatalogoJson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Main {
    public static void main(String[] args) {

        Director director = new Director("Juan Estebam", "Portuges");

        List<String> reparto = new ArrayList<>();
        reparto.add("Belen Estebam");

        Pelicula pelicula = new Pelicula(1, "Los pinguinos de madagascar", 120, director, reparto);

        GestorCatalogoJson gr = new GestorCatalogoJson();
        gr.guardarCatalogo(pelicula);
        gr.cargarCatalogo();
    }
}