// Custom Exceptions — Create domain-specific exception types
// Extend RuntimeException → unchecked (caller doesn't have to catch)
// Extend Exception        → checked  (caller must catch or declare)

// Checked custom exception
class InsufficientFundsException extends Exception {
    double amount;

    InsufficientFundsException(double amount) {
        super("Insufficient funds. Short by: $" + amount);
        this.amount = amount;
    }
}

// Unchecked custom exception
class InvalidAgeException extends RuntimeException {
    InvalidAgeException(int age) {
        super("Invalid age: " + age + ". Must be 18-65.");
    }
}

class BankAccount {
    private double balance;

    BankAccount(double balance) { this.balance = balance; }

    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance); // checked
        }
        balance -= amount;
        System.out.printf("Withdrew $%.2f. Balance: $%.2f%n", amount, balance);
    }

    double getBalance() { return balance; }
}

class Person {
    void setAge(int age) {
        if (age < 18 || age > 65) {
            throw new InvalidAgeException(age); // unchecked
        }
        System.out.println("Age set: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        // Checked — must handle
        BankAccount acc = new BankAccount(100);
        try {
            acc.withdraw(50);
            acc.withdraw(80); // will fail — only $50 left
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.printf("Short by: $%.2f%n", e.amount);
        }

        // Unchecked — optional handling
        Person p = new Person();
        p.setAge(30);
        try {
            p.setAge(200); // throws InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
