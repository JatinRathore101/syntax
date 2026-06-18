// Polymorphism — "Many forms"
// One interface, many implementations
// Compile-time polymorphism: Method Overloading (same name, different params)
// Runtime polymorphism:      Method Overriding (parent ref → child object)

class Notification {
    void send(String message) {
        System.out.println("Sending: " + message);
    }
}

class EmailNotification extends Notification {
    @Override
    void send(String message) {
        System.out.println("EMAIL → " + message);
    }
}

class SmsNotification extends Notification {
    @Override
    void send(String message) {
        System.out.println("SMS → " + message);
    }
}

class PushNotification extends Notification {
    @Override
    void send(String message) {
        System.out.println("PUSH → " + message);
    }
}

public class Main {

    // Compile-time polymorphism: method overloading
    static void print(int n)    { System.out.println("int: "    + n); }
    static void print(String s) { System.out.println("String: " + s); }
    static void print(double d) { System.out.println("double: " + d); }

    public static void main(String[] args) {
        // Compile-time: compiler picks the right print() based on argument type
        print(42);
        print("hello");
        print(3.14);

        // Runtime polymorphism: parent reference holds child object
        // The actual method called is determined at runtime
        Notification n1 = new EmailNotification();
        Notification n2 = new SmsNotification();
        Notification n3 = new PushNotification();

        Notification[] notifications = {n1, n2, n3};
        for (Notification n : notifications) {
            n.send("Hello, User!"); // calls correct version at runtime
        }
    }
}
