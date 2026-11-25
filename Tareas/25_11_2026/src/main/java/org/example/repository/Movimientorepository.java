package org.example.repository;

import org.example.model.Cuenta;
import org.example.model.Movimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Movimientorepository {


    public static void realizarTransferencia(Connection cn, int idOrigen, int idDestino, double importe, String concepto){
        try (cn){
            CuentaRepository cr = new CuentaRepository();
            cn.setAutoCommit(false);

            Cuenta origen = cr.findById(idOrigen);
            Cuenta destino = cr.findById(idDestino);

            if(origen == null && destino == null){
                return;
            }

            double saldoOrigen = origen.getSaldo();
            double saldoDestino = destino.getSaldo();

            if(saldoOrigen < importe){
                System.out.println("Saldo insuficiente");
                return;
            }

            origen.setSaldo(saldoOrigen - importe);
            cr.update(origen);
            destino.setSaldo(saldoDestino + importe);
            cr.update(destino);

            Movimiento mv = new Movimiento(idOrigen, idDestino, importe, concepto);
            mv.


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
