package com.iesam.library.features.digitalCollection.domain.book.data.local;

import com.iesam.library.features.digitalCollection.domain.book.domain.Book;

public interface BookLocalDataSource {
    void save(Book book);

    Book findByCode(String code);
}
