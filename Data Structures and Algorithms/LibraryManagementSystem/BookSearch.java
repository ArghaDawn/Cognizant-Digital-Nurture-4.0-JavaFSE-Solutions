import java.util.*;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

public class BookSearch {
    public static Book linearSearchByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearchByTitle(List<Book> books, String title) {
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books.get(mid).title.compareToIgnoreCase(title);
            if (cmp == 0) return books.get(mid);
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Alchemist", "Paulo Coelho"));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(3, "1984", "George Orwell"));
        books.add(new Book(4, "Pride and Prejudice", "Jane Austen"));
        books.add(new Book(5, "Moby Dick", "Herman Melville"));

        String searchTitle = "1984";
        Book foundLinear = linearSearchByTitle(books, searchTitle);
        System.out.println("Linear Search Result: " + foundLinear);

        books.sort(Comparator.comparing(b -> b.title.toLowerCase()));
        Book foundBinary = binarySearchByTitle(books, searchTitle);
        System.out.println("Binary Search Result: " + foundBinary);

        System.out.println("\n--- Analysis ---");
        System.out.println("Linear Search: O(n) time complexity. Scans each element. Suitable for small or unsorted lists.");
        System.out.println("Binary Search: O(log n) time complexity. Requires sorted list. Much faster for large, sorted datasets.");
        System.out.println("Use linear search for small or unsorted data. Use binary search for large, sorted data for efficiency.");
    }
}
