package org.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Videojuego {

    Integer id;
    String titulo;
    String genero;
    Double precio;

    public Videojuego() {
    }

    public Videojuego(Integer id) {
        this.id = id;
    }

    public Videojuego(String titulo, String genero, Double precio) {
        this.id = null;
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
    }
    public Videojuego(Integer id, String titulo, String genero, Double precio) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public static boolean insertarDatos(Connection cn, Videojuego videojuego){
        try (PreparedStatement pt = cn.prepareStatement("INSERT INTO videojuegos (titulo, genero, precio) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)){
            pt.setString(1, videojuego.getTitulo());
            pt.setString(2,videojuego.getGenero());
            pt.setObject(3, videojuego.getPrecio());
            return pt.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean deleteId(Connection cn, Integer id){
        try (PreparedStatement pt = cn.prepareStatement(" DELETE FROM videojuegos WHERE id = ?;")){
            pt.setInt(1, id);
            return pt.executeUpdate() >= 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void findAll(Connection cn){
        List<Videojuego> videojuegos = new ArrayList<>();
        try (PreparedStatement pt = cn.prepareStatement("SELECT * FROM videojuegos;"); ResultSet rs = pt.executeQuery()){
            while (rs.next()){
                Integer id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String genero = rs.getString("genero");
                Double precio = rs.getDouble("precio");
                videojuegos.add(new Videojuego(id, titulo, genero, precio));
            }
            System.out.println(videojuegos);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static Videojuego findById(Connection cn, Integer id){
        if(id == null){
            System.out.println("El videojuego: "+ new Videojuego(id)+ "no existe");
            return null;
        }
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM videojuegos WHERE id = ?;")){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String titulo = rs.getString("titulo");
                String genero = rs.getString("genero");
                Double precio = rs.getDouble("precio");
                System.out.println(new Videojuego(id, titulo, genero, precio));
                return new Videojuego(id, titulo, genero, precio);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());

        }
        return null;
    }

    public static boolean update (Connection cn, Videojuego videojuego){
        try (PreparedStatement ps = cn.prepareStatement("UPDATE videojuegos SET precio = 90 WHERE id = ?")){
            ps.setInt(1, videojuego.getId());

            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Videojuego that = (Videojuego) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                '}';
    }
}
