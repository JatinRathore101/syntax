// Classes and Objects — The foundation of Object-Oriented Programming
// Class = blueprint/template; Object = instance created from the blueprint

// Define a Car class (blueprint)
class Car {
    // Fields — the state/attributes of a Car
    String brand;
    String model;
    int    year;
    double speed;

    // Methods — the behavior of a Car
    void accelerate(double amount) {
        speed += amount;
        System.out.println(brand + " accelerates to " + speed + " km/h");
    }

    void brake() {
        speed = 0;
        System.out.println(brand + " stopped.");
    }

    void displayInfo() {
        System.out.println(year + " " + brand + " " + model);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create objects using 'new' — each gets its own copy of fields
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.model = "Camry";
        car1.year  = 2022;
        car1.speed = 0;

        Car car2 = new Car();
        car2.brand = "Honda";
        car2.model = "Civic";
        car2.year  = 2023;
        car2.speed = 0;

        car1.displayInfo();
        car2.displayInfo();

        car1.accelerate(60);
        car2.accelerate(80);
        car1.brake();

        // Reference types: two variables can point to the same object
        Car ref = car1;            // ref and car1 point to the SAME object
        ref.brand = "Toyota Modified";
        System.out.println(car1.brand); // "Toyota Modified" — same object changed
    }
}
