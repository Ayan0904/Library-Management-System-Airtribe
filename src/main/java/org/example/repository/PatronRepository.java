package org.example.repository;

import org.example.model.Patron;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PatronRepository {
    private Map<String, Patron> patrons = new HashMap<>();

    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public Patron getPatron(String id) {
        return patrons.get(id);
    }

    public Collection<Patron> getAllPatrons() {
        return patrons.values();
    }
}
