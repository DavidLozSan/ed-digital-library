package com.iesam.library.features.digitalCollection.domain;

public class Book extends DigitalCollection {
    public final String autor;
    public final String editorial;
    public final String anioPublicacion;
    public final String numeroEdicion;
    public final String iSBN;
    public final String genero;

    public Book(String codigo, String tipoRecursoDigital, String nombre, String autor, String editorial, String anioPublicacion, String numeroEdicion, String iSBN, String genero) {
        super(codigo, tipoRecursoDigital, nombre);
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.numeroEdicion = numeroEdicion;
        this.iSBN = iSBN;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Book{" +
                "autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", anioPublicacion='" + anioPublicacion + '\'' +
                ", numeroEdicion='" + numeroEdicion + '\'' +
                ", iSBN='" + iSBN + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getNumeroEdicion() {
        return numeroEdicion;
    }

    public String getiSBN() {
        return iSBN;
    }

    public String getGenero() {
        return genero;
    }
}
