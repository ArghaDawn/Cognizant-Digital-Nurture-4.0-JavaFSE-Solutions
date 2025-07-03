package com.library.service;

import com.library.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

// ...existing code...
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetAllBooks() {
        List<Book> books = bookService.getAllBooks();
        assertNotNull("Books list should not be null", books);
        assertTrue("Books list should contain initial books", books.size() >= 3);
    }

    @Test
    public void testGetBookById() {
        Optional<Book> book = bookService.getBookById("1");
        assertTrue("Book with ID 1 should exist", book.isPresent());
        assertEquals("Book title should match", "Spring in Action", book.get().getTitle());
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book("4", "Test Book", "Test Author", "123456789");
        Book addedBook = bookService.addBook(newBook);
        
        assertNotNull("Added book should not be null", addedBook);
        assertEquals("Added book should have correct title", "Test Book", addedBook.getTitle());
        
        Optional<Book> retrievedBook = bookService.getBookById("4");
        assertTrue("Added book should be retrievable", retrievedBook.isPresent());
    }

    @Test
    public void testBorrowAndReturnBook() {
        
        boolean borrowed = bookService.borrowBook("1");
        assertTrue("Book should be successfully borrowed", borrowed);
        
        Optional<Book> book = bookService.getBookById("1");
        assertTrue("Book should exist", book.isPresent());
        assertFalse("Book should not be available after borrowing", book.get().isAvailable());
        
        
        boolean returned = bookService.returnBook("1");
        assertTrue("Book should be successfully returned", returned);
        
        book = bookService.getBookById("1");
        assertTrue("Book should exist", book.isPresent());
        assertTrue("Book should be available after returning", book.get().isAvailable());
    }

    @Test
    public void testGetAvailableBooks() {
        List<Book> availableBooks = bookService.getAvailableBooks();
        assertNotNull("Available books list should not be null", availableBooks);
        

        for (Book book : availableBooks) {
            assertTrue("All returned books should be available", book.isAvailable());
        }
    }
}
