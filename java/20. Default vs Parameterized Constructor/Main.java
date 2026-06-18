// Default vs Parameterized Constructor
// Default:      no arguments, sets placeholder/default values
// Parameterized: accepts arguments to customize the object at creation time

class Student {
    String name;
    int    rollNumber;
    String course;

    // Default constructor — useful when caller doesn't have data yet
    Student() {
        name       = "Unknown";
        rollNumber = 0;
        course     = "Not Enrolled";
    }

    // Parameterized constructor — caller provides specific values
    Student(String name, int rollNumber, String course) {
        this.name       = name;
        this.rollNumber = rollNumber;
        this.course     = course;
    }

    // Partial constructor (constructor overloading)
    Student(String name) {
        this.name       = name;
        this.rollNumber = 0;
        this.course     = "General";
    }

    void display() {
        System.out.printf("Name: %-10s | Roll: %3d | Course: %s%n",
                          name, rollNumber, course);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();                          // default
        Student s2 = new Student("Alice", 101, "CS");       // parameterized
        Student s3 = new Student("Bob");                     // partial

        s1.display();
        s2.display();
        s3.display();

        // Best practice: always define an explicit default constructor
        // if you also define a parameterized one — Java won't add it automatically.
    }
}
