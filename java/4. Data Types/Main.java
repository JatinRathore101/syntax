// Data Types - Java is statically typed; every variable has a fixed type
// Two categories: Primitive (8 types) and Reference (String, arrays, objects)

public class Main {
    public static void main(String[] args) {
        // --- Primitive Types ---

        // Integer types (whole numbers)
        byte  b = 100;            // 8-bit,  range: -128 to 127
        short s = 30000;          // 16-bit, range: -32,768 to 32,767
        int   i = 2_000_000;      // 32-bit, most commonly used integer type
        long  l = 9_000_000_000L; // 64-bit, needs 'L' suffix

        // Floating-point types (decimal numbers)
        float  f = 3.14f;         // 32-bit, needs 'f' suffix
        double d = 3.141592653;   // 64-bit, default for decimals

        // Other primitives
        boolean flag = true;      // true or false only
        char    c    = 'Z';       // single 16-bit Unicode character

        System.out.println("byte:    " + b);
        System.out.println("short:   " + s);
        System.out.println("int:     " + i);
        System.out.println("long:    " + l);
        System.out.println("float:   " + f);
        System.out.println("double:  " + d);
        System.out.println("boolean: " + flag);
        System.out.println("char:    " + c);

        // Min/Max values of each type
        System.out.println("int max: " + Integer.MAX_VALUE);
        System.out.println("int min: " + Integer.MIN_VALUE);

        // --- Reference Type ---
        // String is a class, not a primitive
        String text = "Hello, Java!";
        System.out.println("String: " + text);
    }
}
