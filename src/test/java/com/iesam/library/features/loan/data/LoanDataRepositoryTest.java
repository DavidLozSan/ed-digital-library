package com.iesam.library.features.loan.data;

import com.iesam.library.features.digitalCollection.book.domain.Book;
import com.iesam.library.features.digitalCollection.music.domain.Music;
import com.iesam.library.features.loan.data.local.LoanMemLocalDataSource;
import com.iesam.library.features.loan.domain.Loan;
import com.iesam.library.features.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class LoanDataRepositoryTest {
    @Mock
    private LoanMemLocalDataSource loanMemLocalDataSource;
    private LoanDataRepository loanDataRepository;

    @BeforeEach
    void setUp() {
        loanDataRepository = new LoanDataRepository(loanMemLocalDataSource);
    }

    @AfterEach
    void tearDown() {
        loanDataRepository = null;
    }


    @Test
    public void saveMethodCallsTheDataSourceInMemory() {
        String loanCode = "001";
        User user = new User("044", "77788899A", "David", "Apellidos",
                "13/05/2024", "david@correo.es", "777888999");
        Book book = new Book("001", "libro", "autor", "editorial", "2010",
                "2010", "ISBN", "Comedia");
        Loan loan = new Loan(loanCode, user, book);


        loanDataRepository.save(loan);


        Mockito.verify(loanMemLocalDataSource, Mockito.times(1)).save(loan);
    }

    @Test
    public void deleteMethodCallsTheDataSourceInMemory() {
        String loanCode = "001";

        loanDataRepository.delete(loanCode);

        Mockito.verify(loanMemLocalDataSource, Mockito.times(1)).delete(loanCode);
    }

    @Test
    public void unfinishedLoansMethodCallsTheInMemoryDataSourceAndReturnsAListOfUnfinishedLoans() {
        User user = new User("044", "77788899A", "David", "Apellidos",
                "13/05/2024", "david@correo.es", "777888999");
        Book book = new Book("001", "libro", "autor", "editorial", "2010",
                "2010", "ISBN", "Comedia");
        Music music = new Music("002", "musica1", "artista", "album", "2020",
                "Pop", "3:10");
        Loan loan1 = new Loan("001", user, book);
        Loan loan2 = new Loan("002", user, music);
        List<Loan> expectedList = new ArrayList<>();
        expectedList.add(loan1);
        expectedList.add(loan2);

        Mockito.when(loanMemLocalDataSource.unfinishedLoans()).thenReturn(expectedList);

        List<Loan> receivedList = loanDataRepository.unfinishedLoans();

        Assertions.assertEquals(receivedList.size(), expectedList.size());
        Assertions.assertEquals(receivedList.get(0).code, "001");
        Assertions.assertEquals(receivedList.get(1).code, "002");
        Assertions.assertEquals(receivedList.get(0).loanStatus, "Activo");
        Assertions.assertEquals(receivedList.get(1).loanStatus, "Activo");
        Mockito.verify(loanMemLocalDataSource, Mockito.times(1)).unfinishedLoans();
    }

    @Test
    public void finalizedLoansMethodCallsTheInMemoryDataSourceAndReturnsAListOfUnfinishedLoans() {
        User user = new User("044", "77788899A", "David", "Apellidos",
                "13/05/2024", "david@correo.es", "777888999");
        Book book = new Book("001", "libro", "autor", "editorial", "2010",
                "2010", "ISBN", "Comedia");
        Music music = new Music("002", "musica1", "artista", "album", "2020",
                "Pop", "3:10");
        Loan loan1 = new Loan("001", user, book, "24/05/2024", "01/06/2024");
        Loan loan2 = new Loan("002", user, music, "25/05/2024", "02/06/2024");
        List<Loan> expectedList = new ArrayList<>();
        expectedList.add(loan1);
        expectedList.add(loan2);

        Mockito.when(loanMemLocalDataSource.finalizedLoans()).thenReturn(expectedList);

        List<Loan> receivedList = loanDataRepository.finalizedLoans();

        Assertions.assertEquals(receivedList.size(), expectedList.size());
        Assertions.assertEquals(receivedList.get(0).code, "001");
        Assertions.assertEquals(receivedList.get(1).code, "002");
        Assertions.assertEquals(receivedList.get(0).loanStatus, "Finalizado");
        Assertions.assertEquals(receivedList.get(1).loanStatus, "Finalizado");
        Mockito.verify(loanMemLocalDataSource, Mockito.times(1)).finalizedLoans();
    }

    @Test
    public void finalizeLoanMethodCallsTheDataSourceInMemory() {
        User user = new User("044", "77788899A", "David", "Apellidos",
                "13/05/2024", "david@correo.es", "777888999");
        Book book = new Book("001", "libro", "autor", "editorial", "2010",
                "2010", "ISBN", "Comedia");
        Loan loan = new Loan("001", user, book);

        loanDataRepository.finalizeLoan(loan);

        Mockito.verify(loanMemLocalDataSource, Mockito.times(1)).finalizeLoan(loan);
    }

    @Test
    public void obtainLoanMethodCallsTheInMemoryDataSourceAndReturnsALoan() {
        String loanCode = "001";
        User user = new User("044", "77788899A", "David", "Apellidos",
                "13/05/2024", "david@correo.es", "777888999");
        Book book = new Book("001", "libro", "autor", "editorial", "2010",
                "2010", "ISBN", "Comedia");
        Loan loan = new Loan(loanCode, user, book);

        Mockito.when(loanDataRepository.obtainLoan(loanCode)).thenReturn(loan);

        Loan receivedLoan = loanDataRepository.obtainLoan(loanCode);

        Assertions.assertEquals(receivedLoan.code, "001");
        Assertions.assertEquals(receivedLoan.user, user);
        Assertions.assertEquals(receivedLoan.digitalCollection, book);
        Assertions.assertEquals(receivedLoan.loanStartDate, loan.loanStartDate);
        Assertions.assertEquals(receivedLoan.loanEndDate, loan.loanEndDate);
        Assertions.assertEquals(receivedLoan.loanStatus, "Activo");
        Mockito.verify(loanMemLocalDataSource, Mockito.times(1)).findByCode(loanCode);
    }
}