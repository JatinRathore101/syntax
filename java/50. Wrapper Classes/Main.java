// Wrapper Classes — Object versions of primitive types
// Needed when generics/collections require objects (List<Integer>, not List<int>)
// int→Integer, double→Double, boolean→Boolean, char→Character, etc.
// Autoboxing: primitive → wrapper (automatic)
// Unboxing:   wrapper  → primitive (automatic)

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Autoboxing — int → Integer (compiler does this automatically)
        int      primitive = 42;
        Integer  wrapped   = primitive; // autoboxing

        // Unboxing — Integer → int
        int back = wrapped;            // unboxing

        System.out.println("Primitive: " + primitive);
        System.out.println("Wrapped:   " + wrapped);
        System.out.println("Unboxed:   " + back);

        // Collections need wrapper types (can't use int in ArrayList)
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);  // autoboxed to Integer
        list.add(20);
        list.add(30);
        int sum = 0;
        for (int n : list) sum += n; // each element auto-unboxed
        System.out.println("Sum: " + sum);

        // Useful static methods on wrapper classes
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("parseInt('123'):   " + Integer.parseInt("123"));
        System.out.println("toBinaryString(10):" + Integer.toBinaryString(10));
        System.out.println("Double.parseDouble:" + Double.parseDouble("3.14"));
        System.out.println("Boolean.parseBoolean:" + Boolean.parseBoolean("true"));
        System.out.println("Character.isDigit('5'):" + Character.isDigit('5'));

        // == vs equals for Integer cache (-128 to 127 are cached)
        Integer a = 127, b = 127;
        System.out.println("127 == 127 (cached):  " + (a == b));    // true (same cache object)
        Integer c = 200, d = 200;
        System.out.println("200 == 200 (no cache):" + (c == d));    // false (different objects)
        System.out.println("200.equals(200):       " + c.equals(d));// true  (always use equals)
    }
}
