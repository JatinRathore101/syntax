// forEach — Iterate over collections/streams using a Consumer lambda
// Available on Iterable (List, Set), Map, and Stream
// Cleaner alternative to for loops when no index or modification is needed

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Carol", "Dave");

        // Traditional for-each loop
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        // forEach with lambda — same thing, more concise
        names.forEach(name -> System.out.print(name + " "));
        System.out.println();

        // forEach with method reference — even cleaner when just printing
        names.forEach(System.out::println);

        System.out.println();

        // forEach on a Set
        Set<Integer> numbers = new LinkedHashSet<>(Arrays.asList(10, 20, 30, 40));
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // forEach on a Map — receives key and value
        Map<String, Integer> scores = new LinkedHashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob",   85);
        scores.put("Carol", 92);

        scores.forEach((name, score) ->
            System.out.println(name + " scored " + score));

        System.out.println();

        // forEach on a Stream with transformation
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
        fruits.stream()
              .map(String::toUpperCase)
              .forEach(System.out::println);
    }
}
