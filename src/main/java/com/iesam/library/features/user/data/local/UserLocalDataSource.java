package com.iesam.library.features.user.data.local;

import com.iesam.library.features.user.domain.User;

import java.util.List;

public interface UserLocalDataSource {
    void save(User user);

    void saveList(List<User> users);

    User findByCode(String code);

    List<User> findAll();

    void delete(String code);

    void update(User user);
}
