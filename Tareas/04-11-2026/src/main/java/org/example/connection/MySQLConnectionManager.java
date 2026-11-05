package org.example.connection;

import org.example.model.Faccion;
import org.example.model.Operador;
import org.example.model.Producto;

import java.sql.*;

public class MySQLConnectionManager {
    private static final String URL = "jdbc:mysql://100.87.254.109:3306";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "1Q2W3E4R";

    public static void main(String[] args) {
        try (Connection cn = getConnection()){
            System.out.println("Coneccion Iniciada "+ cn.getMetaData().getUserName());
            inicializacionTablas(cn);
            consultarDatos(cn);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void inicializacionTablas(Connection cn) {
        try (Statement st = cn.createStatement()){
            st.execute("CREATE DATABASE IF NOT EXISTS Arknights;");
            st.execute("USE Arknights;");
            st.execute("CREATE TABLE IF NOT EXISTS facciones(faccion VARCHAR(50) PRIMARY KEY, ubicacion VARCHAR(50));");
            st.execute("CREATE TABLE IF NOT EXISTS operadores(id INT PRIMARY KEY, codeName VARCHAR(50), clase VARCHAR(50),fechaLanzamiento INT, " +
                    "nombreFaccion VARCHAR(50), FOREIGN KEY (nombreFaccion) REFERENCES facciones(faccion));");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void insertarDatos(Connection cn){
        try (Statement st = cn.createStatement()){
            st.executeUpdate("INSERT INTO facciones(faccion, ubicacion) VALUES ('Ursus', 'Rusia');");
            st.executeUpdate("INSERT INTO facciones(faccion, ubicacion) VALUES('Iberia', 'España');");
            st.executeUpdate("INSERT INTO facciones(faccion, ubicacion) VALUES ('Siracussa', 'Italia');");
            st.executeUpdate("INSERT INTO operadores(id, codeName,clase,fechaLanzamiento,nombreFaccion) VALUES (1,'Lappland', 'Guard', 2020, 'Siracussa');");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void consultarDatos(Connection cn){
        try (Statement st = cn.createStatement()){
            ResultSet rs = st.executeQuery("SELECT * FROM operadores");
            while (rs.next()){
                int id = rs.getInt("id");
                String codeName = rs.getString("codeName");
                String clase = rs.getString("clase");
                int fechaLanzamiento = rs.getInt("fechaLanzamiento");
                String nombreFaccion = rs.getString("nombreFaccion");
                Faccion f = new Faccion(nombreFaccion);
                System.out.println(new Operador(id, codeName, clase, fechaLanzamiento, f));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USUARIO,CONTRASENIA);
    }

    

}
