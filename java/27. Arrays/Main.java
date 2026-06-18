// Arrays — Fixed-size, ordered collection of elements of the same type
// Index starts at 0; length is fixed after creation

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Declaration and initialization
        int[] nums = {10, 20, 30, 40, 50};

        // Access by index
        System.out.println("First: " + nums[0]);   // 10
        System.out.println("Last:  " + nums[nums.length - 1]); // 50

        // Modify an element
        nums[2] = 99;

        // Iterate with for-each
        System.out.print("Array: ");
        for (int n : nums) System.out.print(n + " ");
        System.out.println();

        // Declare first, fill later
        String[] fruits = new String[3];
        fruits[0] = "Apple";
        fruits[1] = "Banana";
        fruits[2] = "Cherry";
        System.out.println(Arrays.toString(fruits));

        // 2D array (matrix)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("matrix[1][2] = " + matrix[1][2]); // 6
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        // Useful Arrays methods
        int[] data = {5, 3, 8, 1, 9, 2};
        Arrays.sort(data);
        System.out.println("Sorted: " + Arrays.toString(data));

        int[] copy = Arrays.copyOf(data, 4);     // first 4 elements
        System.out.println("Copy:   " + Arrays.toString(copy));

        System.out.println("Search 8: index " + Arrays.binarySearch(data, 8));
    }
}
