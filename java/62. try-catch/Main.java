// try-catch-finally — Handle exceptions gracefully
// try:     code that might throw an exception
// catch:   handles the exception
// finally: ALWAYS runs (cleanup code) — even if exception was thrown or return called

public class Main {
    public static void main(String[] args) {
        // Basic try-catch
        try {
            int result = 10 / 0;          // throws ArithmeticException
            System.out.println(result);   // never reached
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage()); // "/ by zero"
        }

        // try-catch-finally
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);   // throws ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad index: " + e.getMessage());
        } finally {
            System.out.println("Finally always runs — good for cleanup.");
        }

        // finally runs even when there is NO exception
        try {
            System.out.println("No exception here");
        } catch (Exception e) {
            System.out.println("This won't print");
        } finally {
            System.out.println("Finally after successful try");
        }

        // Exception object methods
        try {
            String s = null;
            s.toUpperCase();
        } catch (NullPointerException e) {
            System.out.println("Type:    " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
            // e.printStackTrace(); // prints full stack trace to stderr
        }

        System.out.println("Program continues after handling exceptions.");
    }
}
