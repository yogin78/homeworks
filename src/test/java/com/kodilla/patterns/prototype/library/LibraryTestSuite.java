package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void testShallowCloning() throws CloneNotSupportedException {
        // Given
        Library originalLibrary = new Library("Original Library");
        Book book1 = new Book("Title1", "Author1", LocalDate.of(2000, 1, 1));
        Book book2 = new Book("Title2", "Author2", LocalDate.of(2005, 5, 15));
        originalLibrary.getBooks().add(book1);
        originalLibrary.getBooks().add(book2);

        // When
        Library shallowClonedLibrary = originalLibrary.clone();

        // Then
        assertNotSame(originalLibrary, shallowClonedLibrary);
        assertEquals(originalLibrary.getBooks(), shallowClonedLibrary.getBooks());

        // Adding a new book to the shallowClonedLibrary should not affect the original library
        shallowClonedLibrary.getBooks().add(new Book("Title3", "Author3", LocalDate.of(2010, 7, 20)));

        assertNotEquals(originalLibrary.getBooks().size(), shallowClonedLibrary.getBooks().size());
    }

    @Test
    void testDeepCloning() throws CloneNotSupportedException {
        // Given
        Library originalLibrary = new Library("Original Library");
        Book book1 = new Book("Title1", "Author1", LocalDate.of(2000, 1, 1));
        Book book2 = new Book("Title2", "Author2", LocalDate.of(2005, 5, 15));
        originalLibrary.getBooks().add(book1);
        originalLibrary.getBooks().add(book2);

        // When
        Library deepClonedLibrary = originalLibrary.clone();

        // Then
        assertNotSame(originalLibrary, deepClonedLibrary);
        assertEquals(originalLibrary.getName(), deepClonedLibrary.getName());
        assertNotSame(originalLibrary.getBooks(), deepClonedLibrary.getBooks()); // Deep copy: different book sets
        assertEquals(originalLibrary.getBooks().size(), deepClonedLibrary.getBooks().size()); // Same content

        // Verify that changes in the cloned library do not affect the original library
        deepClonedLibrary.getBooks().remove(book1);
        deepClonedLibrary.getBooks().add(new Book("Title3", "Author3", LocalDate.of(2010, 7, 20)));

        assertTrue(originalLibrary.getBooks().contains(book1));
        assertFalse(deepClonedLibrary.getBooks().contains(book1));
        assertEquals(2, originalLibrary.getBooks().size());
        assertEquals(2, deepClonedLibrary.getBooks().size());
    }
}
