package com.iesam.library.features.digitalCollection.domain;

import java.util.List;

public class GetDigitalResourcesUseCase {
    public final DigitalRepository digitalRepository;

    public GetDigitalResourcesUseCase(DigitalRepository digitalRepository) {
        this.digitalRepository = digitalRepository;
    }

    public List<DigitalCollection> execute() {
        return digitalRepository.obtainDigitalResources();
    }
}
