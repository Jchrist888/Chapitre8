package bookstoread;

import java.util.*;
import java.util.stream.Collectors;

public class BookShelf {

    private final List<Book> books = new ArrayList<>();

    // Ajout de livres
    public void add(Book... booksToAdd) {
        books.addAll(Arrays.asList(booksToAdd));
    }

    // Retour ordre d'insertion (IMMUTABLE)
    public List<Book> books() {
        return Collections.unmodifiableList(books);
    }

    // Tri SANS modifier la collection interne
    public List<Book> arrange() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }
}