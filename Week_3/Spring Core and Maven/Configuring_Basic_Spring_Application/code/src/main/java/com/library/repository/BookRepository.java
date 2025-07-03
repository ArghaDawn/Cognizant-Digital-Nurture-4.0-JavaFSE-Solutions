package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    
    private List<String> books;
    
    public BookRepository() {
        this.books = new ArrayList<>();
        books.add("The Great Gatsby");
        books.add("To Kill a Mockingbird");
        books.add("1984");
        books.add("Pride and Prejudice");
        System.out.println("BookRepository initialized with sample books");
    }
    
    public List<String> getAllBooks() {
        return new ArrayList<>(books);
    }
    
    public void addBook(String bookTitle) {
        books.add(bookTitle);
        System.out.println("Book added: " + bookTitle);
    }
    
    public boolean findBook(String title) {
        return books.contains(title);
    }
    
    public boolean removeBook(String title) {
        boolean removed = books.remove(title);
        if (removed) {
            System.out.println("Book removed: " + title);
        } else {
            System.out.println("Book not found: " + title);
        }
        return removed;
    }
    
    public int getBookCount() {
        return books.size();
    }
}
