package org.example;
import org.example.CustomException.BookNotAvailableException;
import org.example.config.LoggerConfig;
import org.example.model.Book;
import org.example.model.BookItem;
import org.example.model.Loan;
import org.example.model.Patron;
import org.example.multiBranchSystem.BranchService;
import org.example.multiBranchSystem.LibraryBranch;
import org.example.recommendationSystem.strategy.HistoryBasedRecommendation;
import org.example.recommendationSystem.RecommendationService;
import org.example.recommendationSystem.strategy.RecommendationStrategy;
import org.example.reservationSystem.ReservationService;
import org.example.service.LendingService;

import java.util.List;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger =
            Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        LoggerConfig.setupLogger();

        logger.info("===== Library Management System Demo =====");

        /*
         * STEP 1 — Create Books using Builder Pattern
         */

        Book book1 = new Book.BookBuilder()
                .title("History of Westeros")
                .author("George R. Martin")
                .isbn("ISBN001")
                .publicationYear(2008)
                .build();

        Book book2 = new Book.BookBuilder()
                .title("Harry Potter")
                .author("J. K. Rowlings")
                .isbn("ISBN002")
                .publicationYear(1994)
                .build();


        /*
         * STEP 2 — Create Book Copies
         */

        BookItem item1 = new BookItem("BC101", book1);
        BookItem item2 = new BookItem("BC102", book1);
        BookItem item3 = new BookItem("BC201", book2);


        /*
         * STEP 3 — Setup Branches
         */

        LibraryBranch branchA = new LibraryBranch("Central Library");
        LibraryBranch branchB = new LibraryBranch("City Library");


        /*
         * STEP 4 — Add Books to Inventory
         */

        branchA.getInventoryService().addBookCopy(item1);
        branchA.getInventoryService().addBookCopy(item2);
        branchA.getInventoryService().addBookCopy(item3);


        /*
         * STEP 5 — Register Patron
         */

        Patron patron = new Patron("P1", "Ayan");


        /*
         * STEP 6 — Checkout Book
         */

        LendingService lendingService = new LendingService();

        try {

            Loan loan = lendingService.checkoutBook(item1, patron);

            /*
             * STEP 7 — Return Book
             */

            lendingService.returnBook(loan);

            logger.info("Book returned: " + item1.getBook().getTitle());


        } catch (BookNotAvailableException e) {

            logger.severe("Checkout failed: " + e.getMessage());

        }

        logger.info("Book borrowed: " + item1.getBook().getTitle());




        /*
         * STEP 8 — Borrowing History
         */

        logger.info("Borrowing History:");

        patron.getBorrowingHistory()
                .forEach(l ->
                        logger.info(
                                l.getBookItem()
                                        .getBook()
                                        .getTitle()
                        )
                );


        /*
         * STEP 9 — Transfer Book Between Branches
         */

        BranchService branchService = new BranchService();

        branchService.transferBook(
                item3,
                branchA,
                branchB
        );

        logger.info("Book transferred to branch: "
                + branchB.getName());


        /*
         * STEP 10 — Reservation System (Observer Pattern)
         */

        ReservationService reservationService =
                new ReservationService();

        reservationService.reserveBook(patron);

        reservationService.bookReturned(item1);


        /*
         * STEP 11 — Recommendation System (Strategy Pattern)
         */

        RecommendationStrategy strategy =
                new HistoryBasedRecommendation();

        RecommendationService recommendationService =
                new RecommendationService(strategy);

        List<Book> recommendations =
                recommendationService.recommendBooks(patron);

        logger.info("Recommended Books:");

        recommendations.forEach(
                b -> logger.info(b.getTitle())
        );

        logger.info("===== Demo Completed =====");
    }
}