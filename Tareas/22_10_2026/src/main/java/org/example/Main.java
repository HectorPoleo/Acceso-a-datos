package org.example;

import org.example.model.Alumno;
import org.example.model.Asignatura;
import org.example.repository.GestorExpedienteTreeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {
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
        ge.imprimirMap(ge.getExpedientes());
    }
}