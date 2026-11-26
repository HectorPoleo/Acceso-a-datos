package org.example.repository;

import org.example.connection.ConexionBBDD;
import org.example.model.Cuenta;
import org.example.model.Movimiento;

import java.sql.*;

/**
 * Clase de los metodos de movimiento
 */
public class Movimientorepository {
    private final Connection cn;
    CuentaRepository cr;

    /**
     * Constructor para conectar con la base de datos
     * @throws SQLException
     */
    public Movimientorepository()throws SQLException{
        cn = ConexionBBDD.getConnection();
        ConexionBBDD.inicializarTablas(cn);
        cr = new CuentaRepository(cn);
    }

    /**
     * Metodo para insertar un movimiento en la base de datos
     * @param movimiento movimiento a insertar
     * @return true si se inserta el movimiento
     */
    public boolean insertarMovimiento(Movimiento movimiento){
        try (PreparedStatement pt = cn.prepareStatement("INSERT INTO movimientos(id_cuenta_origen, id_cuenta_destino, importe, concepto) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)){
            pt.setInt(1, movimiento.getId_cuenta_origen());
            pt.setInt(2, movimiento.getId_cuenta_destino());
            pt.setDouble(3, movimiento.getImporte());
            pt.setString(4, movimiento.getConcepto());
            pt.executeUpdate();
            try(ResultSet rs = pt.getGeneratedKeys()){
                if(rs.next()){
                    movimiento.setId(rs.getInt(1));
                }
            }
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Metodo para  realizar una transferencia entre cuentas
     * @param idOrigen id de la cuenta de origen
     * @param idDestino id de la cuenta de destino
     * @param importe importe a transferir
     * @param concepto concepto de la transferencia
     */
    public void realizarTransferencia( int idOrigen, int idDestino, double importe, String concepto){
        try{
            cn.setAutoCommit(false);

            Cuenta origen = cr.findById(idOrigen);
            Cuenta destino = cr.findById(idDestino);

            if(origen == null || destino == null){
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
            insertarMovimiento(mv);

            cn.commit();
            System.out.println("Transferencia realizada: "+ mv);
        }catch (SQLException e){
            try {
                cn.rollback();
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }finally {
            try {
                cn.setAutoCommit(true);
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Metodo para mostrar el saldo de las cuentas
     * @param id1 id de la cuenta 1
     * @param id2 id de la cuenta 2
     */
    public void mostrarSaldo(Integer id1, Integer id2){
        System.out.println("Saldo en BD: "+ cr.findById(id1)+",\n "+cr.findById(id2));
    }
}
