// Stream.reduce() — Combines all elements into a single result
// Signature: reduce(identity, BinaryOperator)
//            reduce(BinaryOperator) → returns Optional
// Think of it as: accumulator = identity; for each element: accumulator = op(accumulator, element)

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sum — identity 0, add each element
        int sum = numbers.stream()
            .reduce(0, (acc, n) -> acc + n);
        System.out.println("Sum: " + sum); // 15

        // Same with method reference
        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum (ref): " + sum2);

        // Product
        int product = numbers.stream()
            .reduce(1, (acc, n) -> acc * n);
        System.out.println("Product: " + product); // 120

        // Max (manually, without using .max())
        int max = numbers.stream()
            .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println("Max: " + max);

        // Without identity — returns Optional (in case stream is empty)
        Optional<Integer> optSum = numbers.stream()
            .reduce((a, b) -> a + b);
        optSum.ifPresent(s -> System.out.println("Optional sum: " + s));

        // String concatenation
        List<String> words = Arrays.asList("Java", "is", "fun");
        String sentence = words.stream()
            .reduce("", (acc, word) -> acc.isEmpty() ? word : acc + " " + word);
        System.out.println("Sentence: " + sentence);

        // Counting elements (to understand reduce, not the best way)
        long count = numbers.stream()
            .reduce(0, (acc, n) -> acc + 1, Integer::sum); // parallel-safe version
        System.out.println("Count: " + count);
    }
}
