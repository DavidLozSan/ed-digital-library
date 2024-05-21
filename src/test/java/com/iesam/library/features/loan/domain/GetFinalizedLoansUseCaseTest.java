package com.iesam.library.features.loan.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.TypeDigitalCollection;
import com.iesam.library.features.user.domain.User;
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
class GetFinalizedLoansUseCaseTest {
    @Mock
    LoanRepository loanRepository;
    GetFinalizedLoansUseCase getFinalizedLoansUseCase;

    @BeforeEach
    void setUp() {
        getFinalizedLoansUseCase = new GetFinalizedLoansUseCase(loanRepository);
    }

    @AfterEach
    void tearDown() {
        getFinalizedLoansUseCase = null;
    }

    @Test
    public void givenFinalizedLoansThenTheUseCaseReturnsThem() {
        Loan loan1 = new Loan("001", new User("001", "aaa", "aaa", "aaa",
                "16/05/2024", "aaa", "66885544"), new DigitalCollection(
                "001", TypeDigitalCollection.BOOK, "aaa"), "16/05/2024", "1/06/2024");
        Loan loan2 = new Loan("002", new User("001", "aaa", "aaa", "aaa",
                "16/05/2024", "aaa", "66885544"), new DigitalCollection(
                "002", TypeDigitalCollection.BOOK, "bbb"), "16/05/2024", "1/06/2024");
        List<Loan> finalizedLoans = List.of(loan1, loan2);

        Mockito.when(loanRepository.finalizedLoans()).thenReturn(finalizedLoans);

        List<Loan> result = getFinalizedLoansUseCase.execute();

        Assertions.assertEquals(finalizedLoans, result);
        Mockito.verify(loanRepository, Mockito.times(1)).finalizedLoans();
    }
}