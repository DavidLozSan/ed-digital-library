package com.iesam.library.features.user.data;

import com.iesam.library.features.user.domain.User;
import com.iesam.library.features.user.domain.UserRepository;
import com.iesam.library.features.user.data.local.UserFileLocalDataSource;

import java.util.List;

public class UserDataRepository implements UserRepository {
    private UserFileLocalDataSource userFileLocalDataSource;

    public UserDataRepository(UserFileLocalDataSource userFileLocalDataSource) {
        this.userFileLocalDataSource = userFileLocalDataSource;
    }

    @Override
    public void save(User user) {
        userFileLocalDataSource.save(user);
    }

    @Override
    public List<User> obtainUsers() {
        return userFileLocalDataSource.findAll();
    }

    @Override
    public User obtain(String codigo) {
        return userFileLocalDataSource.findByCodigo(codigo);
    }

    @Override
    public void delete(String codigo) {
        userFileLocalDataSource.delete(codigo);
    }

    @Override
    public void update(User user) {
        userFileLocalDataSource.update(user);
    }
}
