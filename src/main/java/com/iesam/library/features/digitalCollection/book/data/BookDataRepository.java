package com.iesam.library.features.digitalCollection.book.data;

import com.iesam.library.features.digitalCollection.book.data.local.BookLocalDataSource;
import com.iesam.library.features.digitalCollection.book.domain.Book;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;

import java.util.List;

public class BookDataRepository implements DigitalRepository<Book> {
    private final BookLocalDataSource bookLocalDataSource;

    public BookDataRepository(BookLocalDataSource bookLocalDataSource) {
        this.bookLocalDataSource = bookLocalDataSource;
    }

    @Override
    public void save(Book digitalCollection) {
        bookLocalDataSource.save(digitalCollection);
    }

    @Override
    public Book obtain(String digitalResourceCode) {
        return bookLocalDataSource.findByCode(digitalResourceCode);
    }

    @Override
    public List<Book> obtainDigitalResources() {
        return bookLocalDataSource.findAll();
    }

    @Override
    public void delete(String code) {
        bookLocalDataSource.delete(code);
    }

    @Override
    public void update(Book digitalCollection) {
        bookLocalDataSource.update(digitalCollection);
    }
}
