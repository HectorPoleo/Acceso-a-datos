package org.example.repository;

import org.example.connection.DataBaseConnection;
import org.example.model.Mascota;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class    MascotaRepository {
    private final Connection cn;

    public MascotaRepository() throws SQLException {
        this.cn = DataBaseConnection.getConnection();
        DataBaseConnection.inicializarTabla(cn);
    }

    public boolean insertarMascota (Mascota mascota){
        try (PreparedStatement pt = cn.prepareStatement("INSERT INTO mascotas(nombre, especie, peso, id_propietario) VALUES (?,?,?,?);",Statement.RETURN_GENERATED_KEYS)){
            pt.setString(1, mascota.getNombre());
            pt.setString(2, mascota.getEspecie());
            pt.setObject(3, mascota.getPeso());
            pt.setInt(4, mascota.getIdPropietario());
            return pt.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Mascota findById(Integer id){
        try (PreparedStatement pt = cn.prepareStatement("SELECT * FROM mascotas WHERE id = ?")){
            pt.setInt(1,id);
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                String nombre = rs.getString("nombre");
                String especie = rs.getString("especie");
                Double peso = rs.getDouble("peso");
                Integer idPropietario = rs.getInt("id_propietario");
                System.out.println(new Mascota(id, nombre, especie, peso, idPropietario));
                return new Mascota(id, nombre, especie, peso, idPropietario);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean deleteById(Integer id){
        try (PreparedStatement pt = cn.prepareStatement("DELETE FROM mascotas WHERE id = ?;")){
            pt.setInt(1, id);
            return pt.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean update(Mascota mascota, String especieNueva){
        try(PreparedStatement pt = cn.prepareStatement("UPDATE mascotas SET especie = ? WHERE id = ?;")){
            pt.setString(1, especieNueva);
            pt.setInt(2,mascota.getId());
            return pt.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean findAll(){
        List<Mascota> mascotas = new ArrayList<>();
        try (PreparedStatement pt = cn.prepareStatement("SELECT * FROM mascotas")){
            ResultSet rs = pt.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String especie = rs.getString("especie");
                Double peso = rs.getDouble("peso");
                Integer idPropietario = rs.getInt("id_propietario");
                mascotas.add(new Mascota(id, nombre, especie, peso, idPropietario));
            }
            rs.close();
            System.out.println(mascotas);
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
