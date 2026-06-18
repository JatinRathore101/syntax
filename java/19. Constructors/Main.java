// Constructors — Special methods called automatically when an object is created
// Rules: same name as the class, no return type

class Person {
    String name;
    int    age;

    // Constructor initializes the object's state
    Person(String name, int age) {
        this.name = name;  // 'this' differentiates field from parameter
        this.age  = age;
    }

    void introduce() {
        System.out.println("Hi, I'm " + name + " and I'm " + age + " years old.");
    }
}

class Counter {
    int count;

    // No-arg constructor — sets a safe default state
    Counter() {
        count = 0;
        System.out.println("Counter initialized to 0");
    }

    void increment() { count++; }
    void show()      { System.out.println("Count: " + count); }
}

public class Main {
    public static void main(String[] args) {
        // Constructor is called automatically with 'new'
        Person alice = new Person("Alice", 30);
        Person bob   = new Person("Bob", 25);
        alice.introduce();
        bob.introduce();

        Counter c = new Counter(); // calls no-arg constructor
        c.increment();
        c.increment();
        c.show();

        // If you don't write any constructor, Java provides a default no-arg one.
        // Once you define any constructor, Java stops providing the default.
    }
}
