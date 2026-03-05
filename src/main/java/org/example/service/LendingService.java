package org.example.service;

import org.example.model.BookItem;
import org.example.model.Loan;
import org.example.model.Patron;

public class LendingService {
    public Loan checkoutBook(BookItem bookItem, Patron patron) {

        if (!bookItem.isAvailable()) {
            throw new RuntimeException("Book not available");
        }

        bookItem.borrow();

        Loan loan = new Loan(bookItem, patron);

        patron.addLoan(loan);

        return loan;
    }

    public void returnBook(Loan loan) {

        loan.getBookItem().returnBook();

        loan.closeLoan();
    }
}
