package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {
    
    private BookRepository bookRepository;
    
    public BookService() {
        System.out.println("BookService created");
    }
    
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected into BookService");
    }
    
    public List<String> getAllBooks() {
        System.out.println("BookService: Getting all books");
        return bookRepository.getAllBooks();
    }
    
    public void addBook(String bookTitle) {
        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            System.out.println("BookService: Invalid book title provided");
            return;
        }
        
        if (bookRepository.findBook(bookTitle)) {
            System.out.println("BookService: Book already exists - " + bookTitle);
            return;
        }
        
        System.out.println("BookService: Adding new book - " + bookTitle);
        bookRepository.addBook(bookTitle);
    }
    
    public boolean searchBook(String title) {
        System.out.println("BookService: Searching for book - " + title);
        boolean found = bookRepository.findBook(title);
        System.out.println("BookService: Book " + (found ? "found" : "not found"));
        return found;
    }
    
    public boolean removeBook(String title) {
        System.out.println("BookService: Attempting to remove book - " + title);
        return bookRepository.removeBook(title);
    }
    
    public int getTotalBooks() {
        int count = bookRepository.getBookCount();
        System.out.println("BookService: Total books in library - " + count);
        return count;
    }
    
    public void displayAllBooks() {
        System.out.println("BookService: Displaying all books in the library:");
        List<String> books = getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available in the library");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }
}
