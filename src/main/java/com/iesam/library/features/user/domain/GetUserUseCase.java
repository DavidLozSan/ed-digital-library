package com.iesam.library.features.user.domain;

public class GetUserUseCase {
    public final UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String codigo) {
        return userRepository.obtain(codigo);
    }
}
