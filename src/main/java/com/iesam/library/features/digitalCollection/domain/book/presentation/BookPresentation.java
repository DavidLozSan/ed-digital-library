package com.iesam.library.features.digitalCollection.domain.book.presentation;

import com.iesam.library.features.digitalCollection.domain.book.data.BookDataRepository;
import com.iesam.library.features.digitalCollection.domain.book.data.local.BookFileLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.book.domain.*;

import java.util.List;
import java.util.Scanner;

public class BookPresentation {
    public static void bookMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---------------------------------");
        System.out.println("\nMenú libros:\n");
        System.out.println("1. Añadir libro");
        System.out.println("2. Buscar libro");
        System.out.println("3. Mostrar todos los libros");
        System.out.println("4. Dar de baja un libro");
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
                obtainBooks();
                break;
            case 4:
                delete();
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
        System.out.println("Dame el código del libro");
        String code = sc.nextLine();
        System.out.println("Dame el título del libro");
        String name = sc.nextLine();
        System.out.println("Dame el autor del libro");
        String author = sc.nextLine();
        System.out.println("Dame el editorial del libro");
        String editorial = sc.nextLine();
        System.out.println("Dame el año de publicación del libro");
        String yearOfPublication = sc.nextLine();
        System.out.println("Dame el numero de edición (si aplica) del libro");
        String editionNumber = sc.nextLine();
        System.out.println("Dame el ISBN del libro");
        String iSBN = sc.nextLine();
        System.out.println("Dame el genero principal del libro");
        String genre = sc.nextLine();
        BookDataRepository bookDataRepository = new BookDataRepository(new BookFileLocalDataSource());
        SaveBookUseCase saveBookUseCase = new SaveBookUseCase(bookDataRepository);
        saveBookUseCase.execute(new Book(
                code, "Libro digital", name, author, editorial,
                yearOfPublication, editionNumber, iSBN, genre));
    }

    public static void obtain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código del libro");
        String code = sc.nextLine();
        BookDataRepository bookDataRepository = new BookDataRepository(new BookFileLocalDataSource());
        GetBookUseCase getBookUseCase = new GetBookUseCase(bookDataRepository);
        Book book = getBookUseCase.execute(code);
        System.out.println(book);
    }

    public static void obtainBooks() {
        BookDataRepository bookDataRepository = new BookDataRepository(new BookFileLocalDataSource());
        GetBooksUseCase getBooksUseCase = new GetBooksUseCase(bookDataRepository);
        List<Book> books = getBooksUseCase.execute();
        System.out.println(books);
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código del libro");
        String code = sc.nextLine();
        BookDataRepository bookDataRepository = new BookDataRepository(new BookFileLocalDataSource());
        DeleteBookUseCase deleteBookUseCase = new DeleteBookUseCase(bookDataRepository);
        deleteBookUseCase.execute(code);
    }
}
