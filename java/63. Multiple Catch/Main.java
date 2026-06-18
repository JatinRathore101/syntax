// Multiple Catch — Handle different exception types from a single try block
// Catch blocks are checked TOP TO BOTTOM — put specific types before general ones
// Java 7+: multi-catch with | to handle multiple types in one block

public class Main {
    static void riskyOperation(int choice) {
        switch (choice) {
            case 1 -> throw new ArithmeticException("Division by zero");
            case 2 -> throw new NullPointerException("Null reference");
            case 3 -> throw new ArrayIndexOutOfBoundsException("Index 99");
            case 4 -> throw new NumberFormatException("Bad number: 'abc'");
        }
    }

    public static void main(String[] args) {
        // Multiple catch blocks — specific first, general last
        for (int i = 1; i <= 5; i++) {
            try {
                riskyOperation(i);
                System.out.println("choice=" + i + " succeeded");
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("NullPointer: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndex: " + e.getMessage());
            } catch (Exception e) {
                // General catch — catches anything not caught above
                System.out.println("General Exception (" +
                                   e.getClass().getSimpleName() + "): " + e.getMessage());
            }
        }

        System.out.println();

        // Multi-catch (Java 7+) — same handler for multiple exception types
        for (int i = 1; i <= 4; i++) {
            try {
                riskyOperation(i);
            } catch (ArithmeticException | NullPointerException e) {
                System.out.println("Math or Null: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Array or Number: " + e.getMessage());
            }
        }
    }
}
