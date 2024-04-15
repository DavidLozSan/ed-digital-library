package com.iesam.library.features.user.domain;

public class User {
    public final String codigo;
    public final String dni;
    public final String nombre;
    public final String apellidos;
    public final String fechaExped;

    public User(String codigo, String dni, String nombre, String apellidos, String fechaExped) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaExped = fechaExped;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaExped() {
        return fechaExped;
    }
}
