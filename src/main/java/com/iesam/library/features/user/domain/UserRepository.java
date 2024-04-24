package com.iesam.library.features.user.domain;

public interface UserRepository {
    void save(User user);
    User obtain(String codigo);
}
