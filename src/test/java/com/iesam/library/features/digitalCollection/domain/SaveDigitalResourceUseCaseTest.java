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
class SaveDigitalResourceUseCaseTest {
    @Mock
    DigitalRepository digitalRepository;
    SaveDigitalResourceUseCase saveDigitalResourceUseCase;

    @BeforeEach
    void setUp() {
        saveDigitalResourceUseCase = new SaveDigitalResourceUseCase(digitalRepository);
    }

    @AfterEach
    void tearDown() {
        saveDigitalResourceUseCase = null;
    }

    @Test
    public void receiveADigitalCollectionAndSave() {
        DigitalCollection digitalCollection = new DigitalCollection("001", TypeDigitalCollection.BOOK,
                "Libro1");

        saveDigitalResourceUseCase.execute(digitalCollection);

        Mockito.verify(digitalRepository, Mockito.times(1)).save(digitalCollection);
    }
}