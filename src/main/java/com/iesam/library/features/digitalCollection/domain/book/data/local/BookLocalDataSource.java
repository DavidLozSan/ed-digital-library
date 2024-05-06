package com.iesam.library.features.digitalCollection.domain.book.data.local;

import com.iesam.library.features.digitalCollection.domain.book.domain.Book;

import java.util.List;

public interface BookLocalDataSource {
    void save(Book book);

    Book findByCode(String code);

    List<Book> findAll();
}
