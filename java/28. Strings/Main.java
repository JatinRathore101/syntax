// Strings — Sequence of characters; immutable reference type in Java
// String class is in java.lang (no import needed)

public class Main {
    public static void main(String[] args) {
        String s = "Hello, Java!";

        // Length and character access
        System.out.println("Length:    " + s.length());       // 12
        System.out.println("charAt(7): " + s.charAt(7));      // J

        // Case conversion
        System.out.println("Upper: " + s.toUpperCase());
        System.out.println("Lower: " + s.toLowerCase());

        // Searching
        System.out.println("indexOf('J'):    " + s.indexOf('J'));   // 7
        System.out.println("contains('Java'):" + s.contains("Java")); // true
        System.out.println("startsWith('He'):" + s.startsWith("He")); // true
        System.out.println("endsWith('!')   :" + s.endsWith("!"));    // true

        // Substring
        System.out.println("substring(7):    " + s.substring(7));      // Java!
        System.out.println("substring(7,11): " + s.substring(7, 11));  // Java

        // Trim and replace
        String padded  = "  hello  ";
        System.out.println("trim: '" + padded.trim() + "'");
        System.out.println("replace: " + s.replace("Java", "World"));

        // Split
        String csv = "apple,banana,cherry";
        String[] parts = csv.split(",");
        for (String p : parts) System.out.println("  " + p);

        // String comparison — always use .equals(), not ==
        String a = new String("hello");
        String b = new String("hello");
        System.out.println("== : " + (a == b));          // false
        System.out.println("equals: " + a.equals(b));    // true
        System.out.println("equalsIgnoreCase: " + a.equalsIgnoreCase("HELLO")); // true

        // String.format / String.valueOf
        int age = 25;
        String msg = String.format("Age is %d", age);
        System.out.println(msg);
    }
}
