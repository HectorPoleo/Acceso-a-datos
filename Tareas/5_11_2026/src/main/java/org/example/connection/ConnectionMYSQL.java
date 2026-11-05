package org.example.connection;

import java.sql.*;

public class ConnectionMYSQL {
    private static final String URL = "jdbc:mysql://100.87.254.109:3306";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "1Q2W3E4R";

    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(URL,USUARIO,CONTRASENIA);
    }
    public static void main(String[] args) {
        try (Connection cn = getConnection()){
            inicializarTabla(cn);
            insertaDatos(cn);
            leerDatos(cn);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    private static void leerDatos(Connection cn) {
        try (Statement st = cn.createStatement()){
            ResultSet rs = st.executeQuery("SELECT * FROM empleados;");
            while (rs.next()){
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String id_departamento = rs.getString("id_departamento");
                System.out.println(id+" "+nombre+" "+id_departamento);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void insertaDatos(Connection cn) {
        try (Statement st = cn.createStatement()){
            //st.executeUpdate("INSERT INTO departamentos(id, nombre) VALUES (1, 'finanzas');");
            //st.executeUpdate("INSERT INTO departamentos(id, nombre) VALUES (2, 'RR.HH.');");
            st.executeUpdate("INSERT INTO empleados(id,nombre,id_departamento) VALUES (1, 'Manuel', 1);");
            st.executeUpdate("INSERT INTO empleados(id,nombre,id_departamento) VALUES (2,'Alvaro',2);");
            st.executeUpdate("INSERT INTO empleados(id,nombre,id_departamento) VALUES (3,'Hector', 2);");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void inicializarTabla(Connection cn) {
        try (Statement st = cn.createStatement()){
            st.execute("CREATE DATABASE IF NOT EXISTS empresa_db;");
            st.execute("USE empresa_db;");
            st.execute("CREATE TABLE IF NOT EXISTS departamentos(id INT PRIMARY KEY, nombre VARCHAR(50));");
            st.execute("CREATE TABLE IF NOT EXISTS empleados(id INT PRIMARY KEY, nombre VARCHAR(50), id_departamento INT, FOREIGN KEY (id_departamento) REFERENCES departamentos(id));");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
