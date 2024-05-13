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
    UpdateUserUserCase updateUserUserCase;

    @BeforeEach
    void setUp() {
        updateUserUserCase = new UpdateUserUserCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        updateUserUserCase = null;
    }

    @Test
    public void givenAUserThenTheUseCaseIsExecuted() {
        User user = new User("044", "77788899A", "David", "Apellidos",
                "13/05/2024", "david@correo.es", "777888999");

        updateUserUserCase.execute(user);

        Mockito.verify(userRepository, Mockito.times(1)).update(user);
    }

    @Test
    public void givenAnExistingUserWithNewInformationThenYourInformationIsModified() {
        User existingUser = new User("044", "77788899A", "David", "Apellidos",
                "13/05/2024", "david@correo.es", "777888999");
        User modifiedUser = new User("044", "77788899A", "Juan", "Apellidos",
                "13/05/2024", "juan@correo.es", "555222333");
        Mockito.when(userRepository.obtain(existingUser.code)).thenReturn(modifiedUser);

        updateUserUserCase.execute(modifiedUser);
        userRepository.obtain(existingUser.code);

        Assertions.assertEquals(modifiedUser.code, "044");
        Assertions.assertEquals(modifiedUser.dni, "77788899A");
        Assertions.assertEquals(modifiedUser.name, "Juan");
        Assertions.assertEquals(modifiedUser.surnames, "Apellidos");
        Assertions.assertEquals(modifiedUser.expeditionDate, "13/05/2024");
        Assertions.assertEquals(modifiedUser.email, "juan@correo.es");
        Assertions.assertEquals(modifiedUser.phone, "555222333");
    }
}