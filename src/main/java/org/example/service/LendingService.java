package org.example.service;

import org.example.CustomException.BookNotAvailableException;
import org.example.model.*;

import java.util.logging.Logger;

public class LendingService {

    private static final Logger logger =
            Logger.getLogger(LendingService.class.getName());


    public Loan checkoutBook(BookItem bookItem, Patron patron)
            throws BookNotAvailableException {

        logger.info("Attempting to checkout book: "
                + bookItem.getBook().getTitle());


        if (!bookItem.isAvailable()) {

            logger.severe("Book not available: "
                    + bookItem.getBook().getTitle());

            throw new BookNotAvailableException(
                    "Book is currently not available"
            );
        }

        bookItem.borrow();

        Loan loan = new Loan(bookItem, patron);

        patron.addLoan(loan);

        logger.info("Book successfully checked out by patron: "
                + patron.getId());

        return loan;
    }


    public void returnBook(Loan loan) {

        logger.info("Returning book: "
                + loan.getBookItem().getBook().getTitle());

        loan.getBookItem().returnBook();

        loan.closeLoan();

        logger.info("Book returned successfully");
    }
}