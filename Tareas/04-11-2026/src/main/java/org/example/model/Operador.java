package org.example.model;

import java.util.Objects;

public class Operador extends Faccion {
    int id;
    String codeName;
    String clase;
    int fechaLanzamiento;
    String nombreFaccion;

    public Operador() {
    }

    public Operador(int id) {
        this.id = id;
    }

    public Operador(int id, String codeName, String clase, int fechaLanzamiento, Faccion nombreFaccion) {
        super();
        this.id = id;
        this.codeName = codeName;
        this.clase = clase;
        this.fechaLanzamiento = fechaLanzamiento;
        this.nombreFaccion = nombreFaccion.getFaccion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(int fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getNombreFaccion() {
        return nombreFaccion;
    }

    public void setNombreFaccion(String nombreFaccion) {
        this.nombreFaccion = nombreFaccion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Operador operador = (Operador) o;
        return id == operador.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Operador{" +
                "id=" + id +
                ", codeName='" + codeName + '\'' +
                ", clase='" + clase + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", nombreFaccion='" + nombreFaccion + '\'' +
                '}';
    }
}
