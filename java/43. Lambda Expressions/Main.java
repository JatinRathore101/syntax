// Lambda Expressions — Anonymous (unnamed) functions; concise way to implement
// a Functional Interface inline without an anonymous class
// Syntax: (parameters) -> expression   or   (parameters) -> { statements }

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // No parameters
        Runnable r = () -> System.out.println("Lambda with no params");
        r.run();

        // One parameter (parentheses optional)
        java.util.function.Consumer<String> greet = name -> System.out.println("Hello, " + name);
        greet.accept("Alice");

        // Two parameters
        java.util.function.BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("3 + 4 = " + add.apply(3, 4));

        // Lambda with a block body (multiple statements)
        java.util.function.Consumer<String> verbose = message -> {
            String upper = message.toUpperCase();
            System.out.println("Message: " + upper);
        };
        verbose.accept("hello");

        // Lambda used to sort a list
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob", "Diana");
        names.sort((a, b) -> a.compareTo(b)); // ascending alphabetical
        System.out.println("Sorted: " + names);

        // Sort by length
        names.sort((a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("By length: " + names);

        // Lambda with Predicate — filter even numbers
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        nums.stream()
            .filter(n -> n % 2 == 0)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
