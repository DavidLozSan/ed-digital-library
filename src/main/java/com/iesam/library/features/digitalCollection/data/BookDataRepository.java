package com.iesam.library.features.digitalCollection.data;

import com.iesam.library.features.digitalCollection.data.local.BookFileLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.Book;
import com.iesam.library.features.digitalCollection.domain.BookRepository;

public class BookDataRepository implements BookRepository {
    private BookFileLocalDataSource bookFileLocalDataSource;

    public BookDataRepository(BookFileLocalDataSource bookFileLocalDataSource) {
        this.bookFileLocalDataSource = bookFileLocalDataSource;
    }

    @Override
    public void save(Book book) {
        bookFileLocalDataSource.save(book);
    }
}
