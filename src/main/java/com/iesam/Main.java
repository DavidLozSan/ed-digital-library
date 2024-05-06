package com.iesam;

import com.iesam.library.features.digitalCollection.presentation.DigitalCollectionPresentation;
import com.iesam.library.features.user.presentation.UserPresentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        while (loop) {
            System.out.println("\n---------------------------------");
            System.out.println("\nMenú Principal:\n");
            System.out.println("1. Acceder al menú de usuarios");
            System.out.println("2. Acceder al menú de recursos digitales");
            System.out.println("0. Salir");
            System.out.println("\n---------------------------------");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    UserPresentation.userMenu();
                    break;
                case 2:
                    DigitalCollectionPresentation.digitalCollectionMenu();
                    break;
                case 0:
                    loop = false;
                    sc.close();
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Esa opción no es válida");
                    break;
            }
        }
    }
}