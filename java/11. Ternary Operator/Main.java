// Ternary Operator — Compact one-line alternative to if-else
// Syntax: condition ? valueIfTrue : valueIfFalse

public class Main {
    public static void main(String[] args) {
        int a = 10, b = 20;

        // Traditional if-else
        int max;
        if (a > b) { max = a; } else { max = b; }
        System.out.println("Max (if-else): " + max);

        // Same thing with ternary — shorter and readable for simple cases
        int maxTernary = (a > b) ? a : b;
        System.out.println("Max (ternary): " + maxTernary);

        // Assign a String based on condition
        int age = 17;
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Status: " + status);

        // Use directly in print
        System.out.println(a + " is " + (a % 2 == 0 ? "even" : "odd"));

        // Nested ternary — works but avoid deep nesting (hurts readability)
        int score = 85;
        String grade = (score >= 90) ? "A" : (score >= 75) ? "B" : "C";
        System.out.println("Grade: " + grade);

        // Ternary is an expression (returns a value), if-else is a statement
        // So ternary can be used inside method calls
        System.out.println("Pass/Fail: " + (score >= 50 ? "Pass" : "Fail"));
    }
}
