// Java Collection Framework — Unified architecture for storing and manipulating groups of objects
//
// Key interfaces and their common implementations:
//
//  Collection
//  ├── List    → ordered, duplicates allowed  → ArrayList, LinkedList
//  ├── Set     → unordered, no duplicates     → HashSet, TreeSet, LinkedHashSet
//  └── Queue   → FIFO ordering                → LinkedList, PriorityQueue
//
//  Map (not Collection) → key-value pairs     → HashMap, TreeMap, LinkedHashMap

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // List — ordered, index-based, duplicates OK
        List<String> list = new ArrayList<>();
        list.add("Banana"); list.add("Apple"); list.add("Banana");
        System.out.println("List: " + list);     // [Banana, Apple, Banana]

        // Set — no duplicates, unordered (HashSet)
        Set<String> set = new HashSet<>();
        set.add("Banana"); set.add("Apple"); set.add("Banana");
        System.out.println("Set: " + set);       // [Apple, Banana] (no duplicate)

        // Queue — FIFO
        Queue<String> queue = new LinkedList<>();
        queue.offer("first"); queue.offer("second"); queue.offer("third");
        System.out.println("Queue poll: " + queue.poll()); // "first"

        // Map — key-value pairs, unique keys
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 90); map.put("Bob", 85); map.put("Alice", 95); // overwrites
        System.out.println("Map: " + map);
        System.out.println("Alice score: " + map.get("Alice")); // 95

        // Iterate a Map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " → " + entry.getValue());
        }

        // Collections utility methods
        List<Integer> nums = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9));
        System.out.println("Max: "  + Collections.max(nums));
        System.out.println("Min: "  + Collections.min(nums));
        Collections.sort(nums);
        System.out.println("Sorted: " + nums);
    }
}
