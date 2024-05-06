package com.iesam.library.features.digitalCollection.domain.book.domain;

public class UpdateBookUseCase {
    public final BookRepository bookRepository;

    public UpdateBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute(Book book) {
        this.bookRepository.update(book);
    }
}
