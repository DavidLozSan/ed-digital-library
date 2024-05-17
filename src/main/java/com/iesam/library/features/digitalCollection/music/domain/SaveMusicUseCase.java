package com.iesam.library.features.digitalCollection.music.domain;

import com.iesam.library.features.digitalCollection.data.DigitalDataRepository;
import com.iesam.library.features.digitalCollection.domain.DigitalCollection;


public class SaveMusicUseCase {
    public final DigitalDataRepository digitalDataRepository;

    public SaveMusicUseCase(DigitalDataRepository digitalDataRepository) {
        this.digitalDataRepository = digitalDataRepository;
    }

    public void execute(Music music) {
        this.digitalDataRepository.save(music);
    }
}
