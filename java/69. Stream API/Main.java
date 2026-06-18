// Stream API (Java 8+) — Process sequences of elements in a declarative, pipeline style
// Source → Intermediate operations (lazy) → Terminal operation (triggers processing)
// Streams do NOT store data; they process it on the fly

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6);

        // filter → map → collect
        List<Integer> result = numbers.stream()
            .filter(n  -> n > 4)           // keep only > 4
            .map(n     -> n * 2)           // double each
            .sorted()                       // sort ascending
            .collect(Collectors.toList()); // collect to List
        System.out.println("Result: " + result);

        // count
        long count = numbers.stream().filter(n -> n % 2 == 0).count();
        System.out.println("Even count: " + count);

        // sum, min, max, average via IntStream
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);
        OptionalDouble avg = numbers.stream().mapToInt(Integer::intValue).average();
        System.out.println("Avg: " + avg.getAsDouble());
        System.out.println("Max: " + numbers.stream().max(Integer::compareTo).get());
        System.out.println("Min: " + numbers.stream().min(Integer::compareTo).get());

        // String stream
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Anna", "Brian");
        String joined = names.stream()
            .filter(n -> n.startsWith("A"))
            .map(String::toUpperCase)
            .collect(Collectors.joining(", "));
        System.out.println("A-names: " + joined);

        // Stream.of — create stream from values
        Stream.of("X", "Y", "Z").forEach(System.out::print);
        System.out.println();

        // distinct — remove duplicates
        List<Integer> dup = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        System.out.println("Distinct: " + dup.stream().distinct().collect(Collectors.toList()));
    }
}
