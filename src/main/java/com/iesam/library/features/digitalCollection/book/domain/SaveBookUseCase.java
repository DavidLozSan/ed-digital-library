package com.iesam.library.features.digitalCollection.book.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;
import com.iesam.library.features.digitalCollection.domain.TypeDigitalCollection;

public class SaveBookUseCase {
    public final DigitalRepository digitalRepository;

    public SaveBookUseCase(DigitalRepository digitalRepository) {
        this.digitalRepository = digitalRepository;
    }

    public void execute(Book book) {
        this.digitalRepository.save(new DigitalCollection(book.getCode(), TypeDigitalCollection.BOOK, book.getName()));
    }
}
