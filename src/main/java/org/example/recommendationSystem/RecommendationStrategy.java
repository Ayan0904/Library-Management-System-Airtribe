package org.example.recommendationSystem;

import org.example.model.Book;
import org.example.model.Patron;

import java.util.List;

public interface RecommendationStrategy {
    List<Book> recommend(Patron patron);
}
