// Method Overriding — Child class provides its own version of a parent method
// Same name, same parameters, same return type
// Resolved at RUNTIME (dynamic dispatch) — this is runtime polymorphism

class Shape {
    // Parent version — acts as a default/fallback
    double area() {
        return 0;
    }

    void describe() {
        System.out.println("I am a shape. Area = " + area());
    }
}

class Circle extends Shape {
    double radius;
    Circle(double r) { this.radius = r; }

    @Override   // @Override annotation catches typos at compile time
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }

    @Override
    double area() {
        return w * h;
    }
}

class Triangle extends Shape {
    double base, height;
    Triangle(double b, double h) { this.base = b; this.height = h; }

    @Override
    double area() {
        return 0.5 * base * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 8)
        };

        // At runtime, Java calls the ACTUAL object's version of area()
        for (Shape s : shapes) {
            System.out.printf("%-12s area = %.2f%n",
                              s.getClass().getSimpleName(), s.area());
        }

        // Using super to call parent method from child
        Circle c = new Circle(7);
        c.describe(); // describe() calls the overridden area() from Circle
    }
}
