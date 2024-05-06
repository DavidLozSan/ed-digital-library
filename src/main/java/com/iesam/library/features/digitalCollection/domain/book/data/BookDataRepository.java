package com.iesam.library.features.digitalCollection.domain.book.data;

import com.iesam.library.features.digitalCollection.domain.book.data.local.BookLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.book.domain.Book;
import com.iesam.library.features.digitalCollection.domain.book.domain.BookRepository;

import java.util.List;

public class BookDataRepository implements BookRepository {
    private final BookLocalDataSource bookLocalDataSource;

    public BookDataRepository(BookLocalDataSource bookLocalDataSource) {
        this.bookLocalDataSource = bookLocalDataSource;
    }

    @Override
    public void save(Book book) {
        bookLocalDataSource.save(book);
    }

    @Override
    public Book obtain(String code) {
        return bookLocalDataSource.findByCode(code);
    }

    @Override
    public List<Book> obtainBooks() {
        return bookLocalDataSource.findAll();
    }

    @Override
    public void delete(String code) {
        bookLocalDataSource.delete(code);
    }
}
