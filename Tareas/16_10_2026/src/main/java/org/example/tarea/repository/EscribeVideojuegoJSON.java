package org.example.tarea.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.tarea.model.VideoJuego;

import java.io.FileWriter;
import java.io.IOException;

/**
 * EscribeVideojuegoJSON.java (Escritura):
 * • Crea un objeto Videojuego.
 * • Utiliza GsonBuilder para configurar la serialización con formato legible (pretty
 * printing) e inclusión de nulos.
 * • Guarda el objeto en un archivo llamado videojuego.json.
 * @author hectorpoleo
 * @version 1.0.0
 */
public class EscribeVideojuegoJSON {

    /**
     * Metodo para escribir un videojuego en un json con formato
     * @param args
     */
    public static void main(String[] args) {
        VideoJuego videoJuego = new VideoJuego(1,"Minecraft",20.0);
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter fw = new FileWriter("videojuego.json")){
            json.toJson(videoJuego, fw);
            System.out.println("Se ha escrito el videojuego: "+ videoJuego);
        }catch (IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }
}
