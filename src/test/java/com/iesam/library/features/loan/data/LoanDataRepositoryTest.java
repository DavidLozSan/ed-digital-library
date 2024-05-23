package com.iesam.library.features.loan.data;

import com.iesam.library.features.digitalCollection.book.domain.Book;
import com.iesam.library.features.loan.data.local.LoanMemLocalDataSource;
import com.iesam.library.features.loan.domain.Loan;
import com.iesam.library.features.loan.domain.LoanRepository;
import com.iesam.library.features.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;

class LoanDataRepositoryTest {
    @Mock
    private LoanMemLocalDataSource loanMemLocalDataSource;
    private LoanRepository loanRepository;

    @BeforeEach
    void setUp() {
        loanRepository = new LoanDataRepository(loanMemLocalDataSource);
    }

    @AfterEach
    void tearDown() {
        loanRepository = null;
    }

    /*
    @Test
    public void testSave() {
        String loanCode = "001";
        User user = new User("044", "77788899A", "David", "Apellidos",
                "13/05/2024", "david@correo.es", "777888999");
        Book book = new Book("001", "libro", "autor", "editorial", "2010",
                "2010", "ISBN", "Comedia");
        Loan loan = new Loan(loanCode, user, book);


        loanRepository.save(loan);


        Mockito.verify(loanMemLocalDataSource, Mockito.times(1)).save(loan);
    }
    */

}