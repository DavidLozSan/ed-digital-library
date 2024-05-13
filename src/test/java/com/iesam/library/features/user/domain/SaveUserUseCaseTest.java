package com.iesam.library.features.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SaveUserUseCaseTest {
    @Mock
    UserRepository userRepository;
    SaveUserUseCase saveUserUseCase;

    @BeforeEach
    void setUp() {
        saveUserUseCase = new SaveUserUseCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        saveUserUseCase = null;
    }

    @Test
    public void receiveAUserAndSave() {
        User user = new User("044", "77788899A", "David", "Apellidos",
                "13/05/2024", "david@correo.es", "777888999");

        saveUserUseCase.execute(user);

        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }
}