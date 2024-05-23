package com.iesam.library.features.digitalCollection.domain;

public class DeleteDigitalResourceUseCase {
    public final DigitalRepository digitalRepository;

    public DeleteDigitalResourceUseCase(DigitalRepository digitalRepository) {
        this.digitalRepository = digitalRepository;
    }

    public void execute(String code) {
        this.digitalRepository.delete(code);
    }
}
