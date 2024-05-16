package com.iesam.library.features.digitalCollection.domain.book;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;

public class UpdateDigitalResourceUseCase {
    public final DigitalRepository digitalRepository;

    public UpdateDigitalResourceUseCase(DigitalRepository digitalRepository) {
        this.digitalRepository = digitalRepository;
    }

    public void execute(DigitalCollection digitalCollection) {
        this.digitalRepository.update(digitalCollection);
    }
}
