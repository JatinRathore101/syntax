// final Keyword — Prevents modification
// final variable: value cannot change after assignment
// final method:   cannot be overridden by subclasses
// final class:    cannot be extended (subclassed)

// final class — cannot be extended
final class ImmutablePoint {
    final double x;   // final field — must be set in constructor
    final double y;

    ImmutablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() { return "(" + x + ", " + y + ")"; }
}

class Vehicle {
    // final method — subclass cannot override this
    final void startEngine() {
        System.out.println("Engine started.");
    }

    void drive() {
        System.out.println("Driving...");
    }
}

class Car extends Vehicle {
    @Override
    void drive() {
        System.out.println("Car is driving.");
    }
    // startEngine() cannot be overridden here — compile error if you try
}

public class Main {
    // Compile-time constant — static final
    static final double PI      = 3.14159;
    static final int    MAX_AGE = 120;

    public static void main(String[] args) {
        // final variable
        final int speed = 100;
        // speed = 200; // Compile Error: cannot assign a value to a final variable

        System.out.println("PI = " + PI);
        System.out.println("Max age = " + MAX_AGE);

        ImmutablePoint p = new ImmutablePoint(3.0, 4.0);
        System.out.println("Point: " + p);
        // p.x = 5.0; // Compile Error: x is final

        Car car = new Car();
        car.startEngine();  // from Vehicle — cannot be overridden
        car.drive();        // overridden in Car

        // String in Java is a final class — cannot be subclassed
        System.out.println("String is final: " + String.class.getName());
    }
}
