package com.iesam.library.features.digitalCollection.presentation;

import com.iesam.library.features.digitalCollection.data.BookDataRepository;
import com.iesam.library.features.digitalCollection.data.local.BookFileLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.Book;
import com.iesam.library.features.digitalCollection.domain.SaveBookUseCase;

import java.util.Scanner;

public class BookPresentation {
    public static void save() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el codigo del libro");
        String codigo = sc.nextLine();
        System.out.println("Dame el título del libro");
        String nombre = sc.nextLine();
        System.out.println("Dame el autor del libro");
        String autor = sc.nextLine();
        System.out.println("Dame el editorial del libro");
        String editorial = sc.nextLine();
        System.out.println("Dame el año de publicación del libro");
        String anioPublicacion = sc.nextLine();
        System.out.println("Dame el numero de edición (si aplica) del libro");
        String numeroEdicion = sc.nextLine();
        System.out.println("Dame el ISBN del libro");
        String iSBN = sc.nextLine();
        System.out.println("Dame el genero principal del libro");
        String genero = sc.nextLine();
        SaveBookUseCase saveBookUseCase = new SaveBookUseCase(new BookDataRepository(new BookFileLocalDataSource()));
        saveBookUseCase.execute(new Book(
                codigo, "Libro digital", nombre, autor, editorial,
                anioPublicacion, numeroEdicion, iSBN, genero));
    }
}
