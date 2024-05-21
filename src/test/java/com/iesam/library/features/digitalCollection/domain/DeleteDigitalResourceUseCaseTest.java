package com.iesam.library.features.digitalCollection.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteDigitalResourceUseCaseTest {
    @Mock
    DigitalRepository digitalRepository;
    DeleteDigitalResourceUseCase deleteDigitalResourceUseCase;

    @BeforeEach
    void setUp() {
        deleteDigitalResourceUseCase = new DeleteDigitalResourceUseCase(digitalRepository);
    }

    @AfterEach
    void tearDown() {
        deleteDigitalResourceUseCase = null;
    }

    @Test
    public void getAValidCodeAndThenRun() {
        String deleteDigitalResourceCode = "001";

        deleteDigitalResourceUseCase.execute(deleteDigitalResourceCode);

        Mockito.verify(digitalRepository, Mockito.times(1)).delete(deleteDigitalResourceCode);
    }
}