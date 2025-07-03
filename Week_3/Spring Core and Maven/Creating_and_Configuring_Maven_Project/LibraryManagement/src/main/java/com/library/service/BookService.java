package com.library.service;

import com.library.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// ...existing code...
@Service
public class BookService {
    
    private List<Book> books;

    public BookService() {
        this.books = new ArrayList<>();
        // Initialize with some sample books
        initializeSampleBooks();
    }

    private void initializeSampleBooks() {
        books.add(new Book("1", "Spring in Action", "Craig Walls", "978-1617294945"));
        books.add(new Book("2", "Java: The Complete Reference", "Herbert Schildt", "978-1260440232"));
        books.add(new Book("3", "Clean Code", "Robert C. Martin", "978-0132350884"));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public Optional<Book> getBookById(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public boolean removeBook(String id) {
        return books.removeIf(book -> book.getId().equals(id));
    }

    public boolean borrowBook(String id) {
        Optional<Book> bookOpt = getBookById(id);
        if (bookOpt.isPresent() && bookOpt.get().isAvailable()) {
            bookOpt.get().setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(String id) {
        Optional<Book> bookOpt = getBookById(id);
        if (bookOpt.isPresent() && !bookOpt.get().isAvailable()) {
            bookOpt.get().setAvailable(true);
            return true;
        }
        return false;
    }

    public List<Book> getAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
