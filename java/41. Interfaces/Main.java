// Interfaces — A pure contract (what to do, not how)
// All methods are public abstract by default
// A class can implement MULTIPLE interfaces (unlike extends which is single)
// Java 8+: interfaces can have default and static methods

interface Flyable {
    void fly();  // abstract by default
    default void land() {
        System.out.println("Landing...");  // default method with body (Java 8+)
    }
}

interface Swimmable {
    void swim();
}

// A class can implement multiple interfaces
class Duck implements Flyable, Swimmable {
    String name;
    Duck(String name) { this.name = name; }

    @Override
    public void fly() { System.out.println(name + " flaps and flies!"); }

    @Override
    public void swim() { System.out.println(name + " paddles in the water."); }
}

// Interface for a service contract
interface Printable {
    void print();
}

interface Savable {
    void save();
}

class Document implements Printable, Savable {
    String content;
    Document(String content) { this.content = content; }

    @Override public void print() { System.out.println("Printing: " + content); }
    @Override public void save()  { System.out.println("Saving: "   + content); }
}

public class Main {
    public static void main(String[] args) {
        Duck duck = new Duck("Donald");
        duck.fly();
        duck.swim();
        duck.land();  // inherited default method from Flyable

        System.out.println();

        Document doc = new Document("Hello World");
        doc.print();
        doc.save();

        // Interface reference (polymorphism)
        Flyable f = new Duck("Daffy");
        f.fly();
    }
}
