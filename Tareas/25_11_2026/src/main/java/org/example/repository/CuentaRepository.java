package org.example.repository;

import org.example.connection.ConexionBBDD;
import org.example.model.Cuenta;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaRepository {
    private final Connection cn;

    public CuentaRepository() throws SQLException{
            cn = ConexionBBDD.getConnection();
            ConexionBBDD.inicializarTablas(cn);

    }


    public boolean insertarCuenta(Cuenta cuenta){
        try (PreparedStatement pt = cn.prepareStatement("INSERT INTO cuentas(iban, titular, saldo) VALUES (?,?,?);", Statement.RETURN_GENERATED_KEYS)){
            pt.setString(1, cuenta.getIban());
            pt.setString(2, cuenta.getTitular());
            pt.setDouble(3, cuenta.getSaldo());
            return pt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Cuenta findById(Integer id){
        try (PreparedStatement pt = cn.prepareStatement("SELECT * FROM cuentas WHERE id = ?;")){
            pt.setInt(1, id);;
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                String iban = rs.getString("iban");
                String titular = rs.getString("titular");
                double saldo = rs.getDouble("saldo");
                System.out.println(new Cuenta(iban, titular, saldo));
                return new Cuenta(iban, titular, saldo);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Cuenta findByIban(String iban){
        try (PreparedStatement pt = cn.prepareStatement("SELECT * FROM cuentas WHERE iban = ?;")){
            pt.setString(1, iban);;
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                String titular = rs.getString("titular");
                double saldo = rs.getDouble("saldo");
                System.out.println(new Cuenta(iban, titular, saldo));
                return new Cuenta(iban, titular, saldo);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean deleteById(Integer id){
        try (PreparedStatement pt = cn.prepareStatement("DELETE FROM cuentas WHERE id = ?;")){
            pt.setInt(1, id);
            return pt.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteById(String iban){
        try (PreparedStatement pt = cn.prepareStatement("DELETE FROM cuentas WHERE iban = ?;")){
            pt.setString(1, iban);
            return pt.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean update(Cuenta cuenta){
        try (PreparedStatement pt = cn.prepareStatement("UPDATE cuentas set saldo = ? WHERE id = ?;")){
            pt.setInt(1, cuenta.getId());
            return pt.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    public void findAll(){
        List<Cuenta> cuentas = new ArrayList<>();
        try (PreparedStatement pt = cn.prepareStatement("SELECT * FROM cuentas;")){
            ResultSet rs = pt.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("id");
                String iban = rs.getString("iban");
                String titular = rs.getString("titular");
                double saldo = rs.getDouble("saldo");
                cuentas.add(new Cuenta(id, iban, titular, saldo));
            }
            rs.close();
            System.out.println(cuentas);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
