package com.iesam.library.features.digitalCollection.music.data.local;

import com.iesam.library.features.digitalCollection.music.domain.Music;

import java.util.List;

public interface MusicLocalDataSource {
    void save(Music music);

    Music findByCode(String code);

    List<Music> findAll();

    void delete(String code);

    void update(Music music);
}
