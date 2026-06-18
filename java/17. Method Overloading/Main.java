// Method Overloading — Same method name, different parameter list
// The compiler picks the correct version based on argument types and count
// This is compile-time (static) polymorphism

public class Main {

    // Three overloaded versions of add()
    static int    add(int a, int b)          { return a + b; }
    static double add(double a, double b)    { return a + b; }
    static int    add(int a, int b, int c)   { return a + b + c; }
    static String add(String a, String b)    { return a + b; } // concatenation

    // Overloaded print — mirrors how System.out.println works internally
    static void display(int n)     { System.out.println("int: "    + n); }
    static void display(double d)  { System.out.println("double: " + d); }
    static void display(String s)  { System.out.println("String: " + s); }
    static void display(boolean b) { System.out.println("boolean: "+ b); }

    public static void main(String[] args) {
        // Compiler automatically selects the matching version
        System.out.println(add(2, 3));          // int + int
        System.out.println(add(2.5, 3.5));      // double + double
        System.out.println(add(1, 2, 3));        // 3 ints
        System.out.println(add("Hello, ", "World!")); // String concat

        display(42);
        display(3.14);
        display("hello");
        display(true);

        // NOTE: Overloading is resolved at COMPILE TIME
        // You cannot overload by return type alone — it must differ in parameters
    }
}
