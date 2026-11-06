package org.example.repository;

import org.example.connection.ConnectionMYSQL;
import org.example.model.GestionTiendaMusica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionTiendaMusicaRepository extends GestionTiendaMusica{
    private static final String URL = "jdbc:mysql://100.87.254.109:3306";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "1Q2W3E4R";
    static Connection cn;


    public GestionTiendaMusicaRepository() throws SQLException {
        cn = ConnectionMYSQL.getConnection(URL,USUARIO,CONTRASENIA);
    }

    public static void crearTablas(){
        try (Statement st = cn.createStatement()){
            st.execute("CREATE DATABASE IF NOT EXISTS tienda_musica;");
            st.execute("USE tienda_musica");
            st.execute("CREATE TABLE IF NOT EXISTS artistas(id INT PRIMARY KEY, nombre VARCHAR(50));");
            st.execute("CREATE TABLE IF NOT EXISTS albumes(id INT PRIMARY KEY, nombre VARCHAR(50),precio DOUBLE, id_artista INT, FOREIGN KEY (id_artista) REFERENCES artistas(id));");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void insertarDatos(){
        int contador = 0;
        try (Statement st = cn.createStatement()){

           /*contador += st.executeUpdate("INSERT INTO artistas(id, nombre) VALUES (1, 'Mägo de oz');");
            contador += st.executeUpdate("INSERT INTO artistas(id, nombre) VALUES (2, 'Final Fantasy XIV');");
            contador += st.executeUpdate("INSERT INTO artistas(id, nombre) VALUES (3, 'ADO');");*/
            contador += st.executeUpdate("INSERT INTO albumes(id, nombre, precio,id_artista) VALUES (1, 'Hechizos, pócimas y brujería', 40.0, 1);");
            contador += st.executeUpdate("INSERT INTO albumes(id, nombre, precio,id_artista) VALUES (2, 'Mägo de Oz',100.0, 1);");
            contador +=st.executeUpdate("INSERT INTO albumes(id, nombre, precio,id_artista) VALUES (3, 'Endwalker(2022)', 150.0, 2);");
            contador += st.executeUpdate("INSERT INTO albumes(id, nombre, precio,id_artista) VALUES (4, 'Zanmu', 2.0,3);");
            System.out.println("Numero de inserciones: "+contador);
        }catch (SQLException e){
            System.out.println(e.getMessage() + e.getSQLState() + e.getErrorCode());
        }
    }

    public static void modificarDatos(){
        try (Statement st = cn.createStatement()){
            st.executeUpdate("UPDATE albumes SET precio = 1.50 WHERE id = 4;");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteData(){
        try (Statement st = cn.createStatement()){
            st.executeUpdate("DELETE FROM albumes WHERE id = 4;");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void consultarDatos(){
        try (Statement st = cn.createStatement()){
            ResultSet rs = st.executeQuery("SELECT * FROM albumes JOIN artistas ON artistas.id = albumes.id_artista;");
            while (rs.next()){
                String id =rs.getString("albumes.id");
                String nombre=rs.getString("albumes.nombre");
                String precio=rs.getString("albumes.precio");
                String artista=rs.getString("artistas.nombre");
                System.out.println(id+" "+nombre+" "+precio+" "+artista);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
