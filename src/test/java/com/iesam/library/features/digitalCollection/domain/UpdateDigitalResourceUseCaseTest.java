package com.iesam.library.features.digitalCollection.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateDigitalResourceUseCaseTest {
    @Mock
    DigitalRepository digitalRepository;
    UpdateDigitalResourceUseCase updateDigitalResourceUseCase;

    @BeforeEach
    void setUp() {
        updateDigitalResourceUseCase = new UpdateDigitalResourceUseCase(digitalRepository);
    }

    @AfterEach
    void tearDown() {
        updateDigitalResourceUseCase = null;
    }

    @Test
    public void givenADigitalResourceThenTheUseCaseIsExecuted() {
        DigitalCollection digitalCollection = new DigitalCollection("001", TypeDigitalCollection.BOOK,
                "Libro1");

        updateDigitalResourceUseCase.execute(digitalCollection);

        Mockito.verify(digitalRepository, Mockito.times(1)).update(digitalCollection);
    }
}