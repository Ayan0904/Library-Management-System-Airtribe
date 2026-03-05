package org.example.recommendationSystem;

import org.example.model.Book;
import org.example.model.Patron;

import java.util.List;

public class RecommendationService {
    private RecommendationStrategy strategy;

    public RecommendationService(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Book> recommendBooks(Patron patron) {
        return strategy.recommend(patron);
    }

    public void setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }
}
