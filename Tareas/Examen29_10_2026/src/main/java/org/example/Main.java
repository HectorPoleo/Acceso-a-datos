package org.example;

import org.example.repository.Gestor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Gestor.preparaEntornoYGenerarJsonInicial();
        Gestor.escribirVehiculoRaf("Vehiculos.dat", Gestor.cargarVehiculoDesdeJson("Vehiculos.json"));
        Gestor.modificarStockRaf("Vehiculos.dat", 0,10);
        Gestor.escribirVehiculoRaf("Vehiculos.dat", Gestor.cargarVehiculoDesdeJson("Vehiculos.json"));
        Gestor.exportarBackUpCSV("Vehiculos.csv", Gestor.leerVehiculoSecuencial("Vehiculos.dat"));
    }
}