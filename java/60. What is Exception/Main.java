// Exception — An event that disrupts the normal flow of a program
// Exceptions are objects that carry info about what went wrong and where
// Java has a rich exception hierarchy rooted at Throwable

public class Main {
    public static void main(String[] args) {
        // Without exception handling — program crashes with a stack trace
        // Uncomment to see:
        // int result = 10 / 0; // ArithmeticException: / by zero

        // With exception handling — program recovers gracefully
        try {
            int result = 10 / 0;           // this line throws an exception
            System.out.println(result);    // this line is never reached
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage()); // "/ by zero"
        }

        // NullPointerException
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Null pointer caught.");
        }

        // ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds: " + e.getMessage());
        }

        // NumberFormatException
        try {
            int n = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Bad number format: " + e.getMessage());
        }

        System.out.println("Program continues normally after handling exceptions.");
    }
}
