package com.iesam.library.features.digitalCollection.domain;

public class GetDigitalResourceUseCase {
    public final DigitalRepository digitalRepository;

    public GetDigitalResourceUseCase(DigitalRepository digitalRepository) {
        this.digitalRepository = digitalRepository;
    }

    public DigitalCollection execute(String digitalResourceCode) {
        return digitalRepository.obtain(digitalResourceCode);
    }
}
