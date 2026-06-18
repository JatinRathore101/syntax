// Relational Operators - Compare two values; always return boolean (true/false)

public class Main {
    public static void main(String[] args) {
        int a = 10, b = 20;

        System.out.println("a == b : " + (a == b)); // Equal to
        System.out.println("a != b : " + (a != b)); // Not equal to
        System.out.println("a <  b : " + (a <  b)); // Less than
        System.out.println("a >  b : " + (a >  b)); // Greater than
        System.out.println("a <= b : " + (a <= b)); // Less than or equal
        System.out.println("a >= b : " + (a >= b)); // Greater than or equal

        // Practical use in conditions
        int score = 85;
        if (score >= 90)      System.out.println("Grade: A");
        else if (score >= 75) System.out.println("Grade: B");
        else                  System.out.println("Grade: C");

        // IMPORTANT: == on objects compares REFERENCE (memory address), not content
        // Use .equals() to compare String content
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println("s1 == s2      : " + (s1 == s2));    // false (different objects)
        System.out.println("s1.equals(s2) : " + s1.equals(s2)); // true  (same content)

        // String literals from the pool ARE the same reference
        String s3 = "java";
        String s4 = "java";
        System.out.println("s3 == s4 (pool): " + (s3 == s4));   // true (same pool object)
    }
}
