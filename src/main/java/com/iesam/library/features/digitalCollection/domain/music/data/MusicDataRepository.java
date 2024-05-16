package com.iesam.library.features.digitalCollection.domain.music.data;

import com.iesam.library.features.digitalCollection.domain.music.data.local.MusicLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.music.domain.Music;
import com.iesam.library.features.digitalCollection.domain.music.domain.MusicRepository;

public class MusicDataRepository implements MusicRepository {
    public final MusicLocalDataSource musicLocalDataSource;

    public MusicDataRepository(MusicLocalDataSource musicLocalDataSource) {
        this.musicLocalDataSource = musicLocalDataSource;
    }

    @Override
    public void saveMusic(Music music) {
        musicLocalDataSource.save(music);
    }

    @Override
    public Music obtainMusic(String code) {
        return musicLocalDataSource.findByCode(code);
    }
}
