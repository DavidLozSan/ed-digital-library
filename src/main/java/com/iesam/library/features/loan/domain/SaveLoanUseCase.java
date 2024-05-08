package com.iesam.library.features.loan.domain;

public class SaveLoanUseCase {
    public final LoanRepository loanRepository;

    public SaveLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(Loan loan) {
        this.loanRepository.save(loan);
    }
}
