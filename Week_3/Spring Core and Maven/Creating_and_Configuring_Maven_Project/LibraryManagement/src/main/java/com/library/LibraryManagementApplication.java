package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// ...existing code...
public class LibraryManagementApplication {
    
    public static void main(String[] args) {
        System.out.println("Starting Library Management Application...");
        
        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("Library Management Application started successfully!");
        
        // Close context if it's a ConfigurableApplicationContext
        if (context instanceof org.springframework.context.ConfigurableApplicationContext) {
            ((org.springframework.context.ConfigurableApplicationContext) context).close();
        }
    }
}
