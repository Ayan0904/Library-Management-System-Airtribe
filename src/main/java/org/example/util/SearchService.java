package org.example.util;

import org.example.model.Book;

import java.util.Collection;
import java.util.List;

public class SearchService {
    public List<Book> searchByTitle(Collection<Book> books, String title) {

        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .toList();
    }

    public List<Book> searchByAuthor(Collection<Book> books, String author) {

        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .toList();
    }

    public Book searchByIsbn(Collection<Book> books, String isbn) {

        return books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
}
