package com.iesam.library.features.loan.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;
import com.iesam.library.features.user.domain.User;
import com.iesam.library.features.user.domain.UserRepository;

public class SaveLoanUseCase {
    public final LoanRepository loanRepository;
    public final UserRepository userRepository;
    public final DigitalRepository digitalRepository;
    public final LoanFactory loanFactory;

    public SaveLoanUseCase(LoanRepository loanRepository, UserRepository userRepository,
                           DigitalRepository digitalRepository, LoanFactory loanFactory) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.digitalRepository = digitalRepository;
        this.loanFactory = loanFactory;
    }

    public void execute(String loanCode, String userCode, String digitalResourceCode) {
        User user = userRepository.obtain(userCode);
        DigitalCollection digitalCollection = digitalRepository.obtain(digitalResourceCode);
        Loan loan = loanFactory.buildActivated(loanCode, user, digitalCollection);
        this.loanRepository.save(loan);
    }
}
