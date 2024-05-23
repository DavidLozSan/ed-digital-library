package com.iesam.library.features.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UpdateUserUserCaseTest {
    @Mock
    UserRepository userRepository;
    @Mock
    UserFactory userFactory;
    UpdateUserUserCase updateUserUserCase;

    @BeforeEach
    void setUp() {
        updateUserUserCase = new UpdateUserUserCase(userRepository, userFactory);
    }

    @AfterEach
    void tearDown() {
        updateUserUserCase = null;
    }

    @Test
    public void givenAUserThenTheUseCaseIsExecuted() {
        User user = new User("044", "77788899A", "David", "Apellidos",
                "13/05/2024", "david@correo.es", "777888999");
        Mockito.when(userFactory.build(user.code, user.dni, user.name, user.surnames, user.expeditionDate,
                user.email, user.phone)).thenReturn(user);

        updateUserUserCase.execute(user.code, user.dni, user.name, user.surnames, user.expeditionDate,
                user.email, user.phone);

        Mockito.verify(userFactory, Mockito.times(1)).build(user.code, user.dni, user.name, user.surnames, user.expeditionDate,
                user.email, user.phone);
        Mockito.verify(userRepository, Mockito.times(1)).update(user);
    }
}