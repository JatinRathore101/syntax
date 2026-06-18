// Optional<T> (Java 8+) — A container that may or may not hold a value
// Replaces null returns; forces callers to handle the absent case
// Avoids NullPointerException when a value might not be present

import java.util.*;

public class Main {

    // Return Optional instead of null when a value might be absent
    static Optional<String> findUserById(int id) {
        Map<Integer, String> db = Map.of(1, "Alice", 2, "Bob", 3, "Carol");
        return Optional.ofNullable(db.get(id)); // null → empty Optional
    }

    public static void main(String[] args) {
        // Creating Optional
        Optional<String> present = Optional.of("hello");       // must be non-null
        Optional<String> empty   = Optional.empty();           // no value
        Optional<String> nullable= Optional.ofNullable(null);  // safe for null

        // isPresent / isEmpty
        System.out.println("present? " + present.isPresent()); // true
        System.out.println("empty?   " + empty.isEmpty());     // true

        // get() — retrieves value (throws if empty, so always check first)
        System.out.println("Value: " + present.get());

        // orElse — return default if absent
        System.out.println(empty.orElse("default value"));

        // orElseGet — compute default lazily
        System.out.println(empty.orElseGet(() -> "computed default"));

        // orElseThrow — throw exception if absent
        try {
            empty.orElseThrow(() -> new RuntimeException("Value required"));
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // ifPresent — run action only if value exists
        present.ifPresent(v -> System.out.println("Present: " + v));
        empty.ifPresent(v -> System.out.println("This won't print"));

        // map — transform value if present
        Optional<Integer> length = present.map(String::length);
        System.out.println("Length: " + length.orElse(0));

        // Practical: find user
        findUserById(1).ifPresent(u -> System.out.println("Found: " + u));
        String user = findUserById(99).orElse("Unknown User");
        System.out.println("User 99: " + user);
    }
}
