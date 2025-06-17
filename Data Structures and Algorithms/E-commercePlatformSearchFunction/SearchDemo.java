class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

public class SearchDemo {
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(3, "Laptop", "Electronics"),
                new Product(1, "Shirt", "Apparel"),
                new Product(2, "Book", "Books"),
                new Product(5, "Phone", "Electronics"),
                new Product(4, "Shoes", "Apparel")
        };

        System.out.println("Linear Search for productId=4: " + linearSearch(products, 4));

        java.util.Arrays.sort(products, java.util.Comparator.comparingInt(p -> p.productId));
        System.out.println("Binary Search for productId=4: " + binarySearch(products, 4));

        System.out.println("\nAnalysis:");
        System.out.println("Linear Search: O(n) time complexity. Suitable for small/unsorted data.");
        System.out.println("Binary Search: O(log n) time complexity. Suitable for large/sorted data.");
        System.out.println("Binary search is more suitable for large, sorted product lists in an e-commerce platform.");
    }
}
