package org.example;

import org.example.connection.DataBaseConnection;
import org.example.model.Mascota;
import org.example.model.Propietario;
import org.example.repository.MascotaRepository;
import org.example.repository.PropietarioRepository;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        Propietario propietario = new Propietario("44005400c","Enrique","900 000 000");
        Mascota mascota = new Mascota("Asteroid Destroyer 2", "perro", 20.0, 1);
        PropietarioRepository pr = new PropietarioRepository();
        MascotaRepository mr = new MascotaRepository();
        pr.insertarPropietario(propietario);
        pr.findById(2);
        pr.deleteById(1);

        mr.insertarMascota(mascota);
        mr.findById(1);
        //mr.update(mascota, "gato");
        mr.findById(2);
        mr.deleteById(2);
    }
}