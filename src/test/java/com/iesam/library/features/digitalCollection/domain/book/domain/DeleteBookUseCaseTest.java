package com.iesam.library.features.digitalCollection.domain.book.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DeleteBookUseCaseTest {
    @Mock
    BookRepository bookRepository;
    @Mock
    DigitalRepository digitalRepository;
    DeleteBookUseCase deleteBookUseCase;

    @BeforeEach
    void setUp() {
        deleteBookUseCase = new DeleteBookUseCase(bookRepository, digitalRepository);
    }

    @AfterEach
    void tearDown() {
        deleteBookUseCase = null;
    }

    @Test
    public void getAValidCodeAndThenRun() {
        String deleteBookCode = "001";

        deleteBookUseCase.execute("001");

        Mockito.verify(bookRepository, Mockito.times(1)).delete(deleteBookCode);
        Mockito.verify(digitalRepository, Mockito.times(1)).delete(deleteBookCode);
    }
}