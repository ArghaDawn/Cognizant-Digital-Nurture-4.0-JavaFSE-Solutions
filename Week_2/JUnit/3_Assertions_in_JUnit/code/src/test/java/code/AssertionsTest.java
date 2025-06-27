package code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AssertionsTest {
    
    private Calculator calculator;
    
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    public void testBasicAssertions() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should equal 1");
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6");
        assertEquals(2.0, calculator.divide(4, 2), 0.001, "4 / 2 should equal 2.0");
        
        assertTrue(calculator.isEven(4), "4 should be even");
        assertTrue(calculator.isPositive(5), "5 should be positive");
        assertTrue(5 > 3, "5 should be greater than 3");
        
        assertFalse(calculator.isEven(3), "3 should not be even");
        assertFalse(calculator.isPositive(-5), "-5 should not be positive");
        assertFalse(5 < 3, "5 should not be less than 3");
    }
    
    @Test
    public void testNullAssertions() {
        assertNull(calculator.getNullValue(), "getNullValue() should return null");
        
        assertNotNull(calculator.getNonNullValue(), "getNonNullValue() should not return null");
        assertNotNull(new Object(), "New object should not be null");
        assertNotNull(calculator, "Calculator instance should not be null");
    }
    
    @Test
    public void testStringAssertions() {
        assertEquals("positive", calculator.getNumberType(5), "5 should be classified as positive");
        assertEquals("negative", calculator.getNumberType(-3), "-3 should be classified as negative");
        assertEquals("zero", calculator.getNumberType(0), "0 should be classified as zero");
        
        String result = calculator.getNonNullValue();
        assertNotNull(result);
        assertEquals("Hello World", result);
    }
    
    @Test
    public void testArrayAssertions() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = calculator.getArray();
        
        assertArrayEquals(expected, actual, "Arrays should be equal");
        
        assertNotNull(actual, "Array should not be null");
        assertEquals(5, actual.length, "Array should have 5 elements");
    }
    
    @Test
    public void testExceptionAssertions() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> calculator.divide(10, 0),
            "Division by zero should throw IllegalArgumentException"
        );
        
        assertEquals("Division by zero is not allowed", exception.getMessage());
        
        assertDoesNotThrow(() -> calculator.divide(10, 2), "Normal division should not throw exception");
    }
    
    @Test
    public void testAdvancedAssertions() {
        assertAll("Calculator operations",
            () -> assertEquals(8, calculator.add(3, 5), "Addition test"),
            () -> assertEquals(2, calculator.subtract(5, 3), "Subtraction test"),
            () -> assertEquals(15, calculator.multiply(3, 5), "Multiplication test"),
            () -> assertTrue(calculator.isPositive(10), "Positive test")
        );
    }
    
    @Test
    public void testAssertionsWithCustomMessages() {
        int result = calculator.add(10, 15);
        assertEquals(25, result, () -> "Expected 25 but got " + result + " when adding 10 and 15");
        
        assertTrue(calculator.isEven(8), () -> "8 should be even, but isEven returned false");
    }
}