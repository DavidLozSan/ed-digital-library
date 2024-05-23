package com.iesam.library.features.digitalCollection.music.presentation;

import com.iesam.library.features.digitalCollection.domain.*;
import com.iesam.library.features.digitalCollection.music.data.MusicDataRepository;
import com.iesam.library.features.digitalCollection.music.data.local.MusicFileLocalDataSource;
import com.iesam.library.features.digitalCollection.music.domain.*;

import java.util.List;
import java.util.Scanner;

public class MusicPresentation {

    public static void musicMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---------------------------------");
        System.out.println("\nMenú música:\n");
        System.out.println("1. Añadir música");
        System.out.println("2. Mostrar la informacion de una música");
        System.out.println("3. Mostrar todos las músicas");
        System.out.println("4. Dar de baja una música");
        System.out.println("5. Modificar la información de una música");
        System.out.println("0. Salir");
        System.out.println("\n---------------------------------");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                save();
                break;
            case 2:
                obtain();
                break;
            case 3:
                obtainMusics();
                break;
            case 4:
                delete();
                break;
            case 5:
                update();
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Esa opción no es válida");
                break;
        }
    }

    public static void save() {
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
        MusicFactory musicFactory = new MusicFactory();
        DigitalRepository<Music> musicDataRepository = new MusicDataRepository(new MusicFileLocalDataSource());
        SaveDigitalResourceUseCase saveDigitalResourceUseCase = new SaveDigitalResourceUseCase(musicDataRepository);
        saveDigitalResourceUseCase.execute(musicFactory.build(code, name, artist, album, releaseYear, genre, duration));
    }

    public static void obtain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código de la música a mostrar");
        String code = sc.nextLine();
        DigitalRepository digitalDataRepository = new MusicDataRepository(new MusicFileLocalDataSource());
        GetDigitalResourceUseCase getMusicUseCase = new GetDigitalResourceUseCase(digitalDataRepository);
        Music music = (Music) getMusicUseCase.execute(code);
        System.out.println(music);
    }

    public static void obtainMusics() {
        DigitalRepository digitalDataRepository = new MusicDataRepository(new MusicFileLocalDataSource());
        GetDigitalResourcesUseCase getMusicsUseCase = new GetDigitalResourcesUseCase(digitalDataRepository);
        List<Music> musics = (List<Music>) (List<?>) getMusicsUseCase.execute();
        System.out.println(musics);
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código de la música");
        String code = sc.nextLine();
        DigitalRepository digitalDataRepository = new MusicDataRepository(new MusicFileLocalDataSource());
        DeleteDigitalResourceUseCase deleteMusicUseCase = new DeleteDigitalResourceUseCase(digitalDataRepository);
        deleteMusicUseCase.execute(code);
    }

    public static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código de la música a modificar");
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
        MusicFactory musicFactory = new MusicFactory();
        DigitalRepository digitalRepository = new MusicDataRepository(new MusicFileLocalDataSource());
        UpdateDigitalResourceUseCase updateMusicUseCase = new UpdateDigitalResourceUseCase(digitalRepository);
        updateMusicUseCase.execute(musicFactory.build(code, name, artist, album, releaseYear, genre, duration));
    }
}
