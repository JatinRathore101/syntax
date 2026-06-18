// Generics — Type-safe containers and methods using type parameters (<T>)
// Catch type errors at COMPILE time instead of runtime
// No casting required when retrieving elements

import java.util.*;

// Generic class — works with any type T
class Box<T> {
    private T value;

    Box(T value) { this.value = value; }

    T get()           { return value; }
    void set(T value) { this.value = value; }

    @Override
    public String toString() { return "Box[" + value + "]"; }
}

// Generic method — type parameter defined at the method level
class Pair<A, B> {
    A first;
    B second;

    Pair(A first, B second) {
        this.first = first; this.second = second;
    }

    @Override
    public String toString() { return "(" + first + ", " + second + ")"; }
}

public class Main {
    // Generic utility method — works with any type
    static <T> void printArray(T[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Bounded type parameter — only Number and its subtypes
    static <T extends Number> double sum(List<T> list) {
        return list.stream().mapToDouble(Number::doubleValue).sum();
    }

    public static void main(String[] args) {
        // Without generics (raw type) — compile/runtime type issues
        List rawList = new ArrayList();
        rawList.add("hello");
        rawList.add(42); // no error, but inconsistent

        // With generics — type-safe
        List<String> strings = new ArrayList<>();
        strings.add("Alice");
        strings.add("Bob");
        // strings.add(42); // Compile Error: incompatible types — caught early

        String s = strings.get(0); // no cast needed
        System.out.println("First: " + s);

        // Generic class
        Box<Integer> intBox = new Box<>(42);
        Box<String>  strBox = new Box<>("Hello");
        System.out.println(intBox);
        System.out.println(strBox);

        // Generic pair
        Pair<String, Integer> person = new Pair<>("Alice", 30);
        System.out.println("Person: " + person);

        // Generic method
        Integer[] nums = {1, 2, 3, 4, 5};
        String[]  words = {"Java", "Generics", "Rock"};
        printArray(nums);
        printArray(words);

        // Bounded type
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Sum: " + sum(intList));
    }
}
