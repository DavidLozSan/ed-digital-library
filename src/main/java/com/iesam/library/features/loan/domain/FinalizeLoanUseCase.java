package com.iesam.library.features.loan.domain;

public class FinalizeLoanUseCase {
    public final LoanRepository loanRepository;

    public FinalizeLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(String code) {
        this.loanRepository.finalizeLoan(code);
    }
}
