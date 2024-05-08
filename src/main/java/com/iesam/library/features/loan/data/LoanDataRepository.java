package com.iesam.library.features.loan.data;

import com.iesam.library.features.loan.data.local.LoanLocalDataSource;
import com.iesam.library.features.loan.domain.Loan;
import com.iesam.library.features.loan.domain.LoanRepository;

public class LoanDataRepository implements LoanRepository {

    private final LoanLocalDataSource loanLocalDataSource;

    public LoanDataRepository(LoanLocalDataSource loanLocalDataSource) {
        this.loanLocalDataSource = loanLocalDataSource;
    }

    @Override
    public void save(Loan loan) {
        loanLocalDataSource.save(loan);
    }
}
