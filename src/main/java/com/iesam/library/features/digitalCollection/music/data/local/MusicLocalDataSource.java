package com.iesam.library.features.digitalCollection.music.data.local;

import com.iesam.library.features.digitalCollection.music.domain.Music;

public interface MusicLocalDataSource {
    void save(Music music);

    Music findByCode(String code);
}
