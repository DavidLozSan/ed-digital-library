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
class DeleteLoanUseCaseTest {
    @Mock
    LoanRepository loanRepository;
    DeleteLoanUseCase deleteLoanUseCase;

    @BeforeEach
    void setUp() {
        deleteLoanUseCase = new DeleteLoanUseCase(loanRepository);
    }

    @AfterEach
    void tearDown() {
        deleteLoanUseCase = null;
    }

    @Test
    public void givenLoanCodeThenTheUseCaseDeletesTheLoan() {
        String loanCode = "001";

        deleteLoanUseCase.execute(loanCode);

        Mockito.verify(loanRepository, Mockito.times(1)).delete(loanCode);
    }
}