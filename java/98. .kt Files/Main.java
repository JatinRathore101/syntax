// .kt Files — Kotlin source files
// Kotlin is a modern JVM language created by JetBrains (2011), official Android language (2017)
// Fully interoperable with Java — Kotlin code can call Java code and vice versa
// Compiles to the same .class bytecode that runs on the JVM

// This file shows Java code alongside Kotlin equivalents as comments for comparison

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Kotlin (.kt files) vs Java ===");
        System.out.println();
        System.out.println("Kotlin advantages over Java:");
        System.out.println("  - Null safety built-in (no NullPointerException by default)");
        System.out.println("  - Concise syntax (less boilerplate)");
        System.out.println("  - Data classes (auto equals/hashCode/toString)");
        System.out.println("  - Extension functions");
        System.out.println("  - Coroutines for async code");
        System.out.println("  - Smart casts");
        System.out.println();

        // Java variable declaration
        String name = "Alice";
        int    age  = 30;
        System.out.println("Java:   String name = \"Alice\";  int age = 30;");
        System.out.println("Kotlin: val name = \"Alice\"     var age = 30");

        // Java null check
        String nullable = null;
        if (nullable != null) {
            System.out.println(nullable.length());
        }
        System.out.println("Java null check: if (s != null) s.length()");
        System.out.println("Kotlin null safe: s?.length  (returns null if s is null)");

        System.out.println();
        System.out.println("Both compile to JVM bytecode and run on the same JVM.");
        System.out.println("See Main.kt in this folder for Kotlin examples.");
    }
}
