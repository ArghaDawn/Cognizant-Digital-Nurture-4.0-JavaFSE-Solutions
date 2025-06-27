package code;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return (double) a / b;
    }
    
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public boolean isPositive(int number) {
        return number > 0;
    }
    
    public String getNumberType(int number) {
        if (number > 0) {
            return "positive";
        } else if (number < 0) {
            return "negative";
        } else {
            return "zero";
        }
    }
    
    public int[] getArray() {
        return new int[]{1, 2, 3, 4, 5};
    }
    
    public String getNullValue() {
        return null;
    }
    
    public String getNonNullValue() {
        return "Hello World";
    }
}