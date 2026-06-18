// Abstract Classes — Cannot be instantiated directly
// May contain abstract methods (no body) that subclasses MUST implement
// May also contain concrete methods with implementation
// Use when classes share common structure but differ in specific behaviour

abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    // Abstract method — no body; every subclass must implement it
    abstract double area();
    abstract double perimeter();

    // Concrete method — shared by all subclasses
    void describe() {
        System.out.printf("%s %s | area=%.2f | perimeter=%.2f%n",
                          color, getClass().getSimpleName(), area(), perimeter());
    }
}

class Circle extends Shape {
    double radius;
    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override double area()      { return Math.PI * radius * radius; }
    @Override double perimeter() { return 2 * Math.PI * radius; }
}

class Rectangle extends Shape {
    double width, height;
    Rectangle(String color, double w, double h) {
        super(color);
        this.width = w; this.height = h;
    }

    @Override double area()      { return width * height; }
    @Override double perimeter() { return 2 * (width + height); }
}

public class Main {
    public static void main(String[] args) {
        // Shape s = new Shape("red"); // Compile Error: cannot instantiate abstract class

        Shape[] shapes = {
            new Circle("Red", 5),
            new Rectangle("Blue", 4, 6)
        };

        for (Shape s : shapes) {
            s.describe();
        }
    }
}
