package com.iesam.library.features.user.domain;

public class SaveUserUseCase {
    public final UserRepository userRepository;

    public SaveUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(User user) {
        this.userRepository.save(user);
    }
}
