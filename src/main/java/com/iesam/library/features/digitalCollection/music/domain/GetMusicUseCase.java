package com.iesam.library.features.digitalCollection.music.domain;

public class GetMusicUseCase {
    public final MusicRepository musicRepository;

    public GetMusicUseCase(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public Music execute(String code) {
        return this.musicRepository.obtainMusic(code);
    }
}
