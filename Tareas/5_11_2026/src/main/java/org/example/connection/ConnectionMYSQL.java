package org.example.connection;

import java.sql.*;

/**
 * Clase que maneja la coneccion a la base de datos y sus metodos
 */
public class ConnectionMYSQL {
    private static final String URL = "jdbc:mysql://100.87.254.109:3306";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "1Q2W3E4R";

    /**
     * Metodo para conectarse a la base datos
     * @return devuelve la conexion
     * @throws SQLException
     */
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

    /**
     * Metodo para leer los datos de la base de datos
     * @param cn conexion con la base de datos
     */
    private static void leerDatos(Connection cn) {
        try (Statement st = cn.createStatement()){
            ResultSet rs = st.executeQuery("SELECT em.id as id_empleado, em.nombre as nombre_emplado, dep.nombre as nombre_departamento  FROM empleados as em INNER JOIN departamentos as dep ON em.id_departamento = dep.id;");
            while (rs.next()){
                String id = rs.getString("id_empleado");
                String nombre = rs.getString("nombre_emplado");
                String id_departamento = rs.getString("nombre_departamento");
                System.out.println(id+" "+nombre+" "+id_departamento);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para insertar datos a las base de datos
     * Estan comentados dado que ya existen en la base de datos
     * @param cn conexion con la base de datos
     */
    private static void insertaDatos(Connection cn) {
        try (Statement st = cn.createStatement()){
            //st.executeUpdate("INSERT INTO departamentos(id, nombre) VALUES (1, 'finanzas');");
            //st.executeUpdate("INSERT INTO departamentos(id, nombre) VALUES (2, 'RR.HH.');");
            //st.executeUpdate("INSERT INTO empleados(id,nombre,id_departamento) VALUES (1, 'Manuel', 1);");
            //st.executeUpdate("INSERT INTO empleados(id,nombre,id_departamento) VALUES (2,'Alvaro',2);");
            //st.executeUpdate("INSERT INTO empleados(id,nombre,id_departamento) VALUES (3,'Hector', 2);");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para crear la base de datos e inicializar sus tablas
     * @param cn conexion con la base de datos
     */
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