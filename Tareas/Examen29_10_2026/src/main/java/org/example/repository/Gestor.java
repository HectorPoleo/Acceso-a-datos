package org.example.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.Vehiculo;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Clase gestora de los vehiculos
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Gestor {
    private static final String rutaJson = "Vehiculos.json";
    private static final String rutaCSV = "Vehiculos.csv";
    private static final String rutaDAT = "Vehiculos.dat";

    static int idBytes = 4;
    static int largoMarca = 20;
    static int marcaBytes = largoMarca * 2;
    static int precioBytes = 8;
    static int stockBytes = 4;
    static int TAMANO_TOTAL = idBytes+marcaBytes+precioBytes+stockBytes;
    static Gson gson = new Gson();

    /**
     * Metodoo para preparar los archivos JSON, CSV y DAT
     */
    public static void preparaEntornoYGenerarJsonInicial(){
        File fileJson = new File(rutaJson);
        File fileCSV = new File(rutaCSV);
        File fileDAT = new File(rutaDAT);
        List<Vehiculo> vehiculos = new ArrayList<>();
        try{
            if (!fileJson.exists() || !fileJson.isFile()){
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaJson))){
                    vehiculos.add(new Vehiculo(1, "Ford", 10000.0,30));
                    vehiculos.add(new Vehiculo(2, "Honda", 15000.0,30));
                    vehiculos.add(new Vehiculo(3, "Tesla", 100000.0,30));
                    gson.toJson(vehiculos, bw);
                    System.out.println("Se han dispuesto los datos iniciales");
                }
            }
            if (!fileCSV.exists() || !fileCSV.isFile()){
                fileCSV.createNewFile();
                System.out.println("Se a generado el fichero CSV");
            }
            if (!fileDAT.isFile() || !fileDAT.exists()){
                fileDAT.createNewFile();
                System.out.println("Se a generado el fichero DAT");
            }
        }catch (FileNotFoundException e){
            System.out.println("ERROR: "+ e.getMessage());
        }catch (IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }

    /**
     * Metodo para cargar una lista de vehiculos desde un archivo JSON
     * @param pathJson ruta del fichero JSON
     */
    public static List<Vehiculo> cargarVehiculoDesdeJson(String pathJson){
        Type type = new TypeToken<List<Vehiculo>>(){}.getType();
        try (BufferedReader br = new BufferedReader(new FileReader(pathJson))){
            List<Vehiculo> vehiculos = gson.fromJson(br, type);
            System.out.println(vehiculos);
            return vehiculos;
        }catch (IOException e){
            System.out.println("ERROR: "+ e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Metodo para escribir los vehiculos de la lista json en un fichero binario
     * @param pathDat ruta del fichero binario
     * @param vehiculos lista de vehiculos a escribir
     */
    public static void escribirVehiculoRaf(String pathDat, List<Vehiculo> vehiculos){
        try (RandomAccessFile raf = new RandomAccessFile(pathDat, "rw")){
            for (Vehiculo vehiculo : vehiculos){
                raf.writeInt(vehiculo.getId());
                raf.writeChars(ajustarMarca(vehiculo.getMarca()));
                raf.writeDouble(vehiculo.getPrecio());
                raf.writeInt(vehiculo.getStock());
            }
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    /**
     * Metodo para modificar el stock de un vehiculo en un fichero binario
     * @param pathDat ruta del fichero  binario
     * @param posicion posicion del vehiculo al cual cambiar el stock
     * @param nuevoStock nuevo stock del vehiculo a actualizar
     */
    public static void modificarStockRaf(String pathDat, int posicion, int nuevoStock){
        try (RandomAccessFile raf = new RandomAccessFile(pathDat, "rw")){
            long posicionNum = (long) posicion * TAMANO_TOTAL;
            if(posicion < 0 || posicionNum + TAMANO_TOTAL > raf.length()){
                System.out.println("Posicion fuera de rango "+posicion);
                return;
            }
            raf.seek(posicionNum*idBytes+marcaBytes+precioBytes);
            raf.writeInt(nuevoStock);
        }catch (IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }

    /**
     * Metodo para leer un fichero binario y devolverla lista de vehiculos
     * @param rutaDat ruta del fichero binario
     */
    public static List<Vehiculo> leerVehiculoSecuencial(String rutaDat){
        List<Vehiculo> vehiculosSecuenciales = new ArrayList<>();
        try (DataInputStream das = new DataInputStream(new FileInputStream(rutaDat))){
            while(das.available() > 0){
                int id = das.readInt();
                byte[] buffer = new byte[40];
                char marca = (char) das.read(buffer);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < marca; i++) {
                    sb.append(marca);
                }
                String marcaEntera= sb.toString().trim();
                double precio = das.readDouble();
                int stock = das.readInt();
                Vehiculo vehiculo = new Vehiculo(id,marcaEntera , precio, stock);
                vehiculosSecuenciales.add(vehiculo);
            }
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
        return  vehiculosSecuenciales;
    }

    /**
     * Metodo para exportar la informacion del fichero binario a un csv
     * @param rutaCSV ruta del csv
     * @param vehiculos informacion del fichero binario
     */
    public static void exportarBackUpCSV(String rutaCSV, List<Vehiculo>vehiculos){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaCSV))){
            bw.write("id;marca;precio;stock");
            bw.newLine();
            for(Vehiculo vehiculo : vehiculos){
                String id = vehiculo.getId() != null ? vehiculo.getId().toString(): null;
                String marca = vehiculo.getMarca() != null ? vehiculo.getMarca(): null;
                String precio = vehiculo.getPrecio() == null || vehiculo.getPrecio() >0 ? vehiculo.getPrecio().toString() :null ;
                String stock = vehiculo.getStock() == null || vehiculo.getStock() >0 ? vehiculo.getStock().toString() : null;
                bw.append(id+";"+marca+";"+precio+";"+stock+'\n');
            }
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }

    }

    /**
     * Metodo para ajustar el tamaño de la marca
     * @param marca
     * @return
     */
    public static String ajustarMarca(String marca){
        StringBuffer sb = new StringBuffer();
        sb.setLength(largoMarca);
        return sb.toString().replace('\0', ' ');
    }

}