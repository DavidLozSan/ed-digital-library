package com.iesam.library.features.user.domain;

public class DeleteUserUseCase {
    public final UserRepository userRepository;

    public DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(String code) {
        this.userRepository.delete(code);
    }
}
