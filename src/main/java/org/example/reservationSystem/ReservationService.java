package org.example.reservationSystem;

import org.example.model.BookItem;
import org.example.model.Patron;

public class ReservationService {
    private BookAvailabilityNotifier notifier =
            new BookAvailabilityNotifier();

    public void reserveBook(Patron patron) {

        Reservation reservation = new Reservation(patron);

        notifier.addObserver(reservation);
    }

    public void bookReturned(BookItem bookItem) {

        notifier.notifyObservers(bookItem);
    }
}
