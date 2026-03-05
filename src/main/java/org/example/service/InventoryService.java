package org.example.service;

import org.example.model.BookItem;

import java.util.HashMap;
import java.util.*;


public class InventoryService {
    private Map<String, List<BookItem>> inventory = new HashMap<>();

    public void addBookCopy(BookItem bookItem) {

        inventory.computeIfAbsent(
                bookItem.getBook().getIsbn(), k -> new ArrayList<>())
                .add(bookItem);
    }

    public List<BookItem> getAvailableCopies(String isbn) {

        return inventory.getOrDefault(isbn, List.of())
                .stream()
                .filter(BookItem::isAvailable)
                .toList();
    }

    public List<BookItem> getAllCopies(String isbn) {
        return inventory.getOrDefault(isbn, List.of());
    }

    public void removeBookCopy(BookItem bookItem) {

        List<BookItem> copies = inventory.get(bookItem.getBook().getIsbn());

        if (copies != null) {
            copies.remove(bookItem);
        }
    }
}
