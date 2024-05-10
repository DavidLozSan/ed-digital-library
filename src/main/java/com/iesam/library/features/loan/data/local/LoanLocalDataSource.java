package com.iesam.library.features.loan.data.local;

import com.iesam.library.features.loan.domain.Loan;

import java.util.List;

public interface LoanLocalDataSource {
    void save(Loan loan);

    void delete(String code);

    List<Loan> unfinishedLoans();

    List<Loan> finalizedLoans();
}
