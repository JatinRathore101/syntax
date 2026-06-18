// Map Interface — Stores key-value pairs; keys are unique
// Implementations: HashMap (fast, no order), TreeMap (sorted keys),
//                  LinkedHashMap (insertion order)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // HashMap — most common, O(1) operations, no order
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob",   85);
        scores.put("Carol", 92);
        scores.put("Alice", 95);  // overwrites existing key "Alice"
        System.out.println("Scores: " + scores);

        // get — returns null if key not found
        System.out.println("Alice: " + scores.get("Alice")); // 95
        System.out.println("Dave:  " + scores.get("Dave"));  // null

        // getOrDefault — safe fallback
        System.out.println("Dave (default): " + scores.getOrDefault("Dave", 0));

        // containsKey / containsValue
        System.out.println("Has Alice: " + scores.containsKey("Alice"));
        System.out.println("Has score 92: " + scores.containsValue(92));

        // Iterate over entries
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("  " + entry.getKey() + " → " + entry.getValue());
        }

        // Keys and values
        System.out.println("Keys:   " + scores.keySet());
        System.out.println("Values: " + scores.values());

        // TreeMap — sorted by key
        Map<String, Integer> sorted = new TreeMap<>(scores);
        System.out.println("TreeMap (sorted keys): " + sorted);

        // putIfAbsent — only adds if key doesn't exist
        scores.putIfAbsent("Dave", 88);
        System.out.println("After putIfAbsent Dave: " + scores.get("Dave")); // 88

        // Word frequency counter
        String text = "apple banana apple cherry banana apple";
        Map<String, Integer> freq = new HashMap<>();
        for (String word : text.split(" ")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word frequency: " + freq);
    }
}
