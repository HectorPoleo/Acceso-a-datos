package org.example.tarea.repository;

import com.google.gson.Gson;
import org.example.tarea.model.VideoJuego;

import java.io.FileReader;
import java.io.IOException;

/**
 * LeeVideojuegoJSON.java (Lectura):
 * • Lee el archivo videojuego.json y reconstruye la instancia original de Videojuego.
 * • Deserializa un segundo objeto Videojuego directamente a partir de una cadena de
 * texto (String) formateada en JSON.
 * • Muestra ambos objetos por consola.
 * @author hectorpoleo
 * @version 1.0.0
 */
public class LeeVideojuegoJSON {

    /**
     * Metodo para leer un fichero json
     * @param args
     */
    public static void main(String[] args) {
        Gson json = new Gson();
        try (FileReader fr = new FileReader("videojuego.json")){
            VideoJuego videoJuego = json.fromJson(fr, VideoJuego.class);
            System.out.println(videoJuego);
            String strJson = "{\"id\":1, \"titulo\": \"Minecraft\", \"precio\": 20.0}";
            VideoJuego prDeStr = json.fromJson(strJson, VideoJuego.class);
            System.out.println(prDeStr);
        }catch (IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }
}
