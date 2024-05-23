package com.iesam.library.features.user.domain;

public class User {
    public final String code;
    public final String dni;
    public final String name;
    public final String surnames;
    public final String expeditionDate;
    public final String email;
    public final String phone;

    public User(String code, String dni, String name, String surnames, String expeditionDate, String email,
                String phone) {
        this.code = code;
        this.dni = dni;
        this.name = name;
        this.surnames = surnames;
        this.expeditionDate = expeditionDate;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" + "code='" + code + '\'' + ", dni='" + dni + '\'' + ", name='" + name + '\'' + "," +
                " surnames='" + surnames + '\'' + ", expeditionDate='" + expeditionDate + '\'' + "," +
                " email='" + email + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
