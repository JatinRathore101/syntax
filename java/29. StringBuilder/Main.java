// StringBuilder — A mutable sequence of characters
// Unlike String, modifying a StringBuilder does NOT create new objects
// Use it when you need to build or modify strings in a loop

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        // append — add to the end
        sb.append(", ").append("World").append("!");
        System.out.println(sb);                   // Hello, World!

        // insert — add at a position
        sb.insert(7, "Java ");
        System.out.println(sb);                   // Hello, Java World!

        // replace — replace a range [start, end)
        sb.replace(7, 11, "Beautiful");
        System.out.println(sb);                   // Hello, Beautiful World!

        // delete — remove a range
        sb.delete(7, 17);
        System.out.println(sb);                   // Hello, World!

        // reverse
        StringBuilder rev = new StringBuilder("abcde");
        System.out.println("Reversed: " + rev.reverse()); // edcba

        // length and charAt
        System.out.println("Length: " + sb.length());
        System.out.println("charAt(1): " + sb.charAt(1));

        // Convert back to String when done
        String result = sb.toString();
        System.out.println("Result: " + result);

        // Performance demo: String concatenation in a loop is slow (creates many objects)
        // StringBuilder is fast because it modifies in place
        StringBuilder fast = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            fast.append(i).append(" ");
        }
        System.out.println("Built: " + fast.toString().trim());
    }
}
