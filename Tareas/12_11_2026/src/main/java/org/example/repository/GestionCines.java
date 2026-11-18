package org.example.repository;
import java.sql.*;

public class GestionCines {
    private static final String URL = "jdbc:mysql://100.87.254.183:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "1Q2W3E4R";
    private static ResultSet rs = null;

    public static void main(String[] args) {
        try(Connection cn = getConnection()){
            inicializarTabla(cn);
            insertarDatos(cn);
            actualiarDatos(cn);
            borrarPelicula(cn);
            consultarInversoYConteo(cn, rs);
            consultarFilaAbsoluta(cn, 2);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void inicializarTabla(Connection cn){
        try(Statement st = cn.createStatement()){
            st.execute("CREATE DATABASE IF NOT EXISTS cines_db;");
            st.execute("USE cines_db;");
            st.execute("CREATE TABLE IF NOT EXISTS cines(id INT PRIMARY KEY, nombre VARCHAR(60) NOT NULL,"+
                    " ciudad VARCHAR(40) NOT NULL);");
            st.execute("CREATE TABLE IF NOT EXISTS peliculas(id INT PRIMARY KEY, titulo VARCHAR(80) NOT NULL, duracion_min INT NOT NULL,"+
                    " precio_entrada DOUBLE NOT NULL, id_cine INT, FOREIGN KEY (id_cine) REFERENCES cines(id));");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void insertarDatos(Connection cn){
        try(Statement st = cn.createStatement()){
            st.executeUpdate("INSERT IGNORE INTO cines(id, nombre, ciudad) VALUES (1, 'Cine Yelmo', 'Madrid');");
            st.executeUpdate("INSERT IGNORE INTO cines(id, nombre, ciudad) VALUES (2, 'Cinesa', 'Barcelona');");
            st.executeUpdate("INSERT IGNORE INTO cines(id, nombre, ciudad) VALUES (3,'Kinépolis', 'Valencia');");

            st.executeUpdate("INSERT IGNORE INTO peliculas(id, titulo, duracion_min, precio_entrada, id_cine) VALUES " +
                    "(1, 'Como entrenar a tu dragón', 98, 12, 1);");
            st.executeUpdate("INSERT IGNORE INTO peliculas(id, titulo, duracion_min, precio_entrada, id_cine) VALUES " +
                    "(2, 'Como entrenar a tu dragón 2', 102, 12, 1);");
            st.executeUpdate("INSERT IGNORE INTO peliculas(id, titulo, duracion_min, precio_entrada, id_cine) VALUES " +
                    "(3, 'Como entrenar a tu dragón 3', 104, 12, 1);");
            st.executeUpdate("INSERT IGNORE INTO peliculas(id, titulo, duracion_min, precio_entrada, id_cine) VALUES " +
                    "(4, 'Mortadelo y Filemon contra Jimmy el cachondo', 88, 12, 2);");
            st.executeUpdate("INSERT IGNORE INTO peliculas(id, titulo, duracion_min, precio_entrada, id_cine) VALUES " +
                    "(5, 'El corral, una fiesta muy bestia', 90, 12, 3);");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void actualiarDatos(Connection cn){
        try (Statement st = cn.createStatement()){
            st.executeUpdate("Update peliculas set precio_entrada = 7 WHERE id = 5;");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void borrarPelicula(Connection cn){
        try(Statement st = cn.createStatement()){
            st.executeUpdate("DELETE FROM peliculas WHERE id = 3;");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void consultarInversoYConteo(Connection cn, ResultSet rs){
        try(Statement st = cn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,
                rs.CONCUR_READ_ONLY)){
            rs = st.executeQuery("SELECT cines.nombre, peliculas.id, peliculas.titulo, " +
                    "peliculas.duracion_min,peliculas.precio_entrada FROM peliculas JOIN cines ON cines.id = peliculas.id_cine;");
            if(rs.last()){
                int i = rs.getRow();
                System.out.println("Total de peliculas: " + i);
                do {
                    System.out.println(rs.getInt("peliculas.id") + " | "
                            + rs.getString("peliculas.titulo") + " | "
                            + rs.getString("cines.nombre"));
                } while (rs.previous());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public static void consultarFilaAbsoluta(Connection cn, int posicion){
        try (Statement st = cn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = st.executeQuery("SELECT cines.nombre, peliculas.id, peliculas.titulo, " +
                     "peliculas.duracion_min,peliculas.precio_entrada FROM peliculas JOIN cines ON cines.id = peliculas.id_cine;")) {

            if (rs.absolute(posicion)) {
                System.out.println("Pelicula en la posicion " + posicion + ":");
                System.out.println("ID: " + rs.getInt("peliculas.id"));
                System.out.println("Titulo: " + rs.getString("peliculas.titulo"));
                System.out.println("Cine: " + rs.getString("cines.nombre"));

                if (rs.isFirst()) {
                    System.out.println("Es la primera fila del conjunto de resultados.");
                }
                if (rs.isLast()) {
                    System.out.println("Es la ultima fila del conjunto de resultados.");
                }
                if (!rs.isFirst() && !rs.isLast()) {
                    System.out.println("Es una fila intermedia.");
                }
            } else {
                System.out.println("La posicion " + posicion + " no existe en los resultados.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
