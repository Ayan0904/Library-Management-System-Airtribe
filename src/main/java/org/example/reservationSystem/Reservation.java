package org.example.reservationSystem;

import org.example.model.BookItem;
import org.example.model.Patron;
import java.util.logging.Logger;

public class Reservation implements Observer{

    private static final Logger LOGGER = Logger.getLogger(Reservation.class.getName());

    private Patron patron;

    public Reservation(Patron patron) {
        this.patron = patron;
    }

    @Override
    public void update(BookItem bookItem) {

        LOGGER.info(
                "Notification sent to " + patron.getId() +
                        " : Book available -> " +
                        bookItem.getBook().getTitle()
        );
    }

    public Patron getPatron() {
        return patron;
    }
}
