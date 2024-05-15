package com.iesam.library.features.digitalCollection.domain.book.domain;

import com.iesam.library.features.digitalCollection.domain.TypeDigitalCollection;
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
class GetBookUseCaseTest {
    @Mock
    BookRepository bookRepository;
    GetBookUseCase getBookUseCase;

    @BeforeEach
    void setUp() {
        getBookUseCase = new GetBookUseCase(bookRepository);
    }

    @AfterEach
    void tearDown() {
        getBookUseCase = null;
    }

    @Test
    public void getACodeValidThenReturnABook() {
        Book bookExpected = new Book("001", "Libro1", "Autor1", "Editorial1",
                "2000", "1234", "1234", "Terror");
        Mockito.when(getBookUseCase.execute("001")).thenReturn(bookExpected);

        Book bookReceived = getBookUseCase.execute("001");

        Assertions.assertEquals(bookReceived.code, "001");
        Assertions.assertEquals(bookReceived.name, "Libro1");
        Assertions.assertEquals(bookReceived.author, "Autor1");
        Assertions.assertEquals(bookReceived.editorial, "Editorial1");
        Assertions.assertEquals(bookReceived.yearOfPublication, "2000");
        Assertions.assertEquals(bookReceived.editionNumber, "1234");
        Assertions.assertEquals(bookReceived.iSBN, "1234");
        Assertions.assertEquals(bookReceived.genre, "Terror");
        Assertions.assertEquals(bookReceived.digitalResourceType, TypeDigitalCollection.BOOK);
    }

    @Test
    public void getAnInvalidCodeAndThenReturnANull() {
        String invalidBookCode = "002";
        Mockito.when(getBookUseCase.execute("002")).thenReturn(null);

        Book bookReceived = getBookUseCase.execute(invalidBookCode);

        Assertions.assertNull(bookReceived);
    }
}