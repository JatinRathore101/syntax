// 'super' Keyword — Refers to the immediate parent class
// Three uses: call parent constructor, access parent fields, call parent methods

class Person {
    String name;
    int    age;

    Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    void introduce() {
        System.out.println("Hi, I'm " + name + ", age " + age);
    }
}

class Employee extends Person {
    String company;
    double salary;

    Employee(String name, int age, String company, double salary) {
        super(name, age);  // Use 1: call parent constructor (must be first line)
        this.company = company;
        this.salary  = salary;
    }

    @Override
    void introduce() {
        super.introduce();  // Use 2: call parent method, then extend it
        System.out.println("  Works at " + company + ", earns $" + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String name, int age, String company, double salary, int teamSize) {
        super(name, age, company, salary); // chain through Employee to Person
        this.teamSize = teamSize;
    }

    @Override
    void introduce() {
        super.introduce(); // calls Employee.introduce() which calls Person.introduce()
        System.out.println("  Manages a team of " + teamSize);
    }
}

public class Main {
    public static void main(String[] args) {
        Manager m = new Manager("Alice", 40, "Acme Corp", 120000, 8);
        m.introduce();

        System.out.println();

        Employee e = new Employee("Bob", 28, "TechCo", 75000);
        e.introduce();
    }
}
