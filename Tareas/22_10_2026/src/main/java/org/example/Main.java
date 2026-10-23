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
        if(ge.getExpedientes().isEmpty() || ge.getExpedientes() == null){
            ge.generarDatosIniciales();
            ge.guardarExpediente(ge.getExpedientes(), ruta);
        }
        System.out.println("Primero: "+ ge.getExpedientes().firstEntry());
        System.out.println("Ultima: "+ ge.getExpedientes().lastEntry());

        ge.getExpedientes().get("EA13").getAsignaturas().add(new Asignatura("Religion", 10.0));
        System.out.println(ge.getExpedientes().get("EA13").calcularNotaMedia());

        ge.guardarExpediente(ge.getExpedientes(), ruta);
        ge.cargarExpediente(ruta);
        ge.imprimirMap(ge.getExpedientes());

    }
}