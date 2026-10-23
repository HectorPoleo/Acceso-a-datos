package org.example.repository;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import org.example.model.Biblioteca;
import org.example.model.Libro;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class GestorBiblioteca {
    private final String ruta = "BibliotecaContenedor.xml";
    private XStream xStream;


    XStream configurarXstream(){
        xStream = new XStream();
        xStream.addPermission(NoTypePermission.NONE);
        xStream.allowTypes(new Class[]{Libro.class, Biblioteca.class});
        xStream.alias("biblioteca", Biblioteca.class);
        xStream.alias("libro", Libro.class);
        xStream.addImplicitCollection(Biblioteca.class, "coleccion");
        return xStream;
    }

    public void guardarBiblioteca(Biblioteca biblioteca){
        xStream = configurarXstream();
        File file = new File(ruta);
        try {
            if(!file.exists() || !file.isFile()){
                file.createNewFile();
            }
            try (FileWriter fw = new FileWriter(ruta)){
                xStream.toXML(biblioteca, fw);
            }

        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    public void cargarBiblioteca(){
        xStream = configurarXstream();
        File file = new File(ruta);
        try {
            if(!file.exists() || !file.isFile()){
                file.createNewFile();
            }
            try (FileReader fr = new FileReader(ruta)){
                xStream.fromXML(fr);
            }
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    public void generarDatosIniciales(){
        Biblioteca bl = new Biblioteca();
        bl.addLibro(new Libro("AAAA2222","Piter y la isla perdida", "Febles", 20.0));
        bl.addLibro(new Libro("AAAA2223","Piter y la isla no perdida", "Febles", 20.0));
        bl.addLibro(new Libro("AAAA2224","Piter y la isla explorada", "Febles", 20.0));
        bl.addLibro(new Libro("AAAA2222","Piter y la isla ya explorada", "Febles", 20.0));
        guardarBiblioteca(bl);
    }


}
