package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306";
    private static final String USER = "raiz";
    private static final String PASSWORD = "1q2w3e4r";

    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void inicializarTabla(Connection cn){
        try (Statement st = cn.createStatement()){
            st.execute("CREATE DATABASE IF NOT EXISTS clinicaVet_db;");
            st.execute("USE clinicaVet_db;");
            st.execute("CREATE TABLE IF NOT EXISTS propietarios(id INT AUTO_INCREMENT PRIMARY KEY, dni CHAR(9) UNIQUE NOT NULL, nombre VARCHAR(60) NOT NULL, telefono VARCHAR(15));");
            st.execute("CREATE TABLE IF NOT EXISTS mascotas(id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(50) NOT NULL" +
                    ", especie VARCHAR(30) NOT NULL, peso DOUBLE, id_propietario INT, FOREIGN KEY (id_propietario) REFERENCES propietarios(id));");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
