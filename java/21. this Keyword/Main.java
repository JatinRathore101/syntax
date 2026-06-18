// 'this' Keyword — Refers to the current instance of the class
// Three main uses: disambiguate fields, call other constructors, return self

class Rectangle {
    double width;
    double height;

    // Use 1: 'this.field' distinguishes instance field from parameter
    Rectangle(double width, double height) {
        this.width  = width;   // 'this.width' = field, 'width' = parameter
        this.height = height;
    }

    // Use 2: this() calls another constructor — must be the very first line
    Rectangle() {
        this(1.0, 1.0); // delegates to Rectangle(double, double)
        System.out.println("Default 1×1 rectangle created via constructor chaining");
    }

    double area() {
        return this.width * this.height; // 'this' optional here but explicit
    }

    // Use 3: return 'this' to enable fluent method chaining
    Rectangle setWidth(double width) {
        this.width = width;
        return this;
    }

    Rectangle setHeight(double height) {
        this.height = height;
        return this;
    }

    void print() {
        System.out.println("Rectangle: " + width + " × " + height +
                           " | Area: " + area());
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 3);
        r1.print();

        Rectangle r2 = new Rectangle(); // triggers constructor chaining
        r2.print();

        // Method chaining via 'return this'
        new Rectangle(1, 1).setWidth(10).setHeight(4).print();
    }
}
