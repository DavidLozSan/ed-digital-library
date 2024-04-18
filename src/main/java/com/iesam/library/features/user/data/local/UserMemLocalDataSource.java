package com.iesam.library.features.user.data.local;

import com.iesam.library.features.user.domain.User;

import java.util.*;

public class UserMemLocalDataSource {

    private Map<String, User> dataStore = new TreeMap<>();
    private static UserMemLocalDataSource instance = null;

    public void save(User model) {
        dataStore.put(model.getCodigo(), model);
    }

    public void saveList(List<User> models) {
        for (User demo : models) {
            save(demo);
        }
    }

    public User findByCodigo(String codigo) {
        return dataStore.get(codigo);
    }

    public List<User> findAll() {
        return dataStore.values().stream().toList();
    }

    public void delete(String modelCodigo) {
        dataStore.remove(modelCodigo);
    }

    public static UserMemLocalDataSource newInstance() {
        if (instance == null) {
            instance = new UserMemLocalDataSource();
        }
        return instance;
    }
}
