// Object Class — The root of Java's class hierarchy
// Every class implicitly extends Object
// Key methods: toString(), equals(), hashCode(), getClass(), clone(), wait(), notify()

import java.util.Objects;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name  = name;
        this.price = price;
    }

    // Override toString() — called automatically in print and string concat
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }

    // Override equals() — defines logical equality
    @Override
    public boolean equals(Object obj) {
        if (this == obj)             return true;   // same reference
        if (!(obj instanceof Product)) return false; // null or wrong type
        Product other = (Product) obj;
        return Double.compare(price, other.price) == 0
               && Objects.equals(name, other.name);
    }

    // Override hashCode() — must be consistent with equals()
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 999.99);
        Product p2 = new Product("Laptop", 999.99);
        Product p3 = new Product("Phone",  499.99);

        // toString() — auto-called by println
        System.out.println(p1);
        System.out.println("p1: " + p1);

        // equals() — logical equality
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false

        // hashCode()
        System.out.println("p1 hashCode: " + p1.hashCode());
        System.out.println("p2 hashCode: " + p2.hashCode()); // same as p1

        // getClass() — runtime type info
        System.out.println("Class: " + p1.getClass().getName());
        System.out.println("Simple: " + p1.getClass().getSimpleName());

        // Objects utility — null-safe operations
        System.out.println("isNull(null): " + Objects.isNull(null));
        System.out.println("toString(null): " + Objects.toString(null, "N/A"));
    }
}
