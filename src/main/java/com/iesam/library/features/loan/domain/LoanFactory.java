package com.iesam.library.features.loan.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.user.domain.User;

public class LoanFactory {
    public Loan buildFinalized(String id, User user, DigitalCollection digitalCollection, String loanStartDate,
                      String loanEndDate) {
        return new Loan(id, user, digitalCollection, loanStartDate, loanEndDate);
    }

    public Loan buildActivated(String id, User user, DigitalCollection digitalCollection) {
        return new Loan(id, user, digitalCollection);
    }
}
