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

/**
 * Clase para gestionar una biblioteca
 * @author hectorpoleo
 * @version 1.0.0
 */
public class GestorBiblioteca {
    private final String ruta = "BibliotecaContenedor.xml";
    private XStream xStream;


    /**
     * Metodo para configurar el xml
     * @return xStream
     */
    XStream configurarXstream(){
        xStream = new XStream();
        xStream.addPermission(NoTypePermission.NONE);
        xStream.allowTypes(new Class[]{Libro.class, Biblioteca.class});
        xStream.alias("biblioteca", Biblioteca.class);
        xStream.alias("libro", Libro.class);
        xStream.addImplicitCollection(Biblioteca.class, "libros", Libro.class);
        return xStream;
    }

    /**
     * Metodo para escribir en el xml
     * @param biblioteca biblioteca a añadir en el xml
     */
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

    /**
     * Metodo para cargar la biblioteca
     * @return Biblioteca ya existente
     */
    public Biblioteca cargarBiblioteca(){
        xStream = configurarXstream();
        File file = new File(ruta);
        try {
            if(!file.exists() || !file.isFile()){
                file.createNewFile();
            }
            try (FileReader fr = new FileReader(ruta)){
                return (Biblioteca) xStream.fromXML(fr);
            }
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
            return new Biblioteca();
        }
    }

    /**
     * Metodo para generar datos iniciales de la biblioteca
     */
    public void generarDatosIniciales(){
        Biblioteca bl = new Biblioteca();
        bl.addLibro(new Libro("AAAA2222","Piter y la isla perdida", "Febles", 20.0));
        bl.addLibro(new Libro("AAAA2223","Piter y la isla no perdida", "Febles", 20.0));
        bl.addLibro(new Libro("AAAA2224","Piter y la isla explorada", "Febles", 20.0));
        bl.addLibro(new Libro("AAAA2225","Piter y la isla ya explorada", "Febles", 20.0));
        guardarBiblioteca(bl);
    }


}
