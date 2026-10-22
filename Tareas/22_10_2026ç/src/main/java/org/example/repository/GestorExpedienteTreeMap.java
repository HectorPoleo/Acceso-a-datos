package org.example.repository;

import  com.google.gson.GsonBuilder;
import  com.google.gson.reflect.TypeToken;
import org.example.model.Alumno;

import java.util.Map;
import java.util.TreeMap;

public class GestorExpedienteTreeMap {
    static TreeMap<String, Alumno> expedientes = new TreeMap<>();

    void cargarExpediente(String ruta){
    Gson json = new Gson();
    try (FileReader fr = new FileReader(ruta)){
        Type tipoArrayList = new TypeToken<TreeMap<String, Alumno>>(){}.getType();
    }
    }
}
