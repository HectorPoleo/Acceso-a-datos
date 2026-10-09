package org.example.Ejercicios.Repository;

import org.example.Ejercicios.model.Empleado;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WritterCsv {

    /**
     * Metodo para escribir en un fichero csv
     * @param args
     */
    public static void main(String[] args) {
        String path = "Pratica.csv";
        File file = new File(path);
        List<Empleado> empleados = new ArrayList<>();
        Empleado e1 = new Empleado(12, "49512097c", "Hector", 20000.0, true );
        empleados.add(e1);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            if(!file.exists() || !file.isFile()){
                file.createNewFile();
            }
            for (Empleado empleado : empleados){
                bw.write(String.valueOf(empleado.getNumEmpleado())+";"+
                        (empleado.getDni() == null ? "" : empleado.getDni())+";"
                        +(empleado.getNombre() == null ? "" : empleado.getNombre())+";"
                        +String.valueOf(empleado.getSalarioBrutoAnual()) +";"
                        +(empleado.getTiempoPracial() == true ? "1" : "0"));
                bw.newLine();
            }
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
