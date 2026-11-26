package org.example;

import org.example.model.Cuenta;
import org.example.repository.CuentaRepository;
import org.example.repository.Movimientorepository;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        try {
            CuentaRepository cr = new CuentaRepository();
            Movimientorepository mr = new Movimientorepository();
            Cuenta c1 = new Cuenta("E00000000000A1", "Ana Ruiz", 20000);
            Cuenta c2 = new Cuenta("E00000000000A2", "Marcos Pegaso", 1000);
            cr.insertarCuenta(c1);
            cr.insertarCuenta(c2);
            mr.realizarTransferencia(c1.getId(),c2.getId(), 10000, null);
            mr.mostrarSaldo(c1.getId(), c2.getId());
            mr.realizarTransferencia(c1.getId(), c2.getId(), 100000, null);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}