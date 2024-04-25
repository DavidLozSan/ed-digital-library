package com.iesam.library.features.digitalCollection.domain;

public class DigitalCollection {
    public final String codigo;
    public final String tipoRecursoDigital;
    public final String nombre;

    public DigitalCollection(String codigo, String tipoRecursoDigital, String nombre) {
        this.codigo = codigo;
        this.tipoRecursoDigital = tipoRecursoDigital;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DigitalCollection{" +
                "codigo='" + codigo + '\'' +
                ", tipoRecursoDigital='" + tipoRecursoDigital + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipoRecursoDigital() {
        return tipoRecursoDigital;
    }

    public String getNombre() {
        return nombre;
    }
}
