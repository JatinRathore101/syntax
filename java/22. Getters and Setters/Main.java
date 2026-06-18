// Getters and Setters — Controlled, validated access to private fields
// Getter: reads a field | Setter: validates then updates a field

class BankAccount {
    private String owner;
    private double balance;  // private — cannot be accessed directly from outside

    BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        setBalance(initialBalance); // validate even in constructor
    }

    // Getters — provide read access
    public String getOwner()   { return owner; }
    public double getBalance() { return balance; }

    // Setters — validate before updating
    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Error: balance cannot be negative.");
            return;
        }
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Alice", 1000.0);

        System.out.println("Owner:   " + acc.getOwner());
        System.out.println("Balance: " + acc.getBalance());

        acc.deposit(500);
        System.out.println("After deposit:   " + acc.getBalance());

        acc.withdraw(200);
        System.out.println("After withdrawal: " + acc.getBalance());

        acc.setBalance(-500);               // rejected by setter
        System.out.println("Balance unchanged: " + acc.getBalance());

        // Direct access is NOT allowed — compile error if uncommented:
        // acc.balance = 99999;  // Error: balance has private access
    }
}
