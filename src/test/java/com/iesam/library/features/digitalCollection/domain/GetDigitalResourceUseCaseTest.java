package com.iesam.library.features.digitalCollection.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetDigitalResourceUseCaseTest {
    @Mock
    DigitalRepository digitalRepository;
    GetDigitalResourceUseCase getDigitalResourceUseCase;

    @BeforeEach
    void setUp() {
        getDigitalResourceUseCase = new GetDigitalResourceUseCase(digitalRepository);
    }

    @AfterEach
    void tearDown() {
        getDigitalResourceUseCase = null;
    }

    @Test
    public void getACodeValidThenReturnADigitalResource() {
        DigitalCollection digitalCollectionExpected = new DigitalCollection("001", TypeDigitalCollection.BOOK,
                "Libro1");
        Mockito.when(digitalRepository.obtain("001")).thenReturn(digitalCollectionExpected);

        DigitalCollection digitalCollectionReceived = getDigitalResourceUseCase.execute("001");

        Assertions.assertEquals(digitalCollectionReceived.code, "001");
        Assertions.assertEquals(digitalCollectionReceived.digitalResourceType, TypeDigitalCollection.BOOK);
        Assertions.assertEquals(digitalCollectionReceived.name, "Libro1");
    }

    @Test
    public void getAnInvalidCodeAndThenReturnANull() {
        Mockito.when(digitalRepository.obtain("452")).thenReturn(null);

        DigitalCollection digitalCollectionReceived = getDigitalResourceUseCase.execute("452");

        Assertions.assertNull(digitalCollectionReceived);
    }
}