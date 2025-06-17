public class Main {
    public static double futureValue(double principal, double rate, int periods) {
        if (periods == 0) {
            return principal;
        }
        return futureValue(principal, rate, periods - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        double principal = 1000.0;
        double rate = 0.15;
        int periods = 5;

        double result = futureValue(principal, rate, periods);
        System.out.printf("Future Value after %d periods: %.2f\n", periods, result);

        System.out.println("\nAnalysis:");
        System.out.println("Time Complexity: The recursive algorithm has O(n) time complexity, where n is the number of periods. This is because each recursive call reduces the problem size by 1 until the base case is reached.\n");
        System.out.println("Optimization: To avoid excessive computation (such as repeated calculations in more complex recursive problems), recursion can be optimized using memoization or by converting it to an iterative approach. In this case, since each call depends only on the previous result, an iterative loop would be more efficient for large n.\n");
    }
}
