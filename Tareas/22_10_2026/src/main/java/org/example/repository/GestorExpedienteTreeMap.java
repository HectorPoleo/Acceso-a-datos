package org.example.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.Alumno;
import org.example.model.Asignatura;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class GestorExpedienteTreeMap {
    static TreeMap<String, Alumno> expedientes = new TreeMap<>();

    void cargarExpediente(String ruta) {
        Gson json = new Gson();
        File file = new File(ruta);

        try (FileReader fr = new FileReader(ruta)) {
            if(!file.exists()){
                file.createNewFile();
            }
            Type tipoArrayList = new TypeToken<TreeMap<String, Alumno>>() {
            }.getType();
            expedientes = json.fromJson(fr, tipoArrayList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void guardarExpediente(Alumno alumno, String ruta){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        expedientes.put("EA11", alumno);
        try (FileWriter fw = new FileWriter(ruta)){
            json.toJson(expedientes, fw);
        } catch (IOException e){
            System.out.println("ERROR: " +e.getMessage());
        }
    }

    void imprimirMap(TreeMap<String, Alumno> expedientesnuevos){
        Set<String> set = expedientesnuevos.keySet();
        Object[] keys = set.toArray();
        for (Object key : keys){
            Alumno alumno = expedientesnuevos.get(key);
            System.out.println(key.toString()+" "+alumno);
        }
    }

    void generarDatosIniciales(){
        expedientes.put("EA12", new Alumno("Hitler", new ArrayList<>(List.of(new Asignatura("Artes", 0.0)))));
        expedientes.put("EA13", new Alumno("Jeanne D'Arc", new ArrayList<>(List.of(new Asignatura("Historia de Francia", 10)))));
        expedientes.put("EA14", new Alumno("Yutirannus", new ArrayList<>(List.of(new Asignatura("Historia del Cretacico", 10.0)))));
    }

    public static void main(String[] args) {
        String ruta = "Expedientes.json";
        GestorExpedienteTreeMap ge = new GestorExpedienteTreeMap();
        ge.cargarExpediente(ruta);
        ge.generarDatosIniciales();
        Asignatura asignatura = new Asignatura("Historia de espanya", 10.0);
        List<Asignatura> asig1 = new ArrayList<>();
        asig1.add(asignatura);
        Alumno alumno1 = new Alumno("Franco", asig1);
        ge.guardarExpediente(alumno1, ruta);
        ge.imprimirMap(expedientes);
    }
}
