package com.bpi.m4project;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Library {
    private static final Logger logger = LoggerFactory.getLogger(Library.class);

    private List<Book> books = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    // Add book
    public void addBook(Book book) {
        try {
            if (book.getId() <= 0) {
                throw new InvalidBookIdException("Book ID must be positive.");
            }
            for (Book b : books) {
                if (b.getId() == book.getId()) {
                    throw new IllegalArgumentException("Book ID already exists.");
                }
            }
            books.add(book);
            logger.info("Book added: {}", book.getTitle());
        } catch (InvalidBookIdException | IllegalArgumentException e) {
            logger.warn("Failed to add book: {}", e.getMessage());
        }
    }

    // Display all books
    public void displayAllBooks() {
        if (books.isEmpty()) {
            logger.info("No books in library.");
            return;
        }
        for (Book b : books) {
            logger.info("ID: {} | Title: {} | Author: {}", b.getId(), b.getTitle(), b.getAuthor());
        }
    }

    // Display available books
    public void displayAvailableBooks() {
        boolean found = false;
        for (Book b : books) {
            if (!b.isBorrowed()) {
                logger.info("Available -> {}", b.getTitle());
                found = true;
            }
        }
        if (!found) logger.info("No available books.");
    }

    // Display borrowed books
    public void displayBorrowedBooks() {
        if (loans.isEmpty()) {
            logger.info("No borrowed books.");
            return;
        }
        for (Loan l : loans) {
            logger.info("Borrowed -> {} by {}", l.getBook().getTitle(), l.getUser().getName());
        }
    }

    // Borrow book
    public void borrowBook(int bookId, User user) {
        try {
            if (bookId <= 0) {
                throw new InvalidBookIdException("Book ID must be positive.");
            }
            for (Book b : books) {
                if (b.getId() == bookId && !b.isBorrowed()) {
                    b.setBorrowed(true);
                    Loan loan = new Loan(loans.size() + 1, user, b);
                    loans.add(loan);
                    logger.info("{} borrowed {}", user.getName(), b.getTitle());
                    return;
                }
            }
            throw new NoSuchElementException("Book not available.");
        } catch (InvalidBookIdException | NoSuchElementException e) {
            logger.warn(e.getMessage());
        }
    }

    // Return book
    public void returnBook(int loanId) {
        try {
            for (Loan l : loans) {
                if (l.getId() == loanId) {
                    l.getBook().setBorrowed(false);
                    loans.remove(l);
                    logger.info("Returned -> {}", l.getBook().getTitle());
                    return;
                }
            }
            throw new NoSuchElementException("Loan ID not found.");
        } catch (NoSuchElementException e) {
            logger.warn(e.getMessage());
        }
    }

    // Remove book
    public void removeBook(int bookId) {
        try {
            if (bookId <= 0) {
                throw new InvalidBookIdException("Book ID must be positive.");
            }
            for (int i = 0; i < books.size(); i++) {
                Book b = books.get(i);
                if (b.getId() == bookId) {
                    if (b.isBorrowed()) {
                        throw new IllegalStateException("Cannot remove borrowed book.");
                    }
                    books.remove(i);
                    logger.info("Book removed: {}", b.getTitle());
                    return;
                }
            }
            throw new NoSuchElementException("Book ID not found.");
        } catch (InvalidBookIdException | IllegalStateException | NoSuchElementException e) {
            logger.warn(e.getMessage());
        }
    }

    // Update book
    public void updateBook(int bookId, String newTitle, String newAuthor) {
        try {
            if (bookId <= 0) {
                throw new InvalidBookIdException("Book ID must be positive.");
            }
            for (Book b : books) {
                if (b.getId() == bookId) {
                    if (b.isBorrowed()) {
                        throw new IllegalStateException("Cannot update borrowed book.");
                    }
                    if (newTitle != null && !newTitle.isEmpty()) b.setTitle(newTitle);
                    if (newAuthor != null && !newAuthor.isEmpty()) b.setAuthor(newAuthor);
                    logger.info("Book updated: {} by {}", b.getTitle(), b.getAuthor());
                    return;
                }
            }
            throw new NoSuchElementException("Book ID not found.");
        } catch (InvalidBookIdException | IllegalStateException | NoSuchElementException e) {
            logger.warn(e.getMessage());
        }
    }
}
