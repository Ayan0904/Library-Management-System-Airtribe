package org.example.model;

public class Book {

        private String title;
        private String author;
        private String isbn;
        private int publicationYear;

        public Book(BookBuilder builder) {
            this.title = builder.title;
            this.author = builder.author;
            this.isbn = builder.isbn;
            this.publicationYear = builder.publicationYear;
        }

        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getIsbn() { return isbn; }

    public static class BookBuilder {

        private String title;
        private String author;
        private String isbn;
        private int publicationYear;

        public BookBuilder(){

        }

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder publicationYear(int year) {
            this.publicationYear = year;
            return this;
        }

        public Book build() {

            if (isbn == null || isbn.isEmpty()) {
                throw new IllegalArgumentException("ISBN cannot be empty");
            }

            return new Book(this);
        }
    }

}
