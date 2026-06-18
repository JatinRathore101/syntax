// Set Interface — A collection with NO duplicate elements
// Does not guarantee order (HashSet), maintains insertion order (LinkedHashSet),
// or natural sorted order (TreeSet)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // HashSet — no order guarantee, fastest O(1) operations
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Cherry");
        hashSet.add("Apple");   // duplicate — silently ignored
        hashSet.add("Banana");  // duplicate — silently ignored
        System.out.println("HashSet (no order): " + hashSet);
        System.out.println("Size: " + hashSet.size()); // 3, not 5

        // LinkedHashSet — maintains INSERTION ORDER
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("Banana");
        linkedSet.add("Apple");
        linkedSet.add("Cherry");
        linkedSet.add("Apple"); // duplicate ignored
        System.out.println("LinkedHashSet (insertion order): " + linkedSet);

        // TreeSet — SORTED order (natural or via Comparator)
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5); treeSet.add(2); treeSet.add(8); treeSet.add(1); treeSet.add(8);
        System.out.println("TreeSet (sorted): " + treeSet); // [1, 2, 5, 8]

        // Set operations
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> b = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union:        " + new TreeSet<>(union));

        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("Intersection: " + new TreeSet<>(intersection));

        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.println("Difference:   " + new TreeSet<>(difference));

        // Practical use: find unique words in a sentence
        String sentence = "the cat sat on the mat the cat";
        Set<String> unique = new TreeSet<>(Arrays.asList(sentence.split(" ")));
        System.out.println("Unique words: " + unique);
    }
}
