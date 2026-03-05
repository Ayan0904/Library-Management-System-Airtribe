package org.example.reservationSystem;

import org.example.model.BookItem;
import org.example.model.Patron;

import java.util.logging.Logger;

public class ReservationService {

    private static final Logger logger =
            Logger.getLogger(ReservationService.class.getName());

    private BookAvailabilityNotifier notifier =
            new BookAvailabilityNotifier();


    public void reserveBook(Patron patron) {

        logger.info("Patron reserving book: "
                + patron.getId());

        Reservation reservation = new Reservation(patron);

        notifier.addObserver(reservation);
    }


    public void bookReturned(BookItem bookItem) {

        logger.info("Book returned. Notifying reserved patrons.");

        notifier.notifyObservers(bookItem);
    }
}