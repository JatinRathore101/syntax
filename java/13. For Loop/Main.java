// For Loop — Repeat a block a known number of times
// Syntax: for (init; condition; update) { body }

public class Main {
    public static void main(String[] args) {
        // Basic for loop: 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Countdown
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Sum of 1 to 10
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Sum 1-10: " + sum); // 55

        // Nested loops: multiplication table
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        // Enhanced for-each — iterate over arrays/collections
        int[] numbers = {10, 20, 30, 40, 50};
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();

        // break — exit the loop early
        for (int i = 1; i <= 10; i++) {
            if (i == 6) break;
            System.out.print(i + " ");
        }
        System.out.println("← stopped at 6");

        // continue — skip current iteration
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue; // skip even numbers
            System.out.print(i + " ");
        }
        System.out.println("← odd only");
    }
}
