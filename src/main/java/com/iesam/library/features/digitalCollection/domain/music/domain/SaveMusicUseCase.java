package com.iesam.library.features.digitalCollection.domain.music.domain;

import com.iesam.library.features.digitalCollection.data.DigitalDataRepository;

import java.util.Scanner;

public class SaveMusicUseCase {
    public final MusicRepository musicRepository;
    public final DigitalDataRepository digitalDataRepository;

    public SaveMusicUseCase(MusicRepository musicRepository, DigitalDataRepository digitalDataRepository) {
        this.musicRepository = musicRepository;
        this.digitalDataRepository = digitalDataRepository;
    }

    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código de la música");
        String code = sc.nextLine();
        System.out.println("Dame el nombre de la música");
        String name = sc.nextLine();
        System.out.println("Dame el artista de la música");
        String artist = sc.nextLine();
        System.out.println("Dame el album de la música");
        String album = sc.nextLine();
        System.out.println("Dame el año de publicación de la música");
        String releaseYear = sc.nextLine();
        System.out.println("Dame el género principal de la música");
        String genre = sc.nextLine();
        System.out.println("Dame el tiempo de duracion de la música");
        String duration = sc.nextLine();
        Music music = new Music(code, name, artist, album, releaseYear, genre, duration);
        this.musicRepository.saveMusic(music);
        this.digitalDataRepository.save(music);
    }
}
