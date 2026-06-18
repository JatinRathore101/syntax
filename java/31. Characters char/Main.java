// Characters (char) — Stores a single character using Unicode (16-bit)
// Character class provides utility methods for working with chars

public class Main {
    public static void main(String[] args) {
        // char literal uses single quotes
        char letter  = 'A';
        char digit   = '9';
        char space   = ' ';
        char newline = '\n';  // escape sequence

        System.out.println("letter: " + letter);
        System.out.println("digit:  " + digit);

        // char is numeric — stores Unicode code point
        int code = letter;          // 'A' = 65
        char next = (char)(code + 1); // 66 = 'B'
        System.out.println("'A' code: " + code + ", next: " + next);

        // Arithmetic on chars
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();

        // Character class utility methods
        System.out.println("isLetter('A'):   " + Character.isLetter('A'));   // true
        System.out.println("isDigit('5'):    " + Character.isDigit('5'));    // true
        System.out.println("isWhitespace: "    + Character.isWhitespace(' '));// true
        System.out.println("isUpperCase('a'):  " + Character.isUpperCase('a'));// false
        System.out.println("toLowerCase('Z'):  " + Character.toLowerCase('Z'));// z
        System.out.println("toUpperCase('a'):  " + Character.toUpperCase('a'));// A

        // char → String
        char ch  = 'X';
        String s = String.valueOf(ch);   // "X"
        System.out.println("char to String: " + s);

        // String → char array
        String word = "Hello";
        char[] chars = word.toCharArray();
        for (char c : chars) System.out.print(c + "-");
        System.out.println();
    }
}
