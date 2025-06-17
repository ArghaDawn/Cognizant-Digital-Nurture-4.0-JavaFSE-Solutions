public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private static final int CAPACITY = 100;

    public EmployeeManagementSystem() {
        employees = new Employee[CAPACITY];
        size = 0;
    }

    // Add an employee
    public boolean addEmployee(Employee emp) {
        if (size >= CAPACITY) return false;
        employees[size++] = emp;
        return true;
    }

    // Search employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee by ID
    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                // Shift elements left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }

    // Print analysis
    public void printAnalysis() {
        System.out.println("Analysis of Array Operations:");
        System.out.println("1. Add: O(1) (if space available)\n2. Search: O(n)\n3. Traverse: O(n)\n4. Delete: O(n) (due to shifting)");
        System.out.println("Limitations: Fixed size, costly insert/delete except at end, inefficient memory usage if array is sparse.\nUse arrays when size is known and random access is needed.");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.addEmployee(new Employee(1, "Alice", "Manager", 80000));
        ems.addEmployee(new Employee(2, "Bob", "Developer", 60000));
        ems.addEmployee(new Employee(3, "Charlie", "Analyst", 50000));

        System.out.println("All Employees:");
        ems.traverseEmployees();

        System.out.println("\nSearching for Employee with ID 2:");
        System.out.println(ems.searchEmployee(2));

        System.out.println("\nDeleting Employee with ID 1:");
        ems.deleteEmployee(1);
        ems.traverseEmployees();

        System.out.println("\n--- Analysis ---");
        ems.printAnalysis();
    }
}
