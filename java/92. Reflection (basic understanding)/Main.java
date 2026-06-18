// Reflection — Inspect and manipulate classes, methods, and fields at RUNTIME
// Useful for frameworks (Spring, Hibernate, JUnit) to work generically with classes
// Part of java.lang.reflect package

import java.lang.reflect.*;

class Employee {
    private String name;
    public  int    salary;

    public Employee(String name, int salary) {
        this.name   = name;
        this.salary = salary;
    }

    public String getName() { return name; }

    public void work(String task) {
        System.out.println(name + " is working on: " + task);
    }

    private void secretMethod() {
        System.out.println("This is private!");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Employee emp = new Employee("Alice", 75000);

        // Get the Class object — the entry point for reflection
        Class<?> cls = emp.getClass();
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple:     " + cls.getSimpleName());

        // Inspect fields
        System.out.println("\n-- Fields --");
        for (Field f : cls.getDeclaredFields()) {
            System.out.println("  " + Modifier.toString(f.getModifiers()) +
                               " " + f.getType().getSimpleName() + " " + f.getName());
        }

        // Inspect methods
        System.out.println("\n-- Methods --");
        for (Method m : cls.getDeclaredMethods()) {
            System.out.println("  " + m.getName() + "(" +
                               m.getParameterCount() + " params)");
        }

        // Invoke a public method dynamically
        Method workMethod = cls.getMethod("work", String.class);
        workMethod.invoke(emp, "reflection demo");

        // Access a private field (breaks encapsulation — use carefully)
        Field nameField = cls.getDeclaredField("name");
        nameField.setAccessible(true); // override private access
        System.out.println("Private name via reflection: " + nameField.get(emp));
        nameField.set(emp, "Bob");
        System.out.println("After setting name: " + emp.getName());

        // Invoke a private method
        Method secret = cls.getDeclaredMethod("secretMethod");
        secret.setAccessible(true);
        secret.invoke(emp);

        System.out.println("\nFrameworks like Spring use reflection to:");
        System.out.println("  - Scan classes and instantiate beans");
        System.out.println("  - Inject @Autowired dependencies");
        System.out.println("  - Call @RequestMapping handler methods");
    }
}
