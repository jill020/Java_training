package com.bpi.activity8_2;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books = new ArrayList<>(
        List.of(
            new Book("1", "Java", "Java King"),
            new Book("2", "API", "Apihan"),
            new Book("3", "HTTP", "Http")
        )
    );

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // GET single book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null); 
    }
}
