// ArrayList — Resizable array implementation of the List interface
// Fast: O(1) random access by index
// Slow: O(n) insert/delete in the middle (shifts elements)
// Use when you read more than you write, and access by index

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        numbers.add(40);
        numbers.add(10); // duplicates allowed
        System.out.println("ArrayList: " + numbers);

        // Access
        System.out.println("get(1): " + numbers.get(1)); // 30

        // Update
        numbers.set(1, 99);
        System.out.println("After set(1,99): " + numbers);

        // Remove by index and by value
        numbers.remove(0);                      // remove index 0
        numbers.remove(Integer.valueOf(40));    // remove value 40 (avoid int overload)
        System.out.println("After removes: " + numbers);

        // Size
        System.out.println("Size: " + numbers.size());

        // Iteration
        for (int n : numbers) System.out.print(n + " ");
        System.out.println();

        // Sort
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);

        // Contains and indexOf
        System.out.println("Contains 99: " + numbers.contains(99));
        System.out.println("indexOf 99:  " + numbers.indexOf(99));

        // Convert to array
        Integer[] arr = numbers.toArray(new Integer[0]);
        System.out.println("As array: " + Arrays.toString(arr));

        // Create from existing collection
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        names.addAll(Arrays.asList("Dave", "Eve"));
        System.out.println("Names: " + names);
        names.removeIf(n -> n.length() > 4); // remove names longer than 4 chars
        System.out.println("Short names: " + names);
    }
}
