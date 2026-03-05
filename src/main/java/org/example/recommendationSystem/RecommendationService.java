package org.example.recommendationSystem;

import org.example.model.Book;
import org.example.model.Patron;
import org.example.recommendationSystem.strategy.RecommendationStrategy;

import java.util.List;
import java.util.logging.Logger;

public class RecommendationService {

    private static final Logger logger =
            Logger.getLogger(RecommendationService.class.getName());

    private RecommendationStrategy strategy;


    public RecommendationService(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }


    public List<Book> recommendBooks(Patron patron) {

        logger.info("Generating recommendations for patron: "
                + patron.getId());

        return strategy.recommend(patron);
    }
}