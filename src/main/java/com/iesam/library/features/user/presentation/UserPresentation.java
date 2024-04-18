package com.iesam.library.features.user.presentation;

import com.iesam.library.features.user.data.UserDataRepository;
import com.iesam.library.features.user.data.local.UserFileLocalDataSource;
import com.iesam.library.features.user.domain.SaveUserUseCase;
import com.iesam.library.features.user.domain.User;

public class UserPresentation {
    public static void save(User user) {
        SaveUserUseCase saveUserUseCase = new SaveUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        saveUserUseCase.execute(user);
    }
}
