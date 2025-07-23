package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public class Library implements Cloneable {

    final String name;
    final Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Library)super.clone();
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library copiedLibrary = (Library) shallowCopy();
        copiedLibrary.getBooks().clear();
        for (Book book : books) {
            Book copiedBooks = new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate());
            copiedLibrary.getBooks().add(copiedBooks);
        }
        return copiedLibrary;
    }
}
