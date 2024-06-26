package com.iesam.library.features.digitalCollection.book.data.local;

import com.iesam.library.features.digitalCollection.book.domain.Book;

import java.util.List;

public interface BookLocalDataSource {
    void save(Book book);

    Book findByCode(String code);

    List<Book> findAll();

    void delete(String code);

    void update(Book book);
}
