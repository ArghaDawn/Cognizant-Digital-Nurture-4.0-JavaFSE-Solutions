public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        PaymentStrategy creditCard = new CreditCardPayment("1234567890123456", "John Doe", "123");
        context.setPaymentStrategy(creditCard);
        context.pay(100.0);
        PaymentStrategy paypal = new PayPalPayment("john.doe@example.com");
        context.setPaymentStrategy(paypal);
        context.pay(200.0);
    }
}
