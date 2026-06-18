// Encapsulation — One of the 4 pillars of OOP
// Bundle data (fields) + behaviour (methods) together,
// and hide internal state by making fields private.
// Expose only what is necessary through public methods.

class Employee {
    // Private fields — internal state, hidden from outside
    private String name;
    private double salary;
    private int    age;

    public Employee(String name, double salary, int age) {
        this.name = name;
        setSalary(salary);
        setAge(age);
    }

    // Public getters — read-only access
    public String getName()   { return name; }
    public double getSalary() { return salary; }
    public int    getAge()    { return age; }

    // Public setters — controlled write access with business rules
    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Salary must be non-negative.");
        } else {
            this.salary = salary;
        }
    }

    public void setAge(int age) {
        if (age < 18 || age > 65) {
            System.out.println("Age must be between 18 and 65.");
        } else {
            this.age = age;
        }
    }

    public void displayInfo() {
        System.out.printf("%-10s | Age: %2d | Salary: $%.2f%n",
                          name, age, salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Bob", 55000, 30);
        emp.displayInfo();

        emp.setSalary(-1000); // rejected — salary stays 55000
        emp.setAge(70);       // rejected — age stays 30
        emp.displayInfo();

        emp.setSalary(60000); // valid update
        emp.displayInfo();

        // Fields are protected from direct modification:
        // emp.salary = 99999; // Compile Error: salary has private access
    }
}
