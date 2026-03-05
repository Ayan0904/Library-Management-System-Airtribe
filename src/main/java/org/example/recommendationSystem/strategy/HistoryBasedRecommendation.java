package org.example.recommendationSystem.strategy;

import org.example.model.Book;
import org.example.model.Patron;

import java.util.List;

public class HistoryBasedRecommendation implements RecommendationStrategy{
    @Override
    public List<Book> recommend(Patron patron) {

        return patron.getBorrowingHistory()
                .stream()
                .map(loan -> loan.getBookItem().getBook())
                .toList();
    }
}
