// Type Conversion (Casting) - Converting a value from one type to another
// Widening: smaller → larger type (automatic)
// Narrowing: larger → smaller type (manual, may lose data)

public class Main {
    public static void main(String[] args) {
        // --- Widening (Implicit) Conversion ---
        // Java does this automatically — no data loss
        int    intVal    = 100;
        long   longVal   = intVal;    // int → long  (automatic)
        double doubleVal = longVal;   // long → double (automatic)
        System.out.println("int: " + intVal + " → long: " + longVal + " → double: " + doubleVal);
        // Chain: byte → short → int → long → float → double

        // --- Narrowing (Explicit) Conversion ---
        // Must cast manually; truncates or loses data
        double pi    = 3.99;
        int    piInt = (int) pi;    // decimal is truncated (NOT rounded) → 3
        System.out.println("double: " + pi + " → int: " + piInt);

        long bigNum  = 123456789012L;
        int  smaller = (int) bigNum;  // high-order bits lost
        System.out.println("long: " + bigNum + " → int (overflow): " + smaller);

        // --- String ↔ Numeric ---
        int    num  = 42;
        String str  = String.valueOf(num);    // int → String
        int    back = Integer.parseInt(str);  // String → int
        System.out.println("int→String: \"" + str + "\", String→int: " + (back + 1));

        double dbl     = Double.parseDouble("3.14");  // String → double
        String dblStr  = String.valueOf(dbl);         // double → String
        System.out.println("Parsed double: " + dbl + ", back to String: " + dblStr);

        // --- char ↔ int ---
        char ch   = 'A';
        int  code = ch;              // char → int (Unicode value, automatic)
        char next = (char)(code + 1); // int → char (explicit)
        System.out.println("'A' = " + code + ", next char = " + next);
    }
}
