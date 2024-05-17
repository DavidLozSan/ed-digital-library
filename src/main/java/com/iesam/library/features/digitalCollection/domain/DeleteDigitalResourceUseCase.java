package com.iesam.library.features.digitalCollection.domain;

import com.iesam.library.features.digitalCollection.book.domain.Book;

public class DeleteDigitalResourceUseCase {
    public final DigitalRepository digitalRepository;

    public DeleteDigitalResourceUseCase(DigitalRepository digitalRepository) {
        this.digitalRepository = digitalRepository;
    }

    public void execute(String code) {
        this.digitalRepository.delete(code);
    }
}
