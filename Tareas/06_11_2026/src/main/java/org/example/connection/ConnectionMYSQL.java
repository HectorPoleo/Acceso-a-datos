package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 public abstract class ConnectionMYSQL {

    public static void main(String[] args) {

    }

    /**
     * Metodo para conectarme a la base de datos
     * @return conexion a la base de datos
     * @throws SQLException
     */
    public static Connection getConnection(String URL, String USUARIO, String CONTRASENIA)throws SQLException{
        return DriverManager.getConnection(URL,USUARIO,CONTRASENIA);
    }

}
