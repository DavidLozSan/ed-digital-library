package com.iesam.library.features.digitalCollection.domain.music.domain;

public interface MusicRepository {
    void saveMusic(Music music);

    Music obtainMusic(String code);
}
