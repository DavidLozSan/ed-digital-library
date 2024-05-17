package com.iesam.library.features.digitalCollection.book.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;

public class UpdateBookUseCase {
    public final DigitalRepository digitalRepository;

    public UpdateBookUseCase(DigitalRepository digitalRepository) {
        this.digitalRepository = digitalRepository;
    }

    public void execute(Book book) {
        this.digitalRepository.update(book);
    }
}
