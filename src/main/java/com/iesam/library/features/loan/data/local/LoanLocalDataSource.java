package com.iesam.library.features.loan.data.local;

import com.iesam.library.features.loan.domain.Loan;

public interface LoanLocalDataSource {
    void save(Loan loan);

    void delete(String code);
}
