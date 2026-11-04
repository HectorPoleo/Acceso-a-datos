package org.example.connection;

import org.example.model.Producto;

import java.sql.*;

public class MySQLConnectionManager {
    private static final String URL = "jdbc:mysql://100.87.254.109:3306/prueba";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "1Q2W3E4R";

    public static void main(String[] args) {
        try (Connection cn = DriverManager.getConnection(URL, USUARIO, CONTRASENIA)){
            System.out.println("Conectado a la base de datos ;) "+cn.getMetaData().getDriverName());
            Statement ps = cn.createStatement();
            ps.execute("CREATE TABLE IF NOT EXISTS productos(id INT PRIMARY KEY NOT NULL, nombre VARCHAR(50), precio INT);");
            ps.execute("INSERT INTO productos VALUES (3,'Chocolate', 2);");
            ResultSet resultado = ps.executeQuery("SELECT * from productos;");
            while (resultado.next()){
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                int precio = resultado.getInt("precio");
                System.out.println(new Producto(id,nombre,precio));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
