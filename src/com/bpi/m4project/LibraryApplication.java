package com.bpi.m4project;

import java.util.*;
import java.util.logging.*;

public class LibraryApplication {
    private static final Logger logger = Logger.getLogger(LibraryApplication.class.getName());

    private User user;
    private Library library;

    public void start() {
        Scanner sc = new Scanner(System.in);

        logger.info("Welcome to Library!");
        System.out.print("Enter User name: ");
        String name = sc.nextLine();
        this.user = new User(name, 1);

        this.library = new Library();

        // Initialize 5 books
        library.addBook(new Book(101, "Goodnight Moon", "Margaret Wise Brown"));
        library.addBook(new Book(102, "Charlotte’s Web", "E. B. White"));
        library.addBook(new Book(103, "Junie B. Jones Series", "Barbara Park"));
        library.addBook(new Book(104, "Amelia Bedelia Series", "Peggy Parish"));
        library.addBook(new Book(105, "The Gruffalo", "Julia Donaldson"));

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("[1] Display All Books");
            System.out.println("[2] Display Available Books");
            System.out.println("[3] Display All Borrowed Books");
            System.out.println("[4] Borrow Book");
            System.out.println("[5] Return Book");
            System.out.println("[6] Add Book");
            System.out.println("[7] Remove Book");
            System.out.println("[8] Update Book");
            System.out.println("[0] Exit");
            System.out.print("\nChoice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> library.displayAllBooks();
                    case 2 -> library.displayAvailableBooks();
                    case 3 -> library.displayBorrowedBooks();
                    case 4 -> {
                        System.out.print("Enter Book ID to borrow: ");
                        int bookId = sc.nextInt();
                        library.borrowBook(bookId, user);
                    }
                    case 5 -> {
                        System.out.print("Enter Loan ID to return: ");
                        int loanId = sc.nextInt();
                        library.returnBook(loanId);
                    }
                    case 6 -> {
                        System.out.print("Enter new Book ID: ");
                        int newId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        library.addBook(new Book(newId, title, author));
                    }
                    case 7 -> {
                        System.out.print("Enter Book ID to remove: ");
                        int removeId = sc.nextInt();
                        library.removeBook(removeId);
                    }
                    case 8 -> {
                        System.out.print("Enter Book ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new Title (leave blank to skip): ");
                        String newTitle = sc.nextLine();
                        System.out.print("Enter new Author (leave blank to skip): ");
                        String newAuthor = sc.nextLine();
                        library.updateBook(updateId, newTitle, newAuthor);
                    }
                    case 0 -> {
                        logger.info("Exiting...");
                        sc.close();
                        return;
                    }
                    default -> logger.warning("Invalid choice");
                }
            } catch (InputMismatchException e) {
                logger.severe("Invalid input. Please enter a number.");
                sc.nextLine(); // clear buffer
            }
        }
    }
}
