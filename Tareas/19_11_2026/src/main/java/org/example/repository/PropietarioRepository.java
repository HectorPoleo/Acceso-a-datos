package org.example.repository;

import org.example.connection.DataBaseConnection;
import org.example.model.Propietario;

import java.sql.*;

public class PropietarioRepository {
    private final Connection cn;

    public PropietarioRepository() throws SQLException {
        this.cn = DataBaseConnection.getConnection();
       DataBaseConnection.inicializarTabla(cn);
    }

    public boolean insertarPropietario(Propietario propietario){
        try (PreparedStatement pt = cn.prepareStatement("INSERT INTO propietarios(dni, nombre, telefono) VALUES (?,?,?);", Statement.RETURN_GENERATED_KEYS)){
            pt.setString(1,propietario.getDni());
            pt.setString(2, propietario.getNombre());
            pt.setString(3, propietario.getTelefono());
            return pt.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Propietario findById (Integer id){
        if(id == null){
            System.out.println("El propietario: "+new Propietario(id)+ " no existe");
            return null;
        }
        try (PreparedStatement pt = cn.prepareStatement("SELECT * FROM propietarios WHERE id = ?;")){
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                System.out.println(new Propietario(id, dni, nombre, telefono));
                return new Propietario(id, dni, nombre, telefono);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean deleteById(Integer id){
        try (PreparedStatement pt = cn.prepareStatement("DELETE FROM propietarios WHERE id = ?;")){
            pt.setInt(1,id);
            return pt.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
