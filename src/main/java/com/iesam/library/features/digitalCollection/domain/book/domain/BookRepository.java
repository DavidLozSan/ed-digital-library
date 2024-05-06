package com.iesam.library.features.digitalCollection.domain.book.domain;

import java.util.List;

public interface BookRepository {
    void save(Book book);

    Book obtain(String code);

    List<Book> obtainBooks();
}
