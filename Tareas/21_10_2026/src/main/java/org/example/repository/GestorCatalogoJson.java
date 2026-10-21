package org.example.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.Director;
import org.example.model.Pelicula;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de los metodos para gestionar un catalogo y sus peliculas
 * @author hectorpoleo
 * @version 1.0.0
 */
public class GestorCatalogoJson {
    static List<Pelicula> peliculas = new ArrayList<>();

    /**
     * Metodo para leer el fichero json que contiene el catalogo
     */
    public void cargarCatalogo(){
        Gson json = new Gson();
        try (FileReader fr = new FileReader("Peliculas.json")){
            Type tipoArrayList = new TypeToken<List<Pelicula>>(){}.getType();
            peliculas = json.fromJson(fr, tipoArrayList);
            System.out.println(peliculas);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para guardar peliculas en el catalogo
     * @param pelicula pelicula a agregar al catalogo
     */
    public void guardarCatalogo(Pelicula pelicula){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        peliculas.add(pelicula);
        try (FileWriter fw = new FileWriter("Peliculas.json")){
            json.toJson(peliculas, fw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
