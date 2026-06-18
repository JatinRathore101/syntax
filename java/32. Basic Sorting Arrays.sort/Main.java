// Basic Sorting with Arrays.sort — Java's built-in sort (dual-pivot quicksort)
// Also covers Collections.sort for lists and custom sort with Comparator

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Sort int array — ascending by default
        int[] nums = {5, 3, 8, 1, 9, 2, 7};
        Arrays.sort(nums);
        System.out.println("Sorted int[]:  " + Arrays.toString(nums));

        // Sort a range [fromIndex, toIndex)
        int[] partial = {5, 3, 8, 1, 9, 2, 7};
        Arrays.sort(partial, 2, 6); // sort only indices 2..5
        System.out.println("Partial sort:  " + Arrays.toString(partial));

        // Sort String array — lexicographic (alphabetical)
        String[] fruits = {"Banana", "Apple", "Cherry", "Mango"};
        Arrays.sort(fruits);
        System.out.println("Sorted String[]: " + Arrays.toString(fruits));

        // Sort Integer list — Collections.sort works on List<T>
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        Collections.sort(list);
        System.out.println("Sorted List:   " + list);

        // Descending order using Comparator
        list.sort(Collections.reverseOrder());
        System.out.println("Descending:    " + list);

        // Sort String array descending
        Arrays.sort(fruits, Collections.reverseOrder());
        System.out.println("Fruits desc:   " + Arrays.toString(fruits));

        // Sort array of objects with Comparator (sort by string length)
        String[] words = {"banana", "fig", "kiwi", "apple", "pear"};
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("By length:     " + Arrays.toString(words));
    }
}
