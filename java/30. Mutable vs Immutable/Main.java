// Mutable vs Immutable
// Immutable: object state cannot change after creation → String, Integer, all primitives wrappers
// Mutable:   object state can change                   → StringBuilder, ArrayList, custom classes

public class Main {
    public static void main(String[] args) {
        // --- Immutable: String ---
        // Every "modification" creates a NEW String object in memory
        String s = "Hello";
        System.out.println("Before: " + System.identityHashCode(s)); // address 1
        s = s + " World"; // s now points to a brand-new String
        System.out.println("After:  " + System.identityHashCode(s)); // address 2 (different!)
        System.out.println(s);

        // Original string in the pool is untouched
        String original = "Java";
        String modified = original.concat(" Rocks");
        System.out.println("original: " + original);  // "Java"    — unchanged
        System.out.println("modified: " + modified);  // "Java Rocks"

        // --- Mutable: StringBuilder ---
        // All changes happen on the same object
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("SB before: " + System.identityHashCode(sb)); // address A
        sb.append(" World");
        System.out.println("SB after:  " + System.identityHashCode(sb)); // address A (same!)
        System.out.println(sb);

        // Performance comparison: String concat in loop = many garbage objects
        // StringBuilder in loop = one object modified in place
        long start = System.nanoTime();
        StringBuilder efficient = new StringBuilder();
        for (int i = 0; i < 10000; i++) efficient.append("x");
        long end = System.nanoTime();
        System.out.printf("StringBuilder loop: %,d ns%n", end - start);

        // Rule of thumb:
        // Use String for fixed text and small operations
        // Use StringBuilder for loops or many concatenations
    }
}
