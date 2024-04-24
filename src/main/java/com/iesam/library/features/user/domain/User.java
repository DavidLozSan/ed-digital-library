package com.iesam.library.features.user.domain;

public class User {
    public final String codigo;
    public final String dni;
    public final String nombre;
    public final String apellidos;
    public final String fechaExped;
    public final String email;
    public final String telefono;

    public User(String codigo, String dni, String nombre, String apellidos, String fechaExped, String email, String telefono) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaExped = fechaExped;
        this.email = email;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "User{" +
                "codigo='" + codigo + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaExped='" + fechaExped + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
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

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }
}
