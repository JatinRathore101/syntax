// While Loop — Repeats while a condition is true
// Condition is checked BEFORE each iteration
// Best when the number of iterations is not known in advance

public class Main {
    public static void main(String[] args) {
        // Basic while loop
        int i = 1;
        while (i <= 5) {
            System.out.print(i + " ");
            i++; // always update to prevent infinite loop
        }
        System.out.println();

        // Sum digits of a number
        int number = 12345;
        int sum    = 0;
        int temp   = number;
        while (temp != 0) {
            sum  += temp % 10; // extract last digit
            temp /= 10;        // remove last digit
        }
        System.out.println("Digit sum of " + number + " = " + sum); // 15

        // Reverse a number
        int n        = 987;
        int reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        System.out.println("Reversed: " + reversed); // 789

        // Find first power of 2 greater than 1000
        int power = 1;
        while (power <= 1000) {
            power *= 2;
        }
        System.out.println("First power of 2 > 1000: " + power); // 1024

        // while (true) with break — useful when exit condition is complex
        int count = 0;
        while (true) {
            count++;
            if (count == 5) {
                System.out.println("Exited at count = " + count);
                break;
            }
        }
    }
}
