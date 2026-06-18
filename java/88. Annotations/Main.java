// Annotations — Metadata attached to code elements (class, method, field, parameter)
// They do NOT change program logic; they provide info to the compiler or runtime tools
// Built-in: @Override, @Deprecated, @SuppressWarnings, @FunctionalInterface
// Frameworks (Spring, JUnit) define their own: @Autowired, @Test, @Entity, etc.

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define a custom annotation
@Retention(RetentionPolicy.RUNTIME)  // available at runtime via reflection
@Target(ElementType.METHOD)          // can only annotate methods
@interface LogExecution {
    String description() default ""; // annotation element with default
}

class TaskService {

    @LogExecution(description = "Sends a welcome email")
    public void sendWelcomeEmail() {
        System.out.println("Sending welcome email...");
    }

    @LogExecution(description = "Processes payment")
    public void processPayment() {
        System.out.println("Processing payment...");
    }

    public void internalHelper() {
        System.out.println("Helper (not annotated)");
    }
}

class Animal {
    public String sound() { return "..."; }
}

class Dog extends Animal {
    @Override  // tells compiler: this method must exist in a parent class
    public String sound() { return "Woof"; }
}

public class Main {
    public static void main(String[] args) throws Exception {
        // @Override example
        Dog dog = new Dog();
        System.out.println("Dog sound: " + dog.sound());

        // @Deprecated — warns callers that a method should not be used
        @SuppressWarnings("deprecation") // suppress the deprecation warning
        String result = new String("hello"); // String(String) is not deprecated, but shows pattern

        // Custom annotation read via reflection
        TaskService service = new TaskService();
        for (Method method : service.getClass().getMethods()) {
            if (method.isAnnotationPresent(LogExecution.class)) {
                LogExecution annotation = method.getAnnotation(LogExecution.class);
                System.out.println("@LogExecution on " + method.getName() +
                                   ": " + annotation.description());
                method.invoke(service); // actually call the method
            }
        }

        System.out.println("\nCommon annotations in the wild:");
        System.out.println("  @Override          → compiler check");
        System.out.println("  @Deprecated        → marks old/unsupported API");
        System.out.println("  @SuppressWarnings  → silences compiler warnings");
        System.out.println("  @FunctionalInterface → enforces SAM contract");
        System.out.println("  @Test (JUnit)      → marks a test method");
        System.out.println("  @Autowired (Spring)→ dependency injection");
    }
}
