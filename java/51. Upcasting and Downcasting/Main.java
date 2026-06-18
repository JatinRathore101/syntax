// Upcasting:   child → parent reference (automatic, always safe)
// Downcasting: parent → child reference (manual cast, can throw ClassCastException)
// Use 'instanceof' to safely check before downcasting

class Animal {
    void eat() { System.out.println("Animal eating"); }
}

class Dog extends Animal {
    @Override
    void eat() { System.out.println("Dog eating"); }
    void bark() { System.out.println("Woof!"); }
}

class Cat extends Animal {
    @Override
    void eat() { System.out.println("Cat eating"); }
    void meow() { System.out.println("Meow!"); }
}

public class Main {
    public static void main(String[] args) {
        // --- Upcasting (widening) — implicit ---
        Dog dog    = new Dog();
        Animal a   = dog;   // Dog → Animal; no cast needed
        a.eat();            // calls Dog's eat() via dynamic dispatch
        // a.bark();        // Compile Error: Animal ref doesn't know about bark()

        // --- Downcasting (narrowing) — explicit ---
        Animal ref = new Dog(); // upcast
        Dog d = (Dog) ref;      // downcast back to Dog — safe because it IS a Dog
        d.bark();               // now we can call bark()

        // --- ClassCastException risk ---
        Animal cat = new Cat();
        // Dog badCast = (Dog) cat;  // throws ClassCastException at runtime!

        // --- Safe downcasting with instanceof ---
        Animal[] animals = { new Dog(), new Cat(), new Dog() };
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                ((Dog) animal).bark();
            } else if (animal instanceof Cat) {
                ((Cat) animal).meow();
            }
        }

        // Java 16+ pattern matching — cleaner instanceof + cast
        Animal x = new Dog();
        if (x instanceof Dog safeDog) {
            safeDog.bark(); // no separate cast needed
        }
    }
}
