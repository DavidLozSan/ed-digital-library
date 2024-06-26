package com.iesam.library.features.loan.domain;

import java.util.List;

public interface LoanRepository {
    void save(Loan loan);

    void delete(String code);

    List<Loan> unfinishedLoans();

    List<Loan> finalizedLoans();

    void finalizeLoan(Loan loan);

    Loan obtainLoan(String code);
}