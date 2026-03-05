package org.example.reservationSystem;

import org.example.model.BookItem;

import java.util.ArrayList;
import java.util.List;

public class BookAvailabilityNotifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(BookItem bookItem) {

        for (Observer observer : observers) {
            observer.update(bookItem);
        }

        observers.clear();
    }
}
