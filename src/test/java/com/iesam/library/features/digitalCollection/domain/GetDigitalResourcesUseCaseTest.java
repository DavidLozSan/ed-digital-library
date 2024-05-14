package com.iesam.library.features.digitalCollection.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetDigitalResourcesUseCaseTest {
    @Mock
    DigitalRepository digitalRepository;
    GetDigitalResourcesUseCase getDigitalResourcesUseCase;

    @BeforeEach
    void setUp() {
        getDigitalResourcesUseCase = new GetDigitalResourcesUseCase(digitalRepository);
    }

    @AfterEach
    void tearDown() {
        getDigitalResourcesUseCase = null;
    }

    @Test
    public void theUseCaseIsExecutedThenReturnsTheDigitalResourcesList() {
        DigitalCollection digitalCollection1 = new DigitalCollection("001", TypeDigitalCollection.BOOK,
                "Libro1");
        DigitalCollection digitalCollection2 = new DigitalCollection("002", TypeDigitalCollection.MUSIC,
                "Musica1");
        List<DigitalCollection> expectedDigitalResourcesList = List.of(digitalCollection1, digitalCollection2);
        Mockito.when(digitalRepository.obtainDigitalResources()).thenReturn(expectedDigitalResourcesList);

        List<DigitalCollection> dititalResourcesListReceived = getDigitalResourcesUseCase.execute();

        assertEquals(dititalResourcesListReceived, expectedDigitalResourcesList);
    }
}