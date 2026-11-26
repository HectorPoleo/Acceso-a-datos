package org.example.repository;

import org.example.connection.ConexionBBDD;
import org.example.model.Cuenta;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de los metodos dedicados a el objeto cuenta
 */
public class CuentaRepository {
    private final Connection cn;

    /**
     * Constructor que conecta con la base de datos
     * @throws SQLException
     */
    public CuentaRepository() throws SQLException{
            cn = ConexionBBDD.getConnection();
            ConexionBBDD.inicializarTablas(cn);
    }

    /**
     * Constructor del connection
     * @param cn conexion
     */
    public CuentaRepository(Connection cn) {
        this.cn = cn;
    }

    /**
     * Metodo para insertar cuentas en la base de datos
     * @param cuenta cuenta a insertar
     * @return true si se inserta
     */
    public boolean insertarCuenta(Cuenta cuenta){
        try (PreparedStatement pt = cn.prepareStatement("INSERT INTO cuentas(iban, titular, saldo) VALUES (?,?,?);", Statement.RETURN_GENERATED_KEYS)){
            pt.setString(1, cuenta.getIban());
            pt.setString(2, cuenta.getTitular());
            pt.setDouble(3, cuenta.getSaldo());
            pt.executeUpdate();
            try(ResultSet rs = pt.getGeneratedKeys()){
                if(rs.next()){
                    cuenta.setId(rs.getInt(1));
                }
            }
            System.out.println("Se inserta con exito: " +cuenta+" "+cuenta.getId());
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Metodo para buscar dentro de la base de datos una cuenta en funcion de su id
     * @param id id de la cuenta a buscar
     * @return cuenta buscada
     */
    public Cuenta findById(Integer id){
        try (PreparedStatement pt = cn.prepareStatement("SELECT * FROM cuentas WHERE id = ?;")){
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                Integer idActual = rs.getInt("id");
                String iban = rs.getString("iban");
                String titular = rs.getString("titular");
                double saldo = rs.getDouble("saldo");
                System.out.println(new Cuenta(idActual,iban, titular, saldo));
                return new Cuenta(idActual, iban, titular, saldo);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Metodo para buscar una cuenta por su iban
     * @param iban iban de la cuenta a buscar
     * @return cuenta encontrada
     */
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

    /**
     * Metodo para borrar una cuenta por su id
     * @param id id de la cuenta a borrar
     * @return true si la cuenta se borra
     */
    public boolean deleteById(Integer id){
        try (PreparedStatement pt = cn.prepareStatement("DELETE FROM cuentas WHERE id = ?;")){
            pt.setInt(1, id);
            return pt.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Metodo para borrar una cuenta por su id
     * @param iban iban de la cuenta a borrar
     * @return true si la cuenta se borra
     */
    public boolean deleteById(String iban){
        try (PreparedStatement pt = cn.prepareStatement("DELETE FROM cuentas WHERE iban = ?;")){
            pt.setString(1, iban);
            return pt.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Metodo para actualizar el saldo de una cuenta
     * @param cuenta cuenta a actualizar
     * @return true si se actualiza
     */
    public boolean update(Cuenta cuenta){
        try (PreparedStatement pt = cn.prepareStatement("UPDATE cuentas set saldo = ? WHERE id = ?;")){
            pt.setDouble(1, cuenta.getSaldo());
            pt.setInt(2, cuenta.getId());
            return pt.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Metodo para leer todas las cuentas
     */
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
