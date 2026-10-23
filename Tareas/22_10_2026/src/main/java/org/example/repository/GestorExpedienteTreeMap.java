package org.example.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sun.source.tree.Tree;
import org.example.model.Alumno;
import org.example.model.Asignatura;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Clase de gestor de expediente con TreeMap
 * @author hectorpoleo
 * @version 1.0.0
 */
public class GestorExpedienteTreeMap {
    public static TreeMap<String, Alumno> expedientes = new TreeMap<>();

    /**
     * Metodo para cargar los expedientes del fichero
     * @param ruta ruta del fichero
     */
    public TreeMap<String, Alumno> cargarExpediente(String ruta) {
        Gson json = new Gson();
        File file = new File(ruta);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileReader fr = new FileReader(ruta)) {
                Type tipoArrayList = new TypeToken<TreeMap<String, Alumno>>() {}.getType();
                TreeMap<String, Alumno> leido = json.fromJson(fr, tipoArrayList);
                return expedientes = (leido != null) ? leido : new TreeMap<>();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para guardar un expediente en el fichero
     * @param alumno alumno del cual se va a guardar el expediente
     * @param ruta ruta del fichero
     */
    public void guardarExpediente(TreeMap<String, Alumno> map, String ruta){
        Gson json = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        try (FileWriter fw = new FileWriter(ruta)){
            json.toJson(expedientes, fw);
        } catch (IOException e){
            System.out.println("ERROR: " +e.getMessage());
        }
    }

    /**
     * Metodo para imprimir en terminal los expedientes
     * @param expedientesnuevos expedientes a imprimir
     */
    public void imprimirMap(TreeMap<String, Alumno> expedientesnuevos){
        Set<String> set = expedientesnuevos.keySet();
        Object[] keys = set.toArray();
        for (Object key : keys){
            Alumno alumno = expedientesnuevos.get(key);
            System.out.println(key.toString()+" "+alumno);
        }
    }

    /**
     * Metodo para generar datos iniciales en el fichero
     */
    public void generarDatosIniciales(){
        expedientes.put("EA12", new Alumno("Hitler", new ArrayList<>(List.of(new Asignatura("Artes", 0.0)))));
        expedientes.put("EA13", new Alumno("Jeanne D"+'\''+"Arc", new ArrayList<>(List.of(new Asignatura("Historia de Francia", 10)))));
        expedientes.put("EA14", new Alumno("Yutirannus", new ArrayList<>(List.of(new Asignatura("Historia del Cretacico", 10.0)))));
    }

    public TreeMap<String , Alumno> getExpedientes(){
        return expedientes;
    }

    public static void main(String[] args) {
        String ruta = "Expedientes.json";
        GestorExpedienteTreeMap ge = new GestorExpedienteTreeMap();
        expedientes = ge.cargarExpediente(ruta);
        ge.generarDatosIniciales();
        Asignatura asignatura = new Asignatura("Historia de espanya", 10.0);
        List<Asignatura> asig1 = new ArrayList<>();
        asig1.add(asignatura);
        Alumno alumno1 = new Alumno("Franco", asig1);
        ge.guardarExpediente(expedientes, ruta);
        ge.imprimirMap(expedientes);
    }
}