package code;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testAdd() {
        main calculator = new main();
        assertEquals(5, calculator.add(2, 3), "2 + 3 should be 5");
        assertEquals(-1, calculator.add(2, -3), "2 + (-3) should be -1");
        assertEquals(0, calculator.add(0, 0), "0 + 0 should be 0");
    }

    @Test
    void testSubtract() {
        main calculator = new main();
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should be 1");
        assertEquals(5, calculator.subtract(2, -3), "2 - (-3) should be 5");
        assertEquals(0, calculator.subtract(5, 5), "5 - 5 should be 0");
    }

    @Test
    void testMultiply() {
        main calculator = new main();
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should be 6");
        assertEquals(-6, calculator.multiply(2, -3), "2 * (-3) should be -6");
        assertEquals(0, calculator.multiply(5, 0), "5 * 0 should be 0");
    }

    @Test
    void testDivide() {
        main calculator = new main();
        assertEquals(2.0, calculator.divide(6, 3), "6 / 3 should be 2.0");
        assertEquals(-2.5, calculator.divide(5, -2), 0.001, "5 / -2 should be -2.5");
        assertEquals(0.0, calculator.divide(0, 5), "0 / 5 should be 0.0");
    }

    @Test
    void testDivideByZero() {
        main calculator = new main();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        }, "Dividing by zero should throw IllegalArgumentException");
    }
}