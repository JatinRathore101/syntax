// Enum (Enumeration) — A special class representing a fixed set of named constants
// Type-safe: compiler prevents assigning invalid values
// Better than using int constants (0, 1, 2...) or String literals

// Simple enum
enum Direction {
    NORTH, SOUTH, EAST, WEST
}

// Enum with fields and methods
enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS  (4.869e+24, 6.0518e6),
    EARTH  (5.976e+24, 6.37814e6),
    MARS   (6.421e+23, 3.3972e6);

    private final double mass;   // kg
    private final double radius; // meters

    Planet(double mass, double radius) {
        this.mass   = mass;
        this.radius = radius;
    }

    static final double G = 6.67300E-11;

    double surfaceGravity()  { return G * mass / (radius * radius); }
    double surfaceWeight(double otherMass) { return otherMass * surfaceGravity(); }
}

enum OrderStatus {
    PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED;

    boolean isFinal() {
        return this == DELIVERED || this == CANCELLED;
    }
}

public class Main {
    public static void main(String[] args) {
        // Basic enum usage
        Direction dir = Direction.NORTH;
        System.out.println("Direction: " + dir);

        // Enum in switch
        switch (dir) {
            case NORTH -> System.out.println("Going North!");
            case SOUTH -> System.out.println("Going South!");
            default    -> System.out.println("Going " + dir);
        }

        // Enum methods: name(), ordinal(), values()
        System.out.println("Name:    " + dir.name());     // "NORTH"
        System.out.println("Ordinal: " + dir.ordinal());  // 0

        System.out.print("All directions: ");
        for (Direction d : Direction.values()) System.out.print(d + " ");
        System.out.println();

        // Enum.valueOf — String → enum
        Direction east = Direction.valueOf("EAST");
        System.out.println("valueOf: " + east);

        // Enum with fields
        double earthWeight = 75.0;
        double mass        = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %-8s: %6.2f N%n",
                              p, p.surfaceWeight(mass));
        }

        // Enum with method
        OrderStatus status = OrderStatus.DELIVERED;
        System.out.println(status + " is final: " + status.isFinal());
    }
}
