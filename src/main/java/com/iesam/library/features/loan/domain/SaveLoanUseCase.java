package com.iesam.library.features.loan.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.book.domain.Book;
import com.iesam.library.features.digitalCollection.domain.book.domain.BookRepository;
import com.iesam.library.features.user.domain.User;
import com.iesam.library.features.digitalCollection.domain.TypeDigitalCollection;

public class SaveLoanUseCase {
    public final LoanRepository loanRepository;

    public SaveLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(Loan loan) {
        this.loanRepository.save(loan);
    }

    /*public void execute2(String userId, String digitalResourceCode) {
        //Obtener la info del usuario
        User user = userRepository.obtain(userId);

        //Obtener la info del recurso
        DigitalCollection digitalCollection = DigitalRepository.obtain(digitalResourceID);

        //Si es un libro, obtener la info del libro
        if (digitalCollection.digitalResourceType == TypeDigitalCollection.BOOK) {
            Book book = BookRepository.obtain(digitalResourceCode);
        }
    }*/
}
