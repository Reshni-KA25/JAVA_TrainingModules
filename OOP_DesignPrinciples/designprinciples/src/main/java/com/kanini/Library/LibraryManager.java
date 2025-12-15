package com.kanini.Library;

import com.kanini.Library.Exception.*;
import com.kanini.Library.Models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private static final Logger log = LoggerFactory.getLogger(LibraryManager.class);

    private final List<Book> books = new ArrayList<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        log.info("Book added: {}", book.getTitle());
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book findBookByIsbn(String isbn) {
        return books.stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
                .findFirst()
                .orElseThrow(() -> new LibraryException("Book not found"));
    }

    public Loan lendBook(Book book, Member member) {
        if (!book.isAvailable()) {
            throw new BookNotAvailableException("Book already borrowed");
        }

        book.borrow();
        Loan loan = new Loan(book, member);
        loans.add(loan);

        log.info("Book '{}' lent to {}", book.getTitle(), member.getName());
        return loan;
    }

    public void returnBook(Loan loan) {
          if (loan == null) {
        throw new LibraryException("Book was not borrowed, cannot return");
    }
        if (loan.isReturned()) {
            throw new InvalidReturnException("Book already returned");
        }

        loan.markReturned();
        loan.getBook().giveBack();

        log.info("Book '{}' returned by {}", loan.getBook().getTitle(),
                loan.getMember().getName());
    }
}
