package com.iesam;

import com.iesam.library.features.digitalCollection.presentation.BookPresentation;
import com.iesam.library.features.user.presentation.UserPresentation;
import com.iesam.library.features.user.domain.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Boolean bucle = true;
        Scanner sc = new Scanner(System.in);
        while (bucle) {
            System.out.println("\n---------------------------------");
            System.out.println("\nMenú:\n");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Buscar usuario (por su código)");
            System.out.println("3. Mostrar todos los usuarios");
            System.out.println("10. Añadir libro");
            System.out.println("0. Salir");
            System.out.println("\n---------------------------------");
            Integer opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    UserPresentation.save();
                    break;
                case 2:
                    UserPresentation.obtain();
                    break;
                case 3:
                    UserPresentation.obtainUsers();
                    break;
                case 10:
                    BookPresentation.save();
                    break;
                case 0:
                    bucle = false;
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