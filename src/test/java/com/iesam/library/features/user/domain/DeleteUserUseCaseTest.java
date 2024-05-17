package com.iesam.library.features.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class DeleteUserUseCaseTest {
    @Mock
    UserRepository userRepository;
    DeleteUserUseCase deleteUserUseCase;

    @BeforeEach
    void setUp() {
        deleteUserUseCase = new DeleteUserUseCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        deleteUserUseCase = null;
    }

    @Test
    public void getAValidCodeAndThenRun() {
        String deleteUserCode = "001";

        deleteUserUseCase.execute(deleteUserCode);

        Mockito.verify(userRepository, Mockito.times(1)).delete(deleteUserCode);

    }
}