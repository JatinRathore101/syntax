// Stream.map() — Transforms each element using a Function
// Returns a new stream of transformed elements
// Does NOT modify the original; produces a new stream

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Square each number
        List<Integer> squares = numbers.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());
        System.out.println("Squares: " + squares);

        // String transformation
        List<String> names = Arrays.asList("alice", "bob", "charlie");

        List<String> upper = names.stream()
            .map(String::toUpperCase)  // method reference
            .collect(Collectors.toList());
        System.out.println("Upper: " + upper);

        // Extract a field from objects
        List<String> emails = Arrays.asList("alice@mail.com", "bob@mail.com", "carol@mail.com");
        List<String> users = emails.stream()
            .map(email -> email.split("@")[0]) // extract username
            .collect(Collectors.toList());
        System.out.println("Usernames: " + users);

        // Map to a different type: String → Integer (length)
        List<Integer> lengths = names.stream()
            .map(String::length)
            .collect(Collectors.toList());
        System.out.println("Lengths: " + lengths);

        // mapToInt — returns IntStream (useful for sum, avg, etc.)
        int totalLength = names.stream()
            .mapToInt(String::length)
            .sum();
        System.out.println("Total char count: " + totalLength);

        // Combine filter + map
        List<String> result = Arrays.asList("  hello  ", "  world  ", "  java  ")
            .stream()
            .map(String::trim)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Trimmed+Upper: " + result);
    }
}
