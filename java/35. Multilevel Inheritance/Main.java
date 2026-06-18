// Multilevel Inheritance — A chain of inheritance: A → B → C
// Each class inherits from the one above it in the chain

// Level 1: Grandparent
class Animal {
    void breathe() {
        System.out.println("Breathing...");
    }
}

// Level 2: Parent inherits from Animal
class Mammal extends Animal {
    void feedMilk() {
        System.out.println("Feeding milk to young.");
    }
}

// Level 3: Child inherits from Mammal (and indirectly from Animal)
class Dog extends Mammal {
    void bark() {
        System.out.println("Woof!");
    }
}

// Another example: Shape → TwoDShape → Circle
class Shape {
    void draw() { System.out.println("Drawing a shape"); }
}

class TwoDShape extends Shape {
    double area() { return 0; }
}

class Circle extends TwoDShape {
    double radius;
    Circle(double r) { this.radius = r; }

    @Override
    double area() { return Math.PI * radius * radius; }

    @Override
    void draw() { System.out.println("Drawing a circle with radius " + radius); }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();

        // Inherited from all levels of the chain
        dog.breathe();    // from Animal (level 1)
        dog.feedMilk();   // from Mammal (level 2)
        dog.bark();       // from Dog    (level 3)

        Circle c = new Circle(5);
        c.draw();
        System.out.printf("Area: %.2f%n", c.area());

        // Inheritance chain: Dog → Mammal → Animal → Object
        Class<?> cls = dog.getClass();
        while (cls != null) {
            System.out.print(cls.getSimpleName() + " → ");
            cls = cls.getSuperclass();
        }
        System.out.println("null");
    }
}
