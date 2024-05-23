package com.iesam.library.features.user.domain;

public class UserFactory {
    public User build(String code, String dni, String name, String surnames, String expeditionDate, String email,
                      String phone) {
        return new User(code, dni, name, surnames, expeditionDate, email, phone);
    }
}
