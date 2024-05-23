package com.iesam.library.features.digitalCollection.music.domain;

public class MusicFactory {
    public Music build(String code, String name, String artist, String album, String releaseYear,
                       String genre, String duration) {
        return new Music(code, name, artist, album, releaseYear, genre, duration);
    }
}
