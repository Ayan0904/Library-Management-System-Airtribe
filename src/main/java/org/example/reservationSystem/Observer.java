package org.example.reservationSystem;

import org.example.model.BookItem;

public interface Observer {
    void update(BookItem bookItem);
}
