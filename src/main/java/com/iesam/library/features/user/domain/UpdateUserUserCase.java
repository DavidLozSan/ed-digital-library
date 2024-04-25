package com.iesam.library.features.user.domain;

public class UpdateUserUserCase {
    public final UserRepository userRepository;

    public UpdateUserUserCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(User user) {
        this.userRepository.update(user);
    }
}
