// Variables - Named containers that store data values
// Syntax: type variableName = value;

public class Main {
    public static void main(String[] args) {
        int age = 25;             // integer number
        double price = 19.99;    // decimal number
        boolean isActive = true; // true or false
        char grade = 'A';        // single character (single quotes)
        String name = "Alice";   // text (double quotes) — reference type

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Price: " + price);
        System.out.println("Active: " + isActive);
        System.out.println("Grade: " + grade);

        // Variables can be reassigned (unless declared final)
        age = 26;
        System.out.println("Updated age: " + age);

        // Multiple declarations of the same type on one line
        int x = 5, y = 10, z = 15;
        System.out.println("Sum: " + (x + y + z));

        // final variable — value cannot change after assignment
        final double TAX_RATE = 0.18;
        System.out.println("Tax rate: " + TAX_RATE);
    }
}
