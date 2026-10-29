package org.example;

import org.example.repository.GestorAlmacenMultiformato;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GestorAlmacenMultiformato.preparaEntorno();
        GestorAlmacenMultiformato.escribirRandomAccess("./datos.dat", GestorAlmacenMultiformato.leerCSV("./datos_almacen/importacion_producto.csv"));
        GestorAlmacenMultiformato.actualizarStockRandomAccess("./datos.dat", 0, 23);
        GestorAlmacenMultiformato.exportarJSON("./datos.json", GestorAlmacenMultiformato.leerRandomAccess("./datos.dat"));

    }
}