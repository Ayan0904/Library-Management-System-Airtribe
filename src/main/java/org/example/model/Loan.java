package org.example.model;

import java.time.LocalDate;

public class Loan {

        private BookItem bookItem;
        private Patron patron;

        private LocalDate checkoutDate;
        private LocalDate returnDate;

        public Loan(BookItem bookItem, Patron patron) {
            this.bookItem = bookItem;
            this.patron = patron;
            this.checkoutDate = LocalDate.now();
        }

        public void closeLoan() {
            this.returnDate = LocalDate.now();
        }

        public BookItem getBookItem() {
            return bookItem;
        }

}
