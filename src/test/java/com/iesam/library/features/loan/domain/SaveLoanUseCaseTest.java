package com.iesam.library.features.loan.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;
import com.iesam.library.features.digitalCollection.domain.TypeDigitalCollection;
import com.iesam.library.features.user.domain.User;
import com.iesam.library.features.user.domain.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    LoanFactory loanFactory;
    SaveLoanUseCase saveLoanUseCase;

    @BeforeEach
    void setUp() {
        saveLoanUseCase = new SaveLoanUseCase(loanRepository, userRepository, digitalRepository, loanFactory);
    }

    @AfterEach
    void tearDown() {
        saveLoanUseCase = null;
    }

    @Test
    public void givenABookLoanThenTheUseCaseIsExecuted() {
        String loanCode = "001";
        String userCode = "001";
        String resourceCode = "001";
        User user = new User(userCode, "1234", "David", "surnames", "16/05/2024",
                "correo", "777888555");
        DigitalCollection digitalCollection = new DigitalCollection(resourceCode, TypeDigitalCollection.BOOK,
                "Libro1");
        Loan loan = new Loan(loanCode, user, digitalCollection);

        Mockito.when(userRepository.obtain(userCode)).thenReturn(user);
        Mockito.when(digitalRepository.obtain(resourceCode)).thenReturn(digitalCollection);
        Mockito.when(loanFactory.buildActivated(loanCode, user, digitalCollection)).thenReturn(loan);


        saveLoanUseCase.execute(loanCode, userCode, resourceCode);

        Mockito.verify(userRepository, Mockito.times(1)).obtain(userCode);
        Mockito.verify(digitalRepository, Mockito.times(1)).obtain(resourceCode);
        Mockito.verify(loanFactory, Mockito.times(1)).buildActivated(
                loanCode, user, digitalCollection);
        Mockito.verify(loanRepository, Mockito.times(1)).save(loan);
    }
}