// Single Inheritance — One class extends exactly one other class
// Java only supports single class inheritance (no multiple class inheritance)
// to avoid the "Diamond Problem"

// Base class
class Vehicle {
    String brand;
    int    speed;

    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    void move() {
        System.out.println(brand + " is moving at " + speed + " km/h");
    }

    void stop() {
        System.out.println(brand + " has stopped.");
    }
}

// Car extends Vehicle — single, direct inheritance
class Car extends Vehicle {
    int doors;

    Car(String brand, int speed, int doors) {
        super(brand, speed);  // initialize parent fields
        this.doors = doors;
    }

    void honk() {
        System.out.println(brand + " goes beep beep!");
    }

    void displayInfo() {
        System.out.println("Car: " + brand + " | Speed: " + speed +
                           " km/h | Doors: " + doors);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 120, 4);
        car.displayInfo();

        // Inherited from Vehicle
        car.move();
        car.stop();

        // Car-specific
        car.honk();

        // Single inheritance chain: Car → Vehicle → Object
        // Every class in Java implicitly extends Object
        System.out.println("Class name: " + car.getClass().getSimpleName());
        System.out.println("Parent: "     + car.getClass().getSuperclass().getSimpleName());
    }
}
