// List Interface — An ordered collection that allows duplicate elements
// Elements are accessed by index (0-based)
// Common implementations: ArrayList (fast random access), LinkedList (fast insert/delete)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Declare as List interface — program to the interface, not implementation
        List<String> fruits = new ArrayList<>();

        // add — append to end
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Banana"); // duplicates are allowed
        System.out.println("List: " + fruits);

        // add at specific index
        fruits.add(1, "Avocado");
        System.out.println("After insert at 1: " + fruits);

        // get — access by index
        System.out.println("Index 0: " + fruits.get(0));

        // set — replace at index
        fruits.set(0, "Apricot");
        System.out.println("After set(0): " + fruits);

        // remove by index or value
        fruits.remove(2);
        fruits.remove("Banana"); // removes first occurrence
        System.out.println("After removes: " + fruits);

        // size, contains, indexOf
        System.out.println("Size: "     + fruits.size());
        System.out.println("Contains Cherry: " + fruits.contains("Cherry"));
        System.out.println("indexOf Avocado: " + fruits.indexOf("Avocado"));

        // Iterate
        for (String f : fruits) System.out.print(f + " ");
        System.out.println();

        // Sort
        Collections.sort(fruits);
        System.out.println("Sorted: " + fruits);

        // subList — view of a portion
        System.out.println("Sub [0,2): " + fruits.subList(0, 2));

        // List.of() — immutable list (Java 9+)
        List<Integer> immutable = List.of(1, 2, 3, 4, 5);
        System.out.println("Immutable: " + immutable);
    }
}
