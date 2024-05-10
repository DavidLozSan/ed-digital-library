package com.iesam.library.features.digitalCollection.presentation;

import com.iesam.library.features.digitalCollection.data.DigitalDataRepository;
import com.iesam.library.features.digitalCollection.data.local.DigitalFileLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.*;
import com.iesam.library.features.digitalCollection.domain.book.presentation.BookPresentation;

import java.util.List;
import java.util.Scanner;

public class DigitalCollectionPresentation {
    public static void digitalCollectionMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---------------------------------");
        System.out.println("\nMenú recursos digitales:\n");
        System.out.println("1. Entrar al apartado de libros");
        System.out.println("0. Salir");
        System.out.println("\n---------------------------------");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                BookPresentation.bookMenu();
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
        }
    }

    public static void save() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código del recurso digital");
        String code = sc.nextLine();
        System.out.println("Dame el tipo de recurso digital:");
        System.out.println("1.BOOK  2.MUSIC 3.VIDEO");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println("Dame el título del recurso digital");
        String name = sc.nextLine();
        DigitalDataRepository digitalDataRepository = new DigitalDataRepository(new DigitalFileLocalDataSource());
        SaveDigitalResourceUseCase saveDigitalResourceUseCase = new SaveDigitalResourceUseCase(
                digitalDataRepository);
        switch (option) {
            case 1:
                DigitalCollection digitalCollection1 = new DigitalCollection(code, TypeDigitalCollection.BOOK, name);
                saveDigitalResourceUseCase.execute(digitalCollection1);
                break;
            case 2:
                DigitalCollection digitalCollection2 = new DigitalCollection(code, TypeDigitalCollection.MUSIC, name);
                saveDigitalResourceUseCase.execute(digitalCollection2);
                break;
            case 3:
                DigitalCollection digitalCollection3 = new DigitalCollection(code, TypeDigitalCollection.VIDEO, name);
                saveDigitalResourceUseCase.execute(digitalCollection3);
                break;
            default:
                System.out.println("No se a proporcionado una opción válida en el tipo de recurso");
                break;
        }
    }

    public static void obtain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código del recurso digital");
        String code = sc.nextLine();
        DigitalDataRepository digitalDataRepository = new DigitalDataRepository(new DigitalFileLocalDataSource());
        GetDigitalResourceUseCase getDigitalResourceUseCase = new GetDigitalResourceUseCase(
                digitalDataRepository);
        DigitalCollection digitalCollection = getDigitalResourceUseCase.execute(code);
        System.out.println(digitalCollection);
    }

    public static void obtainDigitalResources() {
        DigitalDataRepository digitalDataRepository = new DigitalDataRepository(new DigitalFileLocalDataSource());
        GetDigitalResourcesUseCase getDigitalResourcesUseCase = new GetDigitalResourcesUseCase(digitalDataRepository);
        List<DigitalCollection> listDigitalCollection = getDigitalResourcesUseCase.execute();
        System.out.println(listDigitalCollection);
    }
}
