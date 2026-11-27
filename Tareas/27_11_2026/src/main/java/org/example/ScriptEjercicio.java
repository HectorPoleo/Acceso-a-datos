package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

public class ScriptEjercicio {
    private static final String URL = "jdbc:mysql://100.87.254.106:3306/?allowMultiQueries=true&noAccessToProcedureBodies=true";
    private static final String USER = "root";
    private static final String PASSWORD = "1Q2W3E4R";
    private static final String PATHSCRIPT = "init_tienda.sql";

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
            //cn.setCatalog("tienda_callable"); //noAccessToProcedureBodies=true
            ejecutarProceso(cn, 1, 10.0);
            ejecutarFuncion(cn,1);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para ejecutar los scripts del sql
     * @param cn
     * @param pathScript
     */
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

    /**
     * Metodo para ejecutar el proceso de aplicar descuento
     * @param cn
     * @param idProducto
     * @param porcentaje
     */
    public static void ejecutarProceso(Connection cn, int idProducto, double porcentaje){
        try (CallableStatement cs = cn.prepareCall("{call aplicar_descuento(?,?,?)}")){
            cs.setInt(1, idProducto);
            cs.setDouble(2,porcentaje);
            cs.registerOutParameter(3, Types.DOUBLE);

            cs.execute();

            double nuevoPrecio = cs.getDouble(3);

            System.out.printf("Procedimiento: producto %d con %.1f%% de descuento -> nuevo precio: %.2f €%n",idProducto, porcentaje, nuevoPrecio);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para ejecutar el procedimiento de aplicar el iva al precio
     * @param cn
     * @param idProducto
     */
    public static void ejecutarFuncion(Connection cn, int idProducto){
        try (CallableStatement cs = cn.prepareCall("{? = call calcular_precio_iva(?)}")){
            cs.registerOutParameter(1, Types.DOUBLE);
            cs.setInt(2, idProducto);
            cs.execute();

            double precioConIva = cs.getDouble(1);

            System.out.printf("Función: precio final del producto %d con IVA (21%%): %.2f €%n", idProducto, precioConIva);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
