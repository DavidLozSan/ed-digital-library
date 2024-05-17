package com.iesam.library.features.digitalCollection.presentation;

import com.iesam.library.features.digitalCollection.book.presentation.BookPresentation;
import com.iesam.library.features.digitalCollection.music.presentation.MusicPresentation;

import java.util.Scanner;

public class DigitalCollectionPresentation {
    public static void digitalCollectionMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---------------------------------");
        System.out.println("\nMenú recursos digitales:\n");
        System.out.println("1. Entrar al apartado de libros");
        System.out.println("2. Entrar al apartado de música");
        System.out.println("0. Salir");
        System.out.println("\n---------------------------------");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                BookPresentation.bookMenu();
                break;
            case 2:
                MusicPresentation.musicMenu();
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
        }
    }
}
