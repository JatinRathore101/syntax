// Dependency Injection (DI) — A design pattern where a class receives its
// dependencies from the outside, rather than creating them itself
// Makes code: loosely coupled, testable, and easy to swap implementations
// Frameworks like Spring do DI automatically via @Autowired

// --- Without DI: tightly coupled ---
class HardCodedEmailService {
    void send(String msg) { System.out.println("Email: " + msg); }
}

class BadOrderService {
    // Creates its own dependency — hard to test or swap
    HardCodedEmailService emailService = new HardCodedEmailService();

    void placeOrder(String item) {
        System.out.println("Order placed: " + item);
        emailService.send("Your order for " + item + " is confirmed.");
    }
}

// --- With DI: loosely coupled ---
interface NotificationService {
    void send(String message);
}

class EmailNotification implements NotificationService {
    @Override public void send(String msg) { System.out.println("Email: " + msg); }
}

class SmsNotification implements NotificationService {
    @Override public void send(String msg) { System.out.println("SMS: " + msg); }
}

class OrderService {
    private final NotificationService notifier;

    // Constructor injection — dependency provided from outside
    OrderService(NotificationService notifier) {
        this.notifier = notifier;
    }

    void placeOrder(String item) {
        System.out.println("Order placed: " + item);
        notifier.send("Your order for " + item + " is confirmed.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Without DI
        BadOrderService bad = new BadOrderService();
        bad.placeOrder("Laptop");

        System.out.println();

        // With DI — inject Email notification
        OrderService emailOrder = new OrderService(new EmailNotification());
        emailOrder.placeOrder("Phone");

        System.out.println();

        // Swap to SMS without changing OrderService at all!
        OrderService smsOrder = new OrderService(new SmsNotification());
        smsOrder.placeOrder("Tablet");

        System.out.println();
        System.out.println("DI benefits:");
        System.out.println("  - Easy to swap implementations");
        System.out.println("  - Easy to inject mocks in unit tests");
        System.out.println("  - Classes have single responsibility");
        System.out.println("  - Spring @Autowired automates constructor injection");
    }
}
