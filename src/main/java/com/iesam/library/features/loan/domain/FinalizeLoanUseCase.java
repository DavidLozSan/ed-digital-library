package com.iesam.library.features.loan.domain;

public class FinalizeLoanUseCase {
    public final LoanRepository loanRepository;

    public FinalizeLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(String code) {
        Loan loan = loanRepository.obtainLoan(code);
        Loan finalizeLoan = new Loan(loan.code, loan.user, loan.digitalCollection, loan.loanStartDate,
                loan.loanEndDate);
        this.loanRepository.finalizeLoan(finalizeLoan);
    }
}