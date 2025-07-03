package com.library;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;

public class LibraryManagementTest {
    
    @Test
    public void testSpringContextLoading() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        assertNotNull("Spring context should not be null", context);
        
        if (context instanceof org.springframework.context.ConfigurableApplicationContext) {
            ((org.springframework.context.ConfigurableApplicationContext) context).close();
        }
    }
    
    @Test
    public void testBeanConfiguration() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BookService bookService = (BookService) context.getBean("bookService");
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        
        assertNotNull("BookService bean should not be null", bookService);
        assertNotNull("BookRepository bean should not be null", bookRepository);
        
        if (context instanceof org.springframework.context.ConfigurableApplicationContext) {
            ((org.springframework.context.ConfigurableApplicationContext) context).close();
        }
    }
    
    @Test
    public void testBookServiceFunctionality() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");
        
        assertTrue("Should have initial books", bookService.getTotalBooks() > 0);
        assertTrue("Should find existing book", bookService.searchBook("1984"));
        assertFalse("Should not find non-existent book", bookService.searchBook("Non-existent Book"));
        
        int initialCount = bookService.getTotalBooks();
        bookService.addBook("Test Book");
        assertEquals("Book count should increase", initialCount + 1, bookService.getTotalBooks());
        
        if (context instanceof org.springframework.context.ConfigurableApplicationContext) {
            ((org.springframework.context.ConfigurableApplicationContext) context).close();
        }
    }
}
