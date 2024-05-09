package com.iesam.library.features.digitalCollection.domain.book.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.TypeDigitalCollection;

public class Book extends DigitalCollection {
    public final String author;
    public final String editorial;
    public final String yearOfPublication;
    public final String editionNumber;
    public final String iSBN;
    public final String genre;

    public Book(String code, String name, String author, String editorial, String yearOfPublication, String editionNumber, String iSBN, String genre) {
        super(code, TypeDigitalCollection.BOOK, name);
        this.author = author;
        this.editorial = editorial;
        this.yearOfPublication = yearOfPublication;
        this.editionNumber = editionNumber;
        this.iSBN = iSBN;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "code='" + code + '\'' +
                ", digitalResourceType='" + digitalResourceType + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", editorial='" + editorial + '\'' +
                ", yearOfPublication='" + yearOfPublication + '\'' +
                ", editionNumber='" + editionNumber + '\'' +
                ", iSBN='" + iSBN + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public String getEditionNumber() {
        return editionNumber;
    }

    public String getiSBN() {
        return iSBN;
    }

    public String getGenre() {
        return genre;
    }
}
