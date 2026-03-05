package org.example.model;

import java.util.*;

public class Patron {
    private String id;
    private String name;

    private List<Loan> borrowingHistory = new ArrayList<>();

    public Patron(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addLoan(Loan loan) {
        borrowingHistory.add(loan);
    }

    public List<Loan> getBorrowingHistory() {
        return borrowingHistory;
    }

    public String getId() {
        return id;
    }
}
