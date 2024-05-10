package com.iesam.library.features.loan.domain;

import java.util.List;

public class GetUnfinishedLoansUseCase {
    public final LoanRepository loanRepository;

    public GetUnfinishedLoansUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> execute() {
        return loanRepository.unfinishedLoans();
    }
}
