package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApp {
    
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===");
        System.out.println("Initializing Spring Application Context...\n");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("Spring Application Context loaded successfully!\n");
        
        BookService bookService = (BookService) context.getBean("bookService");
        
        System.out.println("=== Testing Library Management Operations ===\n");
        
        bookService.getTotalBooks();
        System.out.println();
        
        bookService.displayAllBooks();
        System.out.println();
        
        bookService.addBook("The Catcher in the Rye");
        System.out.println();
        
        bookService.searchBook("1984");
        bookService.searchBook("Non-existent Book");
        System.out.println();
        
        bookService.addBook("1984");
        System.out.println();
        
        System.out.println("=== Updated Book List ===");
        bookService.displayAllBooks();
        System.out.println();
        
        bookService.removeBook("The Great Gatsby");
        System.out.println();
        
        System.out.println("=== Final Book List ===");
        bookService.displayAllBooks();
        System.out.println();
        
        bookService.getTotalBooks();
        
        System.out.println("\n=== Spring Configuration Test Completed Successfully! ===");
        
        if (context instanceof org.springframework.context.ConfigurableApplicationContext) {
            ((org.springframework.context.ConfigurableApplicationContext) context).close();
            System.out.println("Spring Application Context closed.");
        }
    }
}
