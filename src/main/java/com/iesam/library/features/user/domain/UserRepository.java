package com.iesam.library.features.user.domain;

import java.util.List;

public interface UserRepository {
    void save(User user);

    List<User> obtainUsers();

    User obtain(String code);

    void delete(String code);

    void update(User user);
}
