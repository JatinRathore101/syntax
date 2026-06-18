// HashMap — Hash table implementation of Map
// Keys are unique; values can repeat
// O(1) average for put, get, remove
// Does NOT guarantee insertion order (use LinkedHashMap if order matters)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> capitals = new HashMap<>();

        // put — add or update
        capitals.put("India",  "New Delhi");
        capitals.put("France", "Paris");
        capitals.put("Japan",  "Tokyo");
        capitals.put("India",  "New Delhi Updated"); // key exists → overwrites
        System.out.println("Capitals: " + capitals);

        // get
        System.out.println("France → " + capitals.get("France"));
        System.out.println("USA →    " + capitals.get("USA")); // null

        // getOrDefault
        System.out.println("USA (default): " + capitals.getOrDefault("USA", "Unknown"));

        // remove
        capitals.remove("France");
        System.out.println("After remove France: " + capitals);

        // size, isEmpty
        System.out.println("Size: " + capitals.size());
        System.out.println("Empty: " + capitals.isEmpty());

        // forEach (Java 8+)
        capitals.put("Germany", "Berlin");
        capitals.forEach((country, capital) ->
            System.out.println("  " + country + " → " + capital));

        // computeIfAbsent — create value if key doesn't exist
        capitals.computeIfAbsent("Spain", k -> "Madrid");
        System.out.println("Spain: " + capitals.get("Spain"));

        // merge — update value if key exists
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("apple", 5);
        inventory.merge("apple",  3, Integer::sum); // 5 + 3 = 8
        inventory.merge("banana", 4, Integer::sum); // new key → 4
        System.out.println("Inventory: " + inventory);

        // Iterate keys
        for (String key : capitals.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}
