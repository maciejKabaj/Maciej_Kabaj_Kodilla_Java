package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    private static Library library = new Library("Test Library");

    @BeforeAll
    static void setUpLibrary() {
        for (int i = 1; i <= 3; i++) {
            library.getBooks().add(new Book("Title " + i, "Author " + i, LocalDate.now()));
        }
    }

    @Test
    void testGetBooks() throws CloneNotSupportedException {
        //Given
        Library shallowLibraryCopy = library.shallowCopy();
        Library deepLibraryCopy = library.deepCopy();
        //When
        library.getBooks().add(new Book("Test Book", "Test Author", LocalDate.now()));
        //Then
        assertEquals(4, library.getBooks().size());
        assertEquals(4, shallowLibraryCopy.getBooks().size());
        assertEquals(3, deepLibraryCopy.getBooks().size());
    }
}
