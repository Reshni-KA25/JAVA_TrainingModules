package com.kanini.Library.Models;

import java.time.LocalDate;

public class Loan {

    private final Book book;
    private final Member member;
    private final LocalDate issuedOn;
    private LocalDate returnedOn;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.issuedOn = LocalDate.now();
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public boolean isReturned() {
        return returnedOn != null;
    }

    public void markReturned() {
        this.returnedOn = LocalDate.now();
    }
}
