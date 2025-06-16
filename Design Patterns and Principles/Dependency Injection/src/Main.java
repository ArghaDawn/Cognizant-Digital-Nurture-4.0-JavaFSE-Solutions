package src;

public class Main {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        Customer customer = service.getCustomerById(1);
        System.out.println(customer);
    }
}
