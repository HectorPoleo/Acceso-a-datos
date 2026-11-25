package org.example;

import org.example.connection.DataBaseConnection;
import org.example.model.Mascota;
import org.example.model.Propietario;
import org.example.repository.MascotaRepository;
import org.example.repository.PropietarioRepository;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        Propietario propietario = new Propietario("44015400c","Enrique",null);
        Mascota mascota = new Mascota(10,"Asteroid Destroyer 2", "perro", 20.0, 2);
        PropietarioRepository pr = new PropietarioRepository();
        MascotaRepository mr = new MascotaRepository();
        pr.insertarPropietario(propietario);
        pr.findById(2);
        //pr.deleteById(1);
        pr.findAll();

        mr.insertarMascota(mascota);
        mr.findById(9);
        //mr.update(mascota, "gato");
        //mr.findById(9);
        //mr.deleteById(2);
        mr.findAll();
    }
}