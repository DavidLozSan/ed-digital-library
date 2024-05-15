package com.iesam.library.features.digitalCollection.domain.book.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateBookUseCaseTest {
    @Mock
    BookRepository bookRepository;
    @Mock
    DigitalRepository digitalRepository;
    UpdateBookUseCase updateBookUseCase;

    @BeforeEach
    void setUp() {
        updateBookUseCase = new UpdateBookUseCase(bookRepository, digitalRepository);
    }

    @AfterEach
    void tearDown() {
        updateBookUseCase = null;
    }

    @Test
    public void givenABookThenTheUseCaseIsExecuted() {
        Book book = new Book("001", "Libro1", "Autor1", "Editorial1", "2000",
                "1234", "1234", "Terror");

        updateBookUseCase.execute(book);

        Mockito.verify(bookRepository, Mockito.times(1)).update(book);
        Mockito.verify(digitalRepository, Mockito.times(1)).update(
                Mockito.any(DigitalCollection.class));
    }
}