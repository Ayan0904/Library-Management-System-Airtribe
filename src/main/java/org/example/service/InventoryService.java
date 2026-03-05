package org.example.service;

import org.example.model.BookItem;

import java.util.*;
import java.util.logging.Logger;

public class InventoryService {

    private static final Logger logger =
            Logger.getLogger(InventoryService.class.getName());

    private Map<String, List<BookItem>> inventory = new HashMap<>();


    public void addBookCopy(BookItem bookItem) {

        logger.info("Adding book copy to inventory: "
                + bookItem.getBook().getTitle());

        inventory
                .computeIfAbsent(bookItem.getBook().getIsbn(),
                        k -> new ArrayList<>())
                .add(bookItem);
    }


    public void removeBookCopy(BookItem bookItem) {

        logger.info("Removing book copy from inventory: "
                + bookItem.getBook().getTitle());

        List<BookItem> copies = inventory.get(bookItem.getBook().getIsbn());

        if (copies != null) {
            copies.remove(bookItem);
        }
    }


    public List<BookItem> getAvailableCopies(String isbn) {

        logger.info("Fetching available copies for ISBN: " + isbn);

        return inventory.getOrDefault(isbn, List.of())
                .stream()
                .filter(BookItem::isAvailable)
                .toList();
    }
}