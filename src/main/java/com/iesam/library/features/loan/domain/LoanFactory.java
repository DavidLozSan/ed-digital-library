package com.iesam.library.features.loan.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.user.domain.User;

public class LoanFactory {
    public static Loan build(String id, User user, DigitalCollection digitalCollection, String loanStartDate, String loanEndDate) {
        Loan loan = new Loan(id, user, digitalCollection, loanStartDate, loanEndDate);
        return loan;
    }
}
