// Naming Conventions — Java's standard style rules for naming identifiers
// Following these makes code universally readable by Java developers

// Classes and Interfaces — PascalCase (UpperCamelCase)
class BankAccount {}
class StudentRecord {}
interface Printable {}

// Enums — PascalCase
enum DayOfWeek { MONDAY, TUESDAY, WEDNESDAY }

public class Main {

    // Constants — UPPER_SNAKE_CASE (static final)
    static final int    MAX_SIZE      = 100;
    static final String DEFAULT_NAME  = "Unknown";
    static final double TAX_RATE      = 0.18;

    // Instance/static variables — camelCase
    int    studentAge;
    String firstName;
    boolean isActive;

    // Methods — camelCase, usually a verb
    void printDetails()     {}
    boolean isEligible()    { return true; }
    String getFirstName()   { return firstName; }
    void   setFirstName(String firstName) { this.firstName = firstName; }

    public static void main(String[] args) {
        // Local variables — camelCase
        int    itemCount  = 5;
        String userName   = "Alice";
        double totalPrice = 199.99;

        System.out.println("=== Java Naming Conventions ===");
        System.out.println("Class:     PascalCase     → BankAccount, StudentRecord");
        System.out.println("Interface: PascalCase     → Printable, Serializable");
        System.out.println("Method:    camelCase verb → printDetails(), isEligible()");
        System.out.println("Variable:  camelCase      → itemCount, userName");
        System.out.println("Constant:  UPPER_SNAKE    → MAX_SIZE, TAX_RATE");
        System.out.println("Package:   lowercase      → com.example.app");
        System.out.println();
        System.out.println("Max size: "   + MAX_SIZE);
        System.out.println("Tax rate: "   + TAX_RATE);
        System.out.println("User: "       + userName);
        System.out.println("Total price: " + totalPrice);
    }
}
