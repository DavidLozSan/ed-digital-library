package com.iesam.library.features.loan.domain;

public class FinalizeLoanUseCase {
    public final LoanRepository loanRepository;
    public final LoanFactory loanFactory;

    public FinalizeLoanUseCase(LoanRepository loanRepository, LoanFactory loanFactory) {
        this.loanRepository = loanRepository;
        this.loanFactory = loanFactory;
    }

    public void execute(String code) {
        Loan loan = loanRepository.obtainLoan(code);
        Loan finalizeLoan = loanFactory.build(loan.code, loan.user, loan.digitalCollection, loan.loanStartDate,
                loan.loanEndDate);
        this.loanRepository.finalizeLoan(finalizeLoan);
    }
}