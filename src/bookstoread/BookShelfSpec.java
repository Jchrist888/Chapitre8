package bookstoread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookShelfSpec {

    private BookShelf shelf;

    private Book effectiveJava;
    private Book codeComplete;
    private Book mythicalManMonth;

    @BeforeEach
    void init() {
        shelf = new BookShelf();

        effectiveJava = new Book(
                "Effective Java",
                "Joshua Bloch",
                LocalDate.of(2008, 5, 8)
        );

        codeComplete = new Book(
                "Code Complete",
                "Steve McConnell",
                LocalDate.of(2004, 6, 9)
        );

        mythicalManMonth = new Book(
                "The Mythical Man-Month",
                "Frederick P. Brooks",
                LocalDate.of(1975, 1, 1)
        );
    }

    @Test
    public void shelfEmptyWhenNoBookAdded() {
        List<Book> books = shelf.books();
        assertTrue(books.isEmpty());
    }

    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        shelf.add(effectiveJava, codeComplete);

        List<Book> books = shelf.books();

        assertEquals(2, books.size());
    }

    @Test
    public void emptyBookShelfWhenAddIsCalledWithoutBooks() {
        shelf.add();

        List<Book> books = shelf.books();

        assertTrue(books.isEmpty());
    }

    @Test
    void booksReturnedFromBookShelfIsImmutableForClient() {
        shelf.add(effectiveJava, codeComplete);

        List<Book> books = shelf.books();

        assertThrows(UnsupportedOperationException.class, () -> {
            books.add(mythicalManMonth);
        });
    }

    @Test
    void bookshelfArrangedByBookTitle() {
        shelf.add(effectiveJava, codeComplete, mythicalManMonth);

        List<Book> books = shelf.arrange();

        assertEquals(
                Arrays.asList(codeComplete, effectiveJava, mythicalManMonth),
                books
        );
    }

    @Test
    void booksInBookShelfAreInInsertionOrderAfterCallingArrange() {
        shelf.add(effectiveJava, codeComplete, mythicalManMonth);

        shelf.arrange();

        List<Book> books = shelf.books();

        assertEquals(
                Arrays.asList(effectiveJava, codeComplete, mythicalManMonth),
                books
        );
    }
}