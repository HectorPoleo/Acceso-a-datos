package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoScriptCallable {
    private static final String URL = "jdbc:mysql://100.87.254.106:3306/?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "1Q2W3E4R";
    private static final String PATHSCRIPT = "basedatosbanco.sql";

    /**
     * Metodo para conectarse a la base de datos
     * @return devuelve la conexion a la base de datos
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection cn = getConnection()){
            ejecutarScripts(cn, PATHSCRIPT);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void ejecutarScripts(Connection cn, String pathScript){
        try (Statement st = cn.createStatement()){
            String sqlDML= Files.readString(Path.of(pathScript));
            st.execute(sqlDML);
        }catch (IOException e){
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
