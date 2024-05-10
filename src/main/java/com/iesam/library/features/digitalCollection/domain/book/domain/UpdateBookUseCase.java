package com.iesam.library.features.digitalCollection.domain.book.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;

public class UpdateBookUseCase {
    public final BookRepository bookRepository;
    public final DigitalRepository digitalRepository;

    public UpdateBookUseCase(BookRepository bookRepository, DigitalRepository digitalRepository) {
        this.bookRepository = bookRepository;
        this.digitalRepository = digitalRepository;
    }

    public void execute(Book book) {
        this.bookRepository.update(book);
        this.digitalRepository.update(new DigitalCollection(book.code, book.digitalResourceType, book.name));
    }
}
