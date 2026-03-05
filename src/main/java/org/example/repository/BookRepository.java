package org.example.repository;

import org.example.model.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    private Map<String, Book> booksByIsbn = new HashMap<>();

    public void addBook(Book book) {
        booksByIsbn.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        booksByIsbn.remove(isbn);
    }

    public Book getBook(String isbn) {
        return booksByIsbn.get(isbn);
    }

    public Collection<Book> getAllBooks() {
        return booksByIsbn.values();
    }
}
