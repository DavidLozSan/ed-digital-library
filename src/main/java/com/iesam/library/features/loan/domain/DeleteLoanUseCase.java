package com.iesam.library.features.loan.domain;

public class DeleteLoanUseCase {
    public final LoanRepository loanRepository;

    public DeleteLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(String code) {
        this.loanRepository.delete(code);
    }
}
