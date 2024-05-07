package com.iesam.library.features.user.data;

import com.iesam.library.features.user.data.local.UserLocalDataSource;
import com.iesam.library.features.user.domain.User;
import com.iesam.library.features.user.domain.UserRepository;

import java.util.List;

public class UserDataRepository implements UserRepository {
    private final UserLocalDataSource userLocalDataSource;

    public UserDataRepository(UserLocalDataSource userLocalDataSource) {
        this.userLocalDataSource = userLocalDataSource;
    }

    @Override
    public void save(User user) {
        userLocalDataSource.save(user);
    }

    @Override
    public List<User> obtainUsers() {
        return userLocalDataSource.findAll();
    }

    @Override
    public User obtain(String code) {
        return userLocalDataSource.findByCode(code);
    }

    @Override
    public void delete(String code) {
        userLocalDataSource.delete(code);
    }

    @Override
    public void update(User user) {
        userLocalDataSource.update(user);
    }
}
