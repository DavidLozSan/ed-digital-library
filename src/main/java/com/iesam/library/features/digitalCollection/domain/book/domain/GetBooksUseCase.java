package com.iesam.library.features.digitalCollection.domain.book.domain;

import java.util.List;

public class GetBooksUseCase {
    public final BookRepository bookRepository;

    public GetBooksUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> execute() {
        return this.bookRepository.obtainBooks();
    }
}
