// HashSet — Hash table based implementation of Set
// No duplicate elements; no guaranteed order
// O(1) average for add, remove, contains — very fast
// Requires objects to correctly implement hashCode() and equals()

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();

        // add — returns true if added, false if duplicate
        System.out.println(cities.add("Delhi"));   // true
        System.out.println(cities.add("Mumbai"));  // true
        System.out.println(cities.add("Delhi"));   // false — duplicate
        cities.add("Bangalore");
        cities.add("Chennai");

        System.out.println("Cities: " + cities);           // order not guaranteed
        System.out.println("Size: "  + cities.size());     // 4

        // contains — O(1)
        System.out.println("Has Delhi:   " + cities.contains("Delhi"));   // true
        System.out.println("Has Kolkata: " + cities.contains("Kolkata")); // false

        // remove
        cities.remove("Chennai");
        System.out.println("After remove: " + cities);

        // iterate (no guaranteed order)
        for (String city : cities) System.out.print(city + " ");
        System.out.println();

        // Practical: remove duplicates from a list
        List<Integer> withDups = Arrays.asList(1, 3, 2, 1, 4, 3, 5, 2);
        HashSet<Integer> noDups = new HashSet<>(withDups);
        System.out.println("No duplicates: " + noDups);

        // Convert back to sorted List
        List<Integer> sorted = new ArrayList<>(noDups);
        Collections.sort(sorted);
        System.out.println("Sorted unique: " + sorted);

        // Check membership quickly (faster than List.contains)
        HashSet<String> stopWords = new HashSet<>(Arrays.asList("the","a","an","in","on"));
        String[] words = {"the", "cat", "sat", "on", "a", "mat"};
        for (String w : words) {
            if (!stopWords.contains(w)) System.out.print(w + " ");
        }
        System.out.println();
    }
}
