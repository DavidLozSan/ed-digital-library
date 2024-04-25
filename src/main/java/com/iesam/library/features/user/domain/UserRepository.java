package com.iesam.library.features.user.domain;

import java.util.List;

public interface UserRepository {
    void save(User user);

    List<User> obtainUsers();

    User obtain(String codigo);

    void delete(String codigo);
    void update(User user);
}
