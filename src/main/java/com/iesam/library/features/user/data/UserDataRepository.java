package com.iesam.library.features.user.data;

import com.iesam.library.features.user.domain.User;
import com.iesam.library.features.user.domain.UserRepository;
import com.iesam.library.features.user.data.local.UserFileLocalDataSource;

public class UserDataRepository implements UserRepository {
    private UserFileLocalDataSource userFileLocalDataSource;

    public UserDataRepository(UserFileLocalDataSource userFileLocalDataSource) {
        this.userFileLocalDataSource = userFileLocalDataSource;
    }

    @Override
    public void save(User user) {
        userFileLocalDataSource.save(user);
    }
}
