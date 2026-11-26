package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBBDD {
    private static final String URL = "jdbc:mysql://100.87.254.106:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "1Q2W3E4R";

    /**
     * Metodo para conectarse a la base de datos
     * @return devuelve la conexion a la base de datos
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Metodo para inicializar la base de datos y sus tablas
     * @param cn
     */
    public static void inicializarTablas(Connection cn){
        try (Statement st = cn.createStatement()){
            st.execute("CREATE DATABASE IF NOT EXISTS gestion_banco_db;");
            st.execute("USE gestion_banco_db;");
            st.execute("CREATE TABLE IF NOT EXISTS cuentas(id INT AUTO_INCREMENT PRIMARY KEY" +
                    ", iban VARCHAR(24) NOT NULL UNIQUE, titular VARCHAR(60) NOT NULL, saldo DOUBLE NOT NULL);");
            st.execute("CREATE TABLE IF NOT EXISTS movimientos(id INT AUTO_INCREMENT PRIMARY KEY" +
                    ", id_cuenta_origen INT NOT NULL, FOREIGN KEY(id_cuenta_origen) REFERENCES cuentas(id), id_cuenta_destino INT NOT NULL, FOREIGN KEY(id_cuenta_destino) REFERENCES cuentas(id), importe DOUBLE NOT NULL,  concepto VARCHAR(100));");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
