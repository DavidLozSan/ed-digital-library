package com.iesam.library.features.loan.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalRepository;
import com.iesam.library.features.digitalCollection.book.domain.BookRepository;
import com.iesam.library.features.digitalCollection.music.domain.MusicRepository;
import com.iesam.library.features.user.domain.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SaveLoanUseCaseTest {
    @Mock
    LoanRepository loanRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    DigitalRepository digitalRepository;
    @Mock
    BookRepository bookRepository;
    @Mock
    MusicRepository musicRepository;
    SaveLoanUseCase saveLoanUseCase;

    @BeforeEach
    void setUp() {
        saveLoanUseCase = new SaveLoanUseCase(loanRepository, userRepository, digitalRepository, );
    }

    @AfterEach
    void tearDown() {
        saveLoanUseCase = null;
    }
    /*
    @Test
    public void givenABookLoanThenTheUseCaseIsExecuted() {
        String loanCode = "001";
        String userCode = "001";
        String resourceCode = "001";
        User user = new User(userCode, "1234", "David", "surnames", "16/05/2024",
                "correo", "777888555");
        Book book = new Book(resourceCode, "Libro1", "Autor1", "Editorial1", "2000",
                "1234", "1234", "Terror");
        DigitalCollection digitalCollection = new DigitalCollection(resourceCode, TypeDigitalCollection.BOOK,
                "Libro1");


        Mockito.when(userRepository.obtain(userCode)).thenReturn(user);
        Mockito.when(digitalRepository.obtain(resourceCode)).thenReturn(digitalCollection);
        Mockito.when(bookRepository.obtain(resourceCode)).thenReturn(book);


        saveLoanUseCase.execute(loanCode, userCode, resourceCode);


        ArgumentCaptor<Loan> loanCaptor = ArgumentCaptor.forClass(Loan.class);
        Mockito.verify(loanRepository, Mockito.times(1)).save(loanCaptor.capture());
        Loan capturedLoan = loanCaptor.getValue();

        Assertions.assertEquals(loanCode, capturedLoan.code);
        Assertions.assertEquals(user, capturedLoan.user);
        Assertions.assertEquals(book, capturedLoan.digitalCollection);

    }
     */
}