package com.iesam.library.features.digitalCollection.book.domain;

public class BookFactory {
    public Book build(String code, String name, String author, String editorial, String yearOfPublication,
                      String editionNumber, String iSBN, String genre) {
        Book book = new Book(code, name, author, editorial, yearOfPublication, editionNumber, iSBN, genre);
        return book;
    }
}
