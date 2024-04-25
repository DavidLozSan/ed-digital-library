package com.iesam.library.features.user.domain;

public class UpdateUserUseCase {
    public final UserRepository userRepository;

    public UpdateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(String codigo) {
        this.userRepository.update(codigo);
    }
}
