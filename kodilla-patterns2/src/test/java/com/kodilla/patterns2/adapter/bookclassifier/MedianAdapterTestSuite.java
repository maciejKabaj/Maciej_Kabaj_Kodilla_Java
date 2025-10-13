package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //Given
        com.kodilla.patterns2.adapter.bookclassifier.librarya.Book oldBook1 =
                new Book("Stephen King", "The Shining", 1977, "A001");
        com.kodilla.patterns2.adapter.bookclassifier.librarya.Book oldBook2 =
                new Book("George Orwell", "1984", 1949, "A002");
        com.kodilla.patterns2.adapter.bookclassifier.librarya.Book oldBook3 =
                new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", 1997, "A003");
        Set<Book> oldBookSet = new HashSet<>(Arrays.asList(oldBook1, oldBook2, oldBook3));
        //When
        MedianAdapter adapter = new MedianAdapter();
        int median = adapter.publicationYearMedian(oldBookSet);
        //Then
        assertEquals(1977, median);
    }
}
