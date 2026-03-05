package org.example.model;

public class BookItem {
    private String barcode;
    private Book book;
    private BookStatus status;

    public BookItem(String barcode, Book book) {
        this.barcode = barcode;
        this.book = book;
        this.status = BookStatus.AVAILABLE;
    }

    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
    }

    public void borrow() {
        status = BookStatus.BORROWED;
    }

    public void returnBook() {
        status = BookStatus.AVAILABLE;
    }

    public Book getBook() {
        return book;
    }
}
