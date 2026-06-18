// equals() — Defines what "equal" means for objects
// Default Object.equals() compares REFERENCES (memory address)
// Override it to compare CONTENT (logical equality)

import java.util.Objects;

class Point {
    int x, y;

    Point(int x, int y) { this.x = x; this.y = y; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;               // same reference is always equal
        if (!(obj instanceof Point)) return false;  // null-safe type check
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y; // compare content
    }

    // Always override hashCode when you override equals (contract)
    @Override
    public int hashCode() { return Objects.hash(x, y); }

    @Override
    public String toString() { return "(" + x + ", " + y + ")"; }
}

public class Main {
    public static void main(String[] args) {
        // Without override — default equals() compares references
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);
        Point p3 = p1; // same reference

        System.out.println("p1 == p2         : " + (p1 == p2));       // false (different objects)
        System.out.println("p1 == p3         : " + (p1 == p3));       // true  (same reference)
        System.out.println("p1.equals(p2)    : " + p1.equals(p2));    // true  (same content, overridden)
        System.out.println("p1.equals(p3)    : " + p1.equals(p3));    // true

        // String.equals() — String already overrides equals() for content comparison
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println("String == :       " + (s1 == s2));         // false
        System.out.println("String equals:    " + s1.equals(s2));      // true

        // Null safety — equals() must handle null without throwing NullPointerException
        System.out.println("p1.equals(null)  : " + p1.equals(null));   // false (safe)

        // Objects.equals() — null-safe wrapper
        System.out.println("Objects.equals(null, null): " + Objects.equals(null, null)); // true
        System.out.println("Objects.equals(p1, null):   " + Objects.equals(p1, null));   // false
    }
}
