// Methods — Reusable blocks of code that perform a specific task
// Syntax: returnType methodName(parameters) { body }

public class Main {

    // void method — does something, returns nothing
    static void greet() {
        System.out.println("Hello from a method!");
    }

    // Method with parameters — caller passes data in
    static void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Method with return value — sends a result back to the caller
    static int add(int a, int b) {
        return a + b;
    }

    // Method with multiple params, returns double
    static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    // Boolean method — returns true/false
    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // Method calling another method
    static void printEvenOdd(int n) {
        System.out.println(n + " is " + (isEven(n) ? "even" : "odd"));
    }

    // Recursive method — calls itself
    static int factorial(int n) {
        if (n <= 1) return 1;          // base case
        return n * factorial(n - 1);   // recursive case
    }

    public static void main(String[] args) {
        greet();
        greetUser("Alice");

        int sum = add(3, 7);
        System.out.println("3 + 7 = " + sum);

        System.out.printf("Circle area r=5: %.2f%n", circleArea(5));

        printEvenOdd(4);
        printEvenOdd(9);

        System.out.println("5! = " + factorial(5)); // 120
    }
}
