package org.example;

import org.example.repository.GestionTiendaMusicaRepository;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        new GestionTiendaMusicaRepository();
        GestionTiendaMusicaRepository.crearTablas();
        GestionTiendaMusicaRepository.insertarDatos();
        GestionTiendaMusicaRepository.consultarDatos();
        GestionTiendaMusicaRepository.modificarDatos();
        GestionTiendaMusicaRepository.consultarDatos();
        GestionTiendaMusicaRepository.deleteData();
        GestionTiendaMusicaRepository.consultarDatos();

    }
}