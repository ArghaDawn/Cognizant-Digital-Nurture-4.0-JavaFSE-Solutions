package code;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    private List<Integer> numbers;
    
    public App() {
        this.numbers = new ArrayList<>();
    }
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
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
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) a / b;
    }
    
    public void addNumber(int number) {
        numbers.add(number);
    }
    
    public int getSum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
    
    public int getCount() {
        return numbers.size();
    }
    
    public void clearNumbers() {
        numbers.clear();
    }
    
    public boolean isEmpty() {
        return numbers.isEmpty();
    }
}
