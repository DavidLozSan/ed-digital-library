package com.iesam.library.features.digitalCollection.domain;

public class SaveDigitalResourceUseCase {
    public final DigitalRepository digitalRepository;

    public SaveDigitalResourceUseCase(DigitalRepository digitalRepository) {
        this.digitalRepository = digitalRepository;
    }

    public void execute(DigitalCollection digitalCollection) {
        this.digitalRepository.save(digitalCollection);
    }
}
