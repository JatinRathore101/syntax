// Arithmetic Operators - Perform basic mathematical operations

public class Main {
    public static void main(String[] args) {
        int a = 15, b = 4;

        System.out.println("a + b = " + (a + b));  // Addition:       19
        System.out.println("a - b = " + (a - b));  // Subtraction:    11
        System.out.println("a * b = " + (a * b));  // Multiplication: 60
        System.out.println("a / b = " + (a / b));  // Integer division: 3 (truncates)
        System.out.println("a % b = " + (a % b));  // Modulo (remainder): 3

        // Float division — cast one operand to double
        System.out.println("a / b (double) = " + (double) a / b); // 3.75

        // --- Increment & Decrement ---
        int x = 5;
        System.out.println("x++  = " + x++); // post: prints 5, then x=6
        System.out.println("++x  = " + ++x); // pre:  x=7, then prints 7
        System.out.println("x--  = " + x--); // post: prints 7, then x=6
        System.out.println("--x  = " + --x); // pre:  x=5, then prints 5

        // --- Compound Assignment ---
        int n = 10;
        n += 3;  System.out.println("n += 3  → " + n);  // 13
        n -= 2;  System.out.println("n -= 2  → " + n);  // 11
        n *= 2;  System.out.println("n *= 2  → " + n);  // 22
        n /= 4;  System.out.println("n /= 4  → " + n);  // 5
        n %= 3;  System.out.println("n %= 3  → " + n);  // 2

        // Modulo use-case: check even/odd
        System.out.println("7 is " + (7 % 2 == 0 ? "even" : "odd"));
    }
}
