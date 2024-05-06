package com.iesam.library.features.digitalCollection.domain.book.domain;

public class GetBookUseCase {
    public final BookRepository bookRepository;

    public GetBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book execute(String code) {
        return bookRepository.obtain(code);
    }
}
