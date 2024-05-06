package com.iesam.library.features.digitalCollection.domain.book.domain;

public class DeleteBookUseCase {
    public final BookRepository bookRepository;

    public DeleteBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute(String code) {
        this.bookRepository.delete(code);
    }
}
