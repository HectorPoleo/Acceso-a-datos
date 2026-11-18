package org.example.repository;

import org.example.model.Videojuego;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionVideojuego {
    private static final String URL = "jdbc:mysql://100.87.254.183:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "1Q2W3E4R";


    public static void main(String[] args) {
        Videojuego videojuego = new Videojuego("Marvel Spiderman 2", "Action", 60.0);
        try (Connection cn = getConnection()){
            inicializarTabla(cn);
            //Videojuego.insertarDatos(cn, videojuego);
            Videojuego.findById(cn, 2);
            Videojuego.update(cn, videojuego);
            Videojuego.findById(cn, 2);
            //Videojuego.findAll(cn);
            //Videojuego.deleteId(cn,1);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public static void inicializarTabla(Connection cn){
        try (Statement st = cn.createStatement()){
            st.execute("CREATE DATABASE IF NOT EXISTS videojuegos_db;");
            st.execute("USE videojuegos_db;");
            st.execute("CREATE TABLE IF NOT EXISTS videojuegos(id INT AUTO_INCREMENT PRIMARY KEY, titulo VARCHAR(80) NOT NULL, genero VARCHAR(40) NOT NULL, precio DOUBLE);");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }





}
