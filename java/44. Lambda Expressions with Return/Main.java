// Lambda Expressions with Return
// Single-expression lambda: return is implicit — no 'return' keyword needed
// Block lambda:             return must be explicit when using braces {}

import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;

@FunctionalInterface
interface Converter<T, R> {
    R convert(T input);
}

public class Main {
    public static void main(String[] args) {
        // Implicit return (single expression, no braces)
        Function<Integer, Integer> square  = n -> n * n;
        Function<Integer, Integer> cube    = n -> n * n * n;

        System.out.println("square(5) = " + square.apply(5));   // 25
        System.out.println("cube(3)   = " + cube.apply(3));     // 27

        // Explicit return (block body with braces)
        Function<Integer, String> classify = n -> {
            if (n > 0) return "positive";
            if (n < 0) return "negative";
            return "zero";
        };
        System.out.println(classify.apply(10));   // positive
        System.out.println(classify.apply(-5));   // negative
        System.out.println(classify.apply(0));    // zero

        // BiFunction: two inputs → one output
        BiFunction<Double, Double, Double> hypotenuse =
            (a, b) -> Math.sqrt(a * a + b * b);
        System.out.printf("Hypotenuse(3,4) = %.2f%n", hypotenuse.apply(3.0, 4.0));

        // Predicate: returns boolean
        Predicate<String> isEmail = s -> s.contains("@") && s.contains(".");
        System.out.println("isEmail(user@example.com): " + isEmail.test("user@example.com"));
        System.out.println("isEmail(notanemail):        " + isEmail.test("notanemail"));

        // Custom generic interface
        Converter<String, Integer> toLength = s -> s.length();
        Converter<String, String>  toUpper  = s -> s.toUpperCase();
        System.out.println("Length of 'hello': " + toLength.convert("hello"));
        System.out.println("Upper of 'hello':  " + toUpper.convert("hello"));
    }
}
