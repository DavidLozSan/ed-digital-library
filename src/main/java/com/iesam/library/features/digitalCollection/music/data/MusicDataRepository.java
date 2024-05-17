package com.iesam.library.features.digitalCollection.music.data;

import com.iesam.library.features.digitalCollection.domain.DigitalRepository;
import com.iesam.library.features.digitalCollection.music.data.local.MusicLocalDataSource;
import com.iesam.library.features.digitalCollection.music.domain.Music;

import java.util.List;

public class MusicDataRepository implements DigitalRepository<Music> {
    public final MusicLocalDataSource musicLocalDataSource;

    public MusicDataRepository(MusicLocalDataSource musicLocalDataSource) {
        this.musicLocalDataSource = musicLocalDataSource;
    }

    @Override
    public void save(Music digitalCollection) {
        musicLocalDataSource.save(digitalCollection);
    }

    @Override
    public Music obtain(String digitalResourceCode) {
        return musicLocalDataSource.findByCode(digitalResourceCode);
    }

    @Override
    public List<Music> obtainDigitalResources() {
        return null;
    }

    @Override
    public void delete(String code) {

    }

    @Override
    public void update(Music digitalCollection) {

    }
}
