package com.iesam.library.features.digitalCollection.domain;

public class SaveBookUseCase {
    public final BookRepository bookRepository;

    public SaveBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute(Book book) {
        this.bookRepository.save(book);
    }
}
