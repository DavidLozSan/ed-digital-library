package com.iesam.library.features.digitalCollection.music.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.TypeDigitalCollection;

public class Music extends DigitalCollection {
    public final String artist;
    public final String album;
    public final String releaseYear;
    public final String genre;
    public final String duration;

    public Music(String code, String name, String artist, String album, String releaseYear,
                 String genre, String duration) {
        super(code, TypeDigitalCollection.MUSIC, name);
        this.artist = artist;
        this.album = album;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Music{" +
                "code='" + code + '\'' +
                ", digitalResourceType=" + digitalResourceType +
                ", name='" + name + '\'' +
                "artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
