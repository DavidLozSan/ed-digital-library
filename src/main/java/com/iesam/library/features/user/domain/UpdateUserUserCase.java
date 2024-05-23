package com.iesam.library.features.user.domain;

public class UpdateUserUserCase {
    public final UserRepository userRepository;
    public final UserFactory userFactory;

    public UpdateUserUserCase(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    public void execute(String code, String dni, String name, String surnames, String expeditionDate, String email,
                        String phone) {
        User user = userFactory.build(code, dni, name, surnames, expeditionDate, email, phone);
        this.userRepository.update(user);
    }
}
