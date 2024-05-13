package com.iesam.library.features.digitalCollection.domain.music.presentation;

import com.iesam.library.features.digitalCollection.data.DigitalDataRepository;
import com.iesam.library.features.digitalCollection.data.local.DigitalFileLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.music.data.MusicDataRepository;
import com.iesam.library.features.digitalCollection.domain.music.data.local.MusicFileLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.music.domain.SaveMusicUseCase;

import java.util.Scanner;

public class MusicPresentation {

    public static void musicMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---------------------------------");
        System.out.println("\nMenú música:\n");
        System.out.println("1. Añadir música");
        System.out.println("0. Salir");
        System.out.println("\n---------------------------------");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                save();
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
        MusicDataRepository musicDataRepository = new MusicDataRepository(new MusicFileLocalDataSource());
        DigitalDataRepository digitalDataRepository = new DigitalDataRepository(new DigitalFileLocalDataSource());
        SaveMusicUseCase saveMusicUseCase = new SaveMusicUseCase(musicDataRepository, digitalDataRepository);
        saveMusicUseCase.execute();
    }
}
