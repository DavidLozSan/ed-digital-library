package com.iesam.library.features.digitalCollection.domain.book.domain;

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
class GetBooksUseCaseTest {
    @Mock
    BookRepository bookRepository;
    GetBooksUseCase getBooksUseCase;

    @BeforeEach
    void setUp() {
        getBooksUseCase = new GetBooksUseCase(bookRepository);
    }

    @AfterEach
    void tearDown() {
        getBooksUseCase = null;
    }

    @Test
    public void theUseCaseIsExecutedThenReturnsTheBooksList() {
        Book book1 = new Book("001", "Libro1", "Autor1", "Editorial1",
                "2000", "1234", "1234", "Terror");
        Book book2 = new Book("002", "Libro2", "Autor2", "Editorial2",
                "2000", "1234", "4569", "Terror");
        List<Book> expectedBooksList = List.of(book1, book2);
        Mockito.when(getBooksUseCase.execute()).thenReturn(expectedBooksList);

        List<Book> listOfBooksReceived = getBooksUseCase.execute();

        Assertions.assertEquals(listOfBooksReceived, expectedBooksList);
    }
}