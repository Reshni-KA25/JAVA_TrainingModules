package com.kanini.Library.Models;

public class Librarian {

    private final int librarianId;
    private final String name;

    public Librarian(int librarianId, String name) {
        this.librarianId = librarianId;
        this.name = name;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public String getName() {
        return name;
    }
}
