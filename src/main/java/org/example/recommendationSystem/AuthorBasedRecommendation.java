package org.example.recommendationSystem;

import org.example.model.Book;
import org.example.model.Patron;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorBasedRecommendation implements RecommendationStrategy{
    private List<Book> libraryBooks;

    public AuthorBasedRecommendation(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    @Override
    public List<Book> recommend(Patron patron) {

        List<String> authors = patron.getBorrowingHistory()
                .stream()
                .map(loan -> loan.getBookItem().getBook().getAuthor())
                .toList();

        return libraryBooks.stream()
                .filter(book -> authors.contains(book.getAuthor()))
                .collect(Collectors.toList());
    }
}
