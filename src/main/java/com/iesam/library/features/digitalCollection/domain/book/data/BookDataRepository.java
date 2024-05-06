package com.iesam.library.features.digitalCollection.domain.book.data;

import com.iesam.library.features.digitalCollection.domain.book.data.local.BookLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.book.domain.Book;
import com.iesam.library.features.digitalCollection.domain.book.domain.BookRepository;

public class BookDataRepository implements BookRepository {
    private final BookLocalDataSource bookLocalDataSource;

    public BookDataRepository(BookLocalDataSource bookLocalDataSource) {
        this.bookLocalDataSource = bookLocalDataSource;
    }

    @Override
    public void save(Book book) {
        bookLocalDataSource.save(book);
    }
}
