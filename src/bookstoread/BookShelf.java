package bookstoread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookShelf {
    private final List<String> books = new ArrayList<>();

    // Retourne la liste des livres
    public List<String> books() {
        return books;
    }

    // Ajoute plusieurs livres à la fois
    public void add(String... booksToAdd) {
        books.addAll(Arrays.asList(booksToAdd));
    }
}