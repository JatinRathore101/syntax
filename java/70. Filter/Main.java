// Stream.filter() — Keeps only elements that match a Predicate condition
// Returns a new stream; does not modify the original collection

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers
        List<Integer> evens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Evens: " + evens);

        // Filter numbers greater than 5
        List<Integer> big = numbers.stream()
            .filter(n -> n > 5)
            .collect(Collectors.toList());
        System.out.println("Greater than 5: " + big);

        // Chain multiple filters
        List<Integer> evenAndBig = numbers.stream()
            .filter(n -> n % 2 == 0)
            .filter(n -> n > 4)
            .collect(Collectors.toList());
        System.out.println("Even and > 4: " + evenAndBig);

        // Filter strings
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Brian");
        List<String> aNames = names.stream()
            .filter(name -> name.startsWith("A"))
            .collect(Collectors.toList());
        System.out.println("Names starting with A: " + aNames);

        // Filter objects
        List<String> longNames = names.stream()
            .filter(name -> name.length() > 4)
            .collect(Collectors.toList());
        System.out.println("Long names (>4 chars): " + longNames);

        // Filter non-null / non-empty
        List<String> withNulls = Arrays.asList("hello", null, "world", "", "java");
        List<String> clean = withNulls.stream()
            .filter(s -> s != null && !s.isEmpty())
            .collect(Collectors.toList());
        System.out.println("Non-null/empty: " + clean);

        // Count matching elements
        long count = numbers.stream().filter(n -> n % 3 == 0).count();
        System.out.println("Divisible by 3: " + count);
    }
}
