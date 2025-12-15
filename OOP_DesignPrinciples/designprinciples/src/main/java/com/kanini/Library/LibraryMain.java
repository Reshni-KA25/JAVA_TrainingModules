package com.kanini.Library;

import com.kanini.Library.Exception.LibraryException;
import com.kanini.Library.Models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibraryMain {

    public static void main(String[] args) {

        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        Member member = new Member(1, "Reshni");

        manager.addBook(new Book("ISBN-101", "Clean Code", "Robert C. Martin"));
        manager.addBook(new Book("ISBN-102", "Effective Java", "Joshua Bloch"));
        manager.addBook(new Book("ISBN-103", "Design Patterns", "GoF"));
        manager.addBook(new Book("ISBN-104", "Refactoring", "Martin Fowler"));

        Map<String, Loan> activeLoans = new HashMap<>();

        while (true) {
            System.out.println("\n1. Display all books");
            System.out.println("2. Lend a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> manager.getAllBooks().forEach(b ->
                            System.out.println(b.getIsbn() + " | " + b.getTitle()
                                    + " | " + (b.isAvailable() ? "Available" : "Borrowed")));

                    case 2 -> {
                        System.out.print("Enter ISBN: ");
                       String input = scanner.nextLine();
String isbn = "ISBN-" + input;
                        Loan loan = manager.lendBook(manager.findBookByIsbn(isbn), member);
                        activeLoans.put(isbn, loan);
                        System.out.println("Book lent.");
                    }

                    case 3 -> {
                        System.out.print("Enter ISBN: ");
                       String input = scanner.nextLine();
String isbn = "ISBN-" + input;
                        manager.returnBook(activeLoans.remove(isbn));
                        System.out.println("Book returned.");
                    }

                    case 4 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                }
            } catch (LibraryException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
