// Exception Hierarchy
//
// Throwable
// ├── Error           — JVM-level problems; not meant to be caught
// │   ├── OutOfMemoryError
// │   ├── StackOverflowError
// │   └── ...
// └── Exception       — Application-level problems; should be handled
//     ├── RuntimeException  (Unchecked — compiler does NOT force you to handle)
//     │   ├── ArithmeticException
//     │   ├── NullPointerException
//     │   ├── ArrayIndexOutOfBoundsException
//     │   ├── ClassCastException
//     │   └── NumberFormatException
//     └── (Other)  (Checked — compiler FORCES you to handle with try-catch or throws)
//         ├── IOException
//         ├── SQLException
//         └── FileNotFoundException

import java.io.IOException;

public class Main {

    // Checked exception — must declare with 'throws' or catch it
    static void readFile(String path) throws IOException {
        throw new IOException("File not found: " + path);
    }

    // Unchecked exception — no declaration required
    static void divide(int a, int b) {
        System.out.println(a / b); // ArithmeticException if b == 0
    }

    public static void main(String[] args) {
        // Catching a checked exception
        try {
            readFile("data.txt");
        } catch (IOException e) {
            System.out.println("Checked: " + e.getMessage());
        }

        // Catching an unchecked exception
        try {
            divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Unchecked: " + e.getMessage());
        }

        // Catching by parent type — catches all subclasses
        try {
            String s = null;
            s.length();
        } catch (RuntimeException e) {
            System.out.println("RuntimeException: " + e.getClass().getSimpleName());
        }

        // Catching the root type — catch EVERYTHING (rarely a good idea)
        try {
            int[] arr = new int[Integer.MAX_VALUE]; // triggers OutOfMemoryError
        } catch (Throwable t) {
            System.out.println("Throwable: " + t.getClass().getSimpleName());
        }

        System.out.println("Done.");
    }
}
