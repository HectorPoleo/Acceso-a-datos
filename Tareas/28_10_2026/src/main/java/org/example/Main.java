package org.example;

import org.example.repository.GestorAlmacenMultiformato;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GestorAlmacenMultiformato.preparaEntorno();
        GestorAlmacenMultiformato.leerCSV("./datos_almacen/importacion_producto.csv");
        GestorAlmacenMultiformato.escribirRandomAccess("./datos.dat", GestorAlmacenMultiformato.getProductos());
        GestorAlmacenMultiformato.actualizarStockRandomAccess("./datos.dat", 3, 23);
        GestorAlmacenMultiformato.exportarJSON("./datos.json", GestorAlmacenMultiformato.getProductos());

    }
}