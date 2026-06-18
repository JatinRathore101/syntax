// toString() — Returns a human-readable String representation of an object
// Default (from Object): "ClassName@hexHashCode" — not useful
// Override it to print meaningful info — called automatically in println and "+" concat

class Book {
    String title;
    String author;
    double price;

    Book(String title, String author, double price) {
        this.title  = title;
        this.author = author;
        this.price  = price;
    }

    // Without override: "Book@6d06d69c" (useless)
    // With override: readable, useful output
    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', price=%.2f}",
                             title, author, price);
    }
}

class Coordinate {
    double lat, lon;
    Coordinate(double lat, double lon) { this.lat = lat; this.lon = lon; }

    @Override
    public String toString() {
        return String.format("(%.4f°, %.4f°)", lat, lon);
    }
}

public class Main {
    public static void main(String[] args) {
        Book b = new Book("Effective Java", "Joshua Bloch", 45.99);

        // toString() is called automatically in these contexts:
        System.out.println(b);                    // println calls toString()
        System.out.println("Book: " + b);         // string concatenation
        System.out.printf("Price: %s%n", b);      // printf with %s

        // Explicit call
        String s = b.toString();
        System.out.println(s);

        Coordinate loc = new Coordinate(37.7749, -122.4194);
        System.out.println("Location: " + loc);

        // Array toString() — Arrays.toString() is needed for arrays
        int[] nums = {1, 2, 3};
        System.out.println(nums);                       // [I@... (raw object ref)
        System.out.println(java.util.Arrays.toString(nums)); // [1, 2, 3] (useful)
    }
}
