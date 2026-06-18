// Dynamic Method Dispatch — The mechanism behind runtime polymorphism
// When a parent-type reference calls an overridden method,
// Java decides WHICH implementation to run at runtime based on the actual object type

class Payment {
    void process() {
        System.out.println("Processing generic payment");
    }
}

class CreditCard extends Payment {
    @Override
    void process() {
        System.out.println("Processing Credit Card payment");
    }
}

class PayPal extends Payment {
    @Override
    void process() {
        System.out.println("Processing PayPal payment");
    }
}

class UPI extends Payment {
    @Override
    void process() {
        System.out.println("Processing UPI payment");
    }
}

public class Main {
    public static void main(String[] args) {
        // The reference type is Payment, but the actual objects differ
        Payment p;

        p = new CreditCard();  // parent ref → CreditCard object
        p.process();           // dispatched to CreditCard.process() at runtime

        p = new PayPal();      // same reference, different object
        p.process();           // dispatched to PayPal.process() at runtime

        p = new UPI();
        p.process();           // dispatched to UPI.process()

        System.out.println();

        // A method that accepts the parent type works for ALL subtypes
        processPayment(new CreditCard());
        processPayment(new PayPal());
        processPayment(new UPI());
    }

    // This method doesn't need to know the concrete type — dispatch handles it
    static void processPayment(Payment payment) {
        System.out.print("Checkout: ");
        payment.process(); // correct version called dynamically
    }
}
