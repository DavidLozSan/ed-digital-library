package com.iesam.library.features.digitalCollection.book.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalRepository;

public class DeleteBookUseCase {
    public final BookRepository bookRepository;
    public final DigitalRepository digitalRepository;

    public DeleteBookUseCase(BookRepository bookRepository, DigitalRepository digitalRepository) {
        this.bookRepository = bookRepository;
        this.digitalRepository = digitalRepository;
    }

    public void execute(String code) {
        this.bookRepository.delete(code);
        this.digitalRepository.delete(code);
    }
}
