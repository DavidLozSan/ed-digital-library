package com.iesam.library.features.user.domain;

import java.util.List;

public class GetUsersUseCase {
    public final UserRepository userRepository;

    public GetUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> execute() {
        return userRepository.obtainUsers();
    }
}
