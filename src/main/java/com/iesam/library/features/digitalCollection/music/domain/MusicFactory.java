package com.iesam.library.features.digitalCollection.music.domain;

public class MusicFactory {
    public Music build(String code, String name, String artist, String album, String releaseYear,
                       String genre, String duration) {
        Music music = new Music(code, name, artist, album, releaseYear, genre, duration);
        return music;
    }
}
