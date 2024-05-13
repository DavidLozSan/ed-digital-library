package com.iesam.library.features.digitalCollection.domain.music.domain;

import com.iesam.library.features.digitalCollection.data.DigitalDataRepository;
import com.iesam.library.features.digitalCollection.domain.DigitalCollection;


public class SaveMusicUseCase {
    public final MusicRepository musicRepository;
    public final DigitalDataRepository digitalDataRepository;

    public SaveMusicUseCase(MusicRepository musicRepository, DigitalDataRepository digitalDataRepository) {
        this.musicRepository = musicRepository;
        this.digitalDataRepository = digitalDataRepository;
    }

    public void execute(Music music) {
        this.musicRepository.saveMusic(music);
        this.digitalDataRepository.save(new DigitalCollection(music.code, music.digitalResourceType, music.name));
    }
}
