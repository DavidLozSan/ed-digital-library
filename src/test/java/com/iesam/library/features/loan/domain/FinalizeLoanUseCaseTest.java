package com.iesam.library.features.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FinalizeLoanUseCaseTest {
    @Mock
    LoanRepository loanRepository;
    FinalizeLoanUseCase finalizeLoanUseCase;

    @BeforeEach
    void setUp() {
        finalizeLoanUseCase = new FinalizeLoanUseCase(loanRepository);
    }

    @AfterEach
    void tearDown() {
        finalizeLoanUseCase = null;
    }
    /*
    @Test
    public void givenLoanCodeThenTheUseCaseFinalizesTheLoan() {
        String loanCode = "001";

        finalizeLoanUseCase.execute(loanCode);

        Mockito.verify(loanRepository, Mockito.times(1)).finalizeLoan(loanCode);
    }*/
}