// Functional Interfaces — An interface with exactly ONE abstract method
// @FunctionalInterface annotation enforces this at compile time
// They are the basis for Lambda expressions (Java 8+)
// Common built-in ones: Runnable, Comparator, Predicate, Function, Consumer, Supplier

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

// Custom functional interface
@FunctionalInterface
interface Greeter {
    String greet(String name); // exactly ONE abstract method
    // default and static methods are allowed alongside
}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        // Implement using lambda expression
        Greeter formal   = name -> "Good day, " + name + ".";
        Greeter informal = name -> "Hey " + name + "!";

        System.out.println(formal.greet("Alice"));
        System.out.println(informal.greet("Bob"));

        MathOperation add      = (a, b) -> a + b;
        MathOperation multiply = (a, b) -> a * b;
        System.out.println("Add:      " + add.operate(3, 4));
        System.out.println("Multiply: " + multiply.operate(3, 4));

        // Built-in functional interfaces from java.util.function
        Predicate<Integer> isEven    = n -> n % 2 == 0;
        Function<String, Integer> len = s -> s.length();
        Consumer<String> printer      = s -> System.out.println(">> " + s);
        Supplier<Double>  random      = () -> Math.random();

        System.out.println("isEven(4): "     + isEven.test(4));
        System.out.println("length(hello): " + len.apply("hello"));
        printer.accept("Functional interface!");
        System.out.printf("Random: %.4f%n",   random.get());
    }
}
