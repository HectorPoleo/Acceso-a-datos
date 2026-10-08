package org.example.Ejercicios.Repository;

import org.example.Ejercicios.model.Empleado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReedCSV {
    static List<Empleado> empleados = new ArrayList<>();
    public static void main(String[] args) {
        String path = "Pratica.csv";
        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            if(!file.exists() || !file.isFile()){
                file.createNewFile();
            }
            String line;
            while((line = br.readLine()) != null){
                String[] datos = line.split(";", -1);
                for (String dato : datos){
                    if(dato.isBlank()){
                        System.out.println("ERROR: la linea no cumple la estructura");
                        System.out.println(dato);

                    }
                }
                Empleado empleado = new Empleado(Integer.parseInt(datos[0]),
                        datos[1].isBlank() ? null : datos[1],
                        datos[2].isBlank() ? null : datos[2],
                        Double.parseDouble(datos[3]),
                        (datos[4].equals("1") ? true : false));
                empleados.add(empleado);
            }
            System.out.println(empleados);
        }catch (IOException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }
}
