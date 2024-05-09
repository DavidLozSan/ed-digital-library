package com.iesam.library.features.digitalCollection.domain.book.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;
import com.iesam.library.features.digitalCollection.domain.TypeDigitalCollection;

public class SaveBookUseCase {
    public final BookRepository bookRepository;
    public final DigitalRepository digitalRepository;

    public SaveBookUseCase(BookRepository bookRepository, DigitalRepository digitalRepository) {
        this.bookRepository = bookRepository;
        this.digitalRepository = digitalRepository;
    }

    public void execute(Book book) {
        this.bookRepository.save(book);
        this.digitalRepository.save(new DigitalCollection(book.getCode(), TypeDigitalCollection.BOOK, book.getName()));
    }
}
