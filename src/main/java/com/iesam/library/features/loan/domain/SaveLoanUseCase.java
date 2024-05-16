package com.iesam.library.features.loan.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;
import com.iesam.library.features.digitalCollection.domain.book.domain.Book;
import com.iesam.library.features.digitalCollection.domain.book.domain.BookRepository;
import com.iesam.library.features.user.domain.User;
import com.iesam.library.features.user.domain.UserRepository;

public class SaveLoanUseCase {
    public final LoanRepository loanRepository;
    public final UserRepository userRepository;
    public final DigitalRepository digitalRepository;
    public final BookRepository bookRepository;

    public SaveLoanUseCase(LoanRepository loanRepository, UserRepository userRepository,
                           DigitalRepository digitalRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.digitalRepository = digitalRepository;
        this.bookRepository = bookRepository;
    }

    public void execute(String loanCode, String userCode, String digitalResourceCode) {
        User user = userRepository.obtain(userCode);

        DigitalCollection digitalCollection = digitalRepository.obtain(digitalResourceCode);

        switch (digitalCollection.digitalResourceType) {
            case BOOK:
                Book book = bookRepository.obtain(digitalResourceCode);
                Loan bookLoan = new Loan(loanCode, user, book);
                this.loanRepository.save(bookLoan);
                break;
        }

    }
}
