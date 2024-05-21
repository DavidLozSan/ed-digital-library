package com.iesam.library.features.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetUsersUseCaseTest {
    @Mock
    UserRepository userRepository;
    GetUsersUseCase getUsersUseCase;

    @BeforeEach
    void setUp() {
        getUsersUseCase = new GetUsersUseCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        getUsersUseCase = null;
    }

    @Test
    public void theUseCaseIsExecutedThenReturnsTheUserList() {
        User user1 = new User("001", "77755522A", "David", "Apellidos",
                "13/05/2024", "david@correo.es", "444222333");
        User user2 = new User("002", "69255522B", "Laura",
                "Apellidos", "13/05/2024", "laura@correo.es", "665221339");
        List<User> expectedUserList = List.of(user1, user2);
        Mockito.when(userRepository.obtainUsers()).thenReturn(expectedUserList);

        List<User> userListReceived = getUsersUseCase.execute();

        Assertions.assertEquals(userListReceived.size(), expectedUserList.size());
        Assertions.assertEquals(userListReceived.get(0).code, "001");
        Assertions.assertEquals(userListReceived.get(1).code, "002");

    }
}