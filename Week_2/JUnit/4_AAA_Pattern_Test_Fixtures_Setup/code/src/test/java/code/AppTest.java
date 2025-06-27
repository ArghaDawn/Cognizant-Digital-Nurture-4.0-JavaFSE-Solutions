package code;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest 
{
    private App app;
    private int testCounter;
    
    @Before
    public void setUp() {
        System.out.println("Setting up test environment...");
        app = new App();
        testCounter++;
        System.out.println("Test #" + testCounter + " is starting");
    }
    
    @After
    public void tearDown() {
        System.out.println("Cleaning up after test #" + testCounter);
        app = null;
        System.out.println("Test completed.\n");
    }
    
    @Test
    public void testAddition() {
        int firstNumber = 5;
        int secondNumber = 3;
        int expectedResult = 8;
        
        int actualResult = app.add(firstNumber, secondNumber);
        
        assertEquals("Addition should return correct sum", expectedResult, actualResult);
    }
    
    @Test
    public void testSubtraction() {
        int minuend = 10;
        int subtrahend = 4;
        int expectedResult = 6;
        
        int actualResult = app.subtract(minuend, subtrahend);
        
        assertEquals("Subtraction should return correct difference", expectedResult, actualResult);
    }
    
    @Test
    public void testMultiplication() {
        int multiplicand = 6;
        int multiplier = 7;
        int expectedResult = 42;
        
        int actualResult = app.multiply(multiplicand, multiplier);
        
        assertEquals("Multiplication should return correct product", expectedResult, actualResult);
    }
    
    @Test
    public void testDivision() {
        int dividend = 15;
        int divisor = 3;
        double expectedResult = 5.0;
        double delta = 0.001;
        
        double actualResult = app.divide(dividend, divisor);
        
        assertEquals("Division should return correct quotient", expectedResult, actualResult, delta);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDivisionByZero() {
        int dividend = 10;
        int divisor = 0;
        
        app.divide(dividend, divisor);
    }
    
    @Test
    public void testAddNumberToList() {
        int numberToAdd = 25;
        int expectedCount = 1;
        
        app.addNumber(numberToAdd);
        
        assertEquals("Count should be 1 after adding one number", expectedCount, app.getCount());
        assertFalse("List should not be empty after adding a number", app.isEmpty());
    }
    
    @Test
    public void testSumCalculation() {
        int[] numbersToAdd = {10, 20, 30};
        int expectedSum = 60;
        
        for (int number : numbersToAdd) {
            app.addNumber(number);
        }
        int actualSum = app.getSum();
        
        assertEquals("Sum should be calculated correctly", expectedSum, actualSum);
        assertEquals("Count should match number of added elements", numbersToAdd.length, app.getCount());
    }
    
    @Test
    public void testEmptyListState() {
        int expectedCount = 0;
        int expectedSum = 0;
        
        int actualCount = app.getCount();
        int actualSum = app.getSum();
        boolean isEmpty = app.isEmpty();
        
        assertEquals("New list should be empty", expectedCount, actualCount);
        assertEquals("Sum of empty list should be zero", expectedSum, actualSum);
        assertTrue("New list should report as empty", isEmpty);
    }
    
    @Test
    public void testClearNumbers() {
        app.addNumber(10);
        app.addNumber(20);
        app.addNumber(30);
        assertEquals("Should have 3 numbers before clearing", 3, app.getCount());
        
        app.clearNumbers();
        
        assertEquals("Count should be 0 after clearing", 0, app.getCount());
        assertEquals("Sum should be 0 after clearing", 0, app.getSum());
        assertTrue("List should be empty after clearing", app.isEmpty());
    }
}
