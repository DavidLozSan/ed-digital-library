package com.iesam.library.features.loan.domain;

public class GetLoanUseCase {
    public final LoanRepository loanRepository;

    public GetLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan execute(String code) {
        return loanRepository.obtainLoan(code);
    }
}
