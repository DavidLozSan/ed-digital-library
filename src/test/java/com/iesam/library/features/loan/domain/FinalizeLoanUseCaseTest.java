package com.iesam.library.features.loan.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.TypeDigitalCollection;
import com.iesam.library.features.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FinalizeLoanUseCaseTest {
    @Mock
    LoanRepository loanRepository;
    @Mock
    LoanFactory loanFactory;
    FinalizeLoanUseCase finalizeLoanUseCase;

    @BeforeEach
    void setUp() {
        finalizeLoanUseCase = new FinalizeLoanUseCase(loanRepository, loanFactory);
    }

    @AfterEach
    void tearDown() {
        finalizeLoanUseCase = null;
    }

    @Test
    public void givenLoanCodeThenTheUseCaseFinalizesTheLoan() {
        String loanCode = "001";
        User user = new User("001", "1234", "David", "surnames", "16/05/2024",
                "correo", "777888555");
        DigitalCollection digitalCollection = new DigitalCollection("001", TypeDigitalCollection.BOOK,
                "Libro1");
        Loan loan = new Loan(loanCode, user, digitalCollection);
        Loan loanFinalized = new Loan(loan.code, loan.user, loan.digitalCollection, loan.loanStartDate,
                loan.loanEndDate);
        Mockito.when(loanRepository.obtainLoan(loanCode)).thenReturn(loan);
        Mockito.when(loanFactory.buildFinalized(loan.code, loan.user, loan.digitalCollection, loan.loanStartDate,
                loan.loanEndDate)).thenReturn(loanFinalized);

        finalizeLoanUseCase.execute(loanCode);

        Mockito.verify(loanRepository, Mockito.times(1)).obtainLoan(loanCode);
        Mockito.verify(loanFactory, Mockito.times(1)).buildFinalized(loan.code, loan.user,
                loan.digitalCollection, loan.loanStartDate, loan.loanEndDate);
        Mockito.verify(loanRepository, Mockito.times(1)).finalizeLoan(loanFinalized);
    }
}