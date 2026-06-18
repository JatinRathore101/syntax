// throw — Manually throw an exception from your code
// Use it to signal that an invalid/unexpected state has occurred
// You can throw any Throwable; typically throw Exception subclasses

public class Main {

    // Validate age — throw exception if invalid
    static void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
        System.out.println("Age set to: " + age);
    }

    // Divide — throw on divide by zero
    static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // Validate non-null
    static void greet(String name) {
        if (name == null) {
            throw new NullPointerException("name must not be null");
        }
        System.out.println("Hello, " + name + "!");
    }

    // Re-throw — catch an exception then throw a different (or same) one
    static void parseAndDouble(String input) {
        try {
            int n = Integer.parseInt(input);
            System.out.println("Doubled: " + (n * 2));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Expected a number, got: " + input, e);
        }
    }

    public static void main(String[] args) {
        setAge(25);

        try { setAge(200); } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println(divide(10, 2));
        try { divide(5, 0); } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        greet("Alice");
        try { greet(null); } catch (NullPointerException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        parseAndDouble("21");
        try { parseAndDouble("abc"); } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
