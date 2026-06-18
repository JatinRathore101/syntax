// Inheritance — A child class acquires fields and methods of a parent class
// Keyword: extends | Promotes code reuse; child can add or override behaviour
// Java supports single inheritance for classes (one parent at a time)

// Parent class (Superclass)
class Animal {
    String name;
    int    age;

    Animal(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    void eat() {
        System.out.println(name + " is eating.");
    }

    void sleep() {
        System.out.println(name + " is sleeping.");
    }

    void describe() {
        System.out.println("Animal: " + name + ", Age: " + age);
    }
}

// Child class (Subclass) — inherits all non-private members of Animal
class Dog extends Animal {
    String breed;

    Dog(String name, int age, String breed) {
        super(name, age); // call parent constructor first
        this.breed = breed;
    }

    // Additional behaviour specific to Dog
    void bark() {
        System.out.println(name + " says: Woof!");
    }

    @Override
    void describe() {
        super.describe();  // reuse parent's describe
        System.out.println("Breed: " + breed);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3, "Labrador");

        // Inherited methods from Animal
        dog.eat();
        dog.sleep();

        // Overridden method
        dog.describe();

        // Dog-specific method
        dog.bark();

        // Dog IS-A Animal — can be assigned to Animal reference
        Animal a = new Dog("Max", 2, "Poodle");
        a.eat();    // inherited
        a.describe(); // calls Dog's overridden version (polymorphism)
    }
}
