package com.iesam.library.features.loan.domain;

import java.util.List;

public class GetFinalizedLoansUseCase {
    public final LoanRepository loanRepository;

    public GetFinalizedLoansUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> execute() {
        return loanRepository.finalizedLoans();
    }
}
