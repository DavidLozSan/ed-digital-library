package com.iesam.library.features.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class GetUserUseCaseTest {
    @Mock
    UserRepository userRepository;
    GetUserUseCase getUserUseCase;

    @BeforeEach
    void setUp() {
        getUserUseCase = new GetUserUseCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        getUserUseCase = null;
    }

    @Test
    public void getACodeValidThenReturnAUser() {
        User userExpected = new User("055", "100", "David", "Apellidos",
                "13/05/2024", "david@correo.es", "777888999");
        Mockito.when(userRepository.obtain("055")).thenReturn(userExpected);

        User userReceived = getUserUseCase.execute("055");

        Assertions.assertEquals(userExpected.code, "055");
        Assertions.assertEquals(userExpected.dni, "100");
        Assertions.assertEquals(userExpected.name, "David");
        Assertions.assertEquals(userExpected.surnames, "Apellidos");
        Assertions.assertEquals(userExpected.expeditionDate, "13/05/2024");
        Assertions.assertEquals(userExpected.email, "david@correo.es");
        Assertions.assertEquals(userExpected.phone, "777888999");
    }

    @Test
    public void getAnInvalidCodeAndThenReturnANull() {
        Mockito.when(userRepository.obtain("055")).thenReturn(null);

        User userReceived = getUserUseCase.execute("055");

        Assertions.assertNull(userReceived);
    }
}