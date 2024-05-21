package com.iesam.library.features.digitalCollection.domain.music.domain;

import com.iesam.library.features.digitalCollection.data.DigitalDataRepository;
import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;


public class SaveMusicUseCase {
    public final MusicRepository musicRepository;
    public final DigitalRepository digitalRepository;

    public SaveMusicUseCase(MusicRepository musicRepository, DigitalRepository digitalRepository) {
        this.musicRepository = musicRepository;
        this.digitalRepository = digitalRepository;
    }

    public void execute(Music music) {
        this.musicRepository.saveMusic(music);
        this.digitalRepository.save(new DigitalCollection(music.code, music.digitalResourceType, music.name));
    }
}
