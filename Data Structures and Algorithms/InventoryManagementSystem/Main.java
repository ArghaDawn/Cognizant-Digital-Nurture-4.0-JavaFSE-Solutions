package InventoryManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter Product ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter Product Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Quantity: ");
                int qty = scanner.nextInt();
                System.out.print("Enter Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();
                Product p = new Product(id, name, qty, price);
                inventory.addProduct(p);
                System.out.println("Product added.");
            } else if (choice == 2) {
                System.out.print("Enter Product ID to update: ");
                String id = scanner.nextLine();
                System.out.print("Enter New Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter New Quantity: ");
                int qty = scanner.nextInt();
                System.out.print("Enter New Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();
                boolean updated = inventory.updateProduct(id, name, qty, price);
                if (updated) {
                    System.out.println("Product updated.");
                } else {
                    System.out.println("Product not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter Product ID to delete: ");
                String id = scanner.nextLine();
                boolean deleted = inventory.deleteProduct(id);
                if (deleted) {
                    System.out.println("Product deleted.");
                } else {
                    System.out.println("Product not found.");
                }
            } else if (choice == 4) {
                inventory.displayAllProducts();
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
