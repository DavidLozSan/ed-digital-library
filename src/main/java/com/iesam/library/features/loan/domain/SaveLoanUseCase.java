package com.iesam.library.features.loan.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;
import com.iesam.library.features.digitalCollection.book.domain.Book;
import com.iesam.library.features.digitalCollection.book.domain.BookRepository;
import com.iesam.library.features.digitalCollection.music.domain.Music;
import com.iesam.library.features.digitalCollection.music.domain.MusicRepository;
import com.iesam.library.features.user.domain.User;
import com.iesam.library.features.user.domain.UserRepository;

public class SaveLoanUseCase {
    public final LoanRepository loanRepository;
    public final UserRepository userRepository;
    public final DigitalRepository digitalRepository;

    public SaveLoanUseCase(LoanRepository loanRepository, UserRepository userRepository,
                           DigitalRepository digitalRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.digitalRepository = digitalRepository;
    }

    public void execute(String loanCode, String userCode, String digitalResourceCode) {
        User user = userRepository.obtain(userCode);
        DigitalCollection digitalCollection = digitalRepository.obtain(digitalResourceCode);
        Loan musicLoan = new Loan(loanCode, user, digitalCollection);
        this.loanRepository.save(musicLoan);
    }
}
