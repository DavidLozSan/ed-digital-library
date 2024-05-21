package com.iesam.library.features.digitalCollection.domain.music.data.local;

import com.iesam.library.features.digitalCollection.domain.music.domain.Music;

public interface MusicLocalDataSource {
    void save(Music music);
}
