// Literals - Fixed, hard-coded values written directly in source code

public class Main {
    public static void main(String[] args) {
        // Integer literals — different bases
        int decimal = 255;
        int hex     = 0xFF;          // Hexadecimal (prefix 0x)
        int octal   = 0377;          // Octal       (prefix 0)
        int binary  = 0b11111111;    // Binary      (prefix 0b, Java 7+)
        System.out.println(decimal + " " + hex + " " + octal + " " + binary); // all 255

        // Underscores for readability (Java 7+)
        int million    = 1_000_000;
        long phone     = 98_765_43210L;
        System.out.println("Million: " + million + ", Phone: " + phone);

        // Floating-point literals
        double d   = 3.14;
        float  f   = 3.14f;   // 'f' suffix required for float
        double sci = 1.5e3;   // scientific notation: 1.5 × 10³ = 1500.0
        System.out.println("double: " + d + ", float: " + f + ", sci: " + sci);

        // Character literals (single quotes)
        char letter  = 'A';
        char tab     = '\t';   // escape: tab
        char newline = '\n';   // escape: newline
        char unicode = 'A'; // Unicode for 'A'
        System.out.println("char: " + letter + ", unicode: " + unicode);

        // String literals (double quotes)
        String greeting = "Hello, World!";
        String escaped  = "She said \"hi\" and left.";
        System.out.println(greeting);
        System.out.println(escaped);

        // Boolean literals
        boolean yes = true;
        boolean no  = false;
        System.out.println("yes=" + yes + ", no=" + no);

        // Null literal — for reference types only
        String empty = null;
        System.out.println("null: " + empty);
    }
}
